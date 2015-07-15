package com.bl.web.emp.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bl.web.common.action.BaseAction;
import com.bl.web.common.config.BlGlobalVariable;
import com.bl.web.common.model.Emp;
import com.bl.web.common.model.Page;
import com.bl.web.common.model.Store;
import com.bl.web.common.model.User;
import com.bl.web.common.model.XmphAuth;
import com.bl.web.common.qrcode.QRCodeUtil;
import com.bl.web.common.utils.Constants;
import com.bl.web.common.utils.ContextUtil;
import com.bl.web.common.utils.DateUtils;
import com.bl.web.common.utils.JsonUtil;
import com.bl.web.common.utils.Md5Util;
import com.bl.web.emp.service.EmpService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class EmpAction extends BaseAction {

	@Resource
	private EmpService empService;
	@RequestMapping(value = "/emp/emp_list.bl")
	public ModelAndView emp_list() throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, List<Store>> commonCodeMapList=ContextUtil.getXmphStoreMapList();
		List<Store> areaList = commonCodeMapList.get("0");
		mav.addObject("areaList", areaList);
		Map<String, Object> pMap = new HashMap<String, Object>();
		Page page = new Page();
		pMap.put("page", page);
		Map<String, Object> rsltMap = empService.getEmpList(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("empList", (ArrayList<Emp>)rsltMap.get("list"));
		mav.addObject("page", page);
		mav.setViewName("admin/emp_list");
		return mav;
	}
	
	@RequestMapping(value = "/ajax/emp_list.bl")
	public ModelAndView ajax_emp_list(@ModelAttribute("emp") Emp emp, @RequestParam(required = false) Integer pageNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		Page page = new Page();
		page.setPageNo(pageNo);
		pMap.put("page", page);
		
		if(StringUtils.isNotEmpty(emp.getStoreCode())){
			pMap.put("storeCode", emp.getStoreCode());
			mav.addObject("storeCode", emp.getStoreCode());
		}else if(StringUtils.isNotEmpty(emp.getCityCode())){
			pMap.put("storeCode", emp.getCityCode());
			mav.addObject("cityCode", emp.getCityCode());
		}else if(StringUtils.isNotEmpty(emp.getAreaCode())){
			pMap.put("storeCode", emp.getAreaCode());
			mav.addObject("areaCode", emp.getAreaCode());
		}
		
		if(StringUtils.isNotEmpty(emp.getEmpNm())){
			pMap.put("empNm", emp.getEmpNm());
			mav.addObject("empNm", emp.getEmpNm());
		}
		if(StringUtils.isNotEmpty(emp.getEmpId())){
			pMap.put("empId", emp.getEmpId());
			mav.addObject("empId", emp.getEmpId());
		}
		
		Map<String, Object> rsltMap = empService.getEmpList(pMap);
		
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		
		mav.addObject("empList", (ArrayList<Emp>)rsltMap.get("list"));
		mav.addObject("page", page);
		mav.setViewName("admin/sub_emp_list");
		return mav;
	}
	@RequestMapping(value = "/ajax/get_city.bl")
	public ModelAndView ajax_get_city(String code)throws Exception{
		ModelAndView mav = super.getModelAndView();
		String viewNm = "common/json";
		String jsonStr = "";
	    List<Store> cityList = ContextUtil.getXmphStoreMapList().get(code);
		jsonStr = JsonUtil.listToJson(cityList);
	    mav.addObject("jsonStr", jsonStr);
		mav.setViewName(viewNm);
		return mav;
    }
	
	@RequestMapping(value = "/go_disp_qrcode_emp_img_page.bl")
	public void disp_qrcode_img_page(@RequestParam String qrcode, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ServletOutputStream out = null;
		if (qrcode != null) {
			String contType = Constants.CONTENT_TYPE_MAP.get("jpg");
			response.setContentType(contType);
			response.setHeader("Content-Disposition", "filename=" + qrcode);
			
			String fileDir = BlGlobalVariable.IMG_QRCODE_EMP_DIR + "/" + qrcode;
//			String fileDir = "D:\\qrcode\\xmphcrm\\emp\\" + qrcode;
//			System.out.println("=======================================>" + fileDir);
			try {
				BufferedImage bi = ImageIO.read(new FileInputStream(fileDir));
				out = response.getOutputStream();
				String ext = "jpg";
				ImageIO.write(bi, ext, out);
			} catch (IOException e) {
				logger.error(e);				
			} finally {
				if (out != null) {
					out.flush();
					out.close();
				}
			}
		} else {
			throw new HTTPException(404);
		}
	}
	/**
	 * 下载二维码
	 * @param qrcode
	 * @param qrtype
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/download/qrcode.bl")   
    public ModelAndView download(@RequestParam String qrcode, @RequestParam String qrtype,
		HttpServletRequest request, HttpServletResponse response)throws Exception {    
	response.setContentType("text/html;charset=utf-8");   
	request.setCharacterEncoding("UTF-8");   
	java.io.BufferedInputStream bis = null;   
	java.io.BufferedOutputStream bos = null;
	String ctxPath = BlGlobalVariable.IMG_QRCODE_EMP_DIR; 
	if(StringUtils.isNotBlank(qrtype)){
		if(qrtype.equals("emp")){
			ctxPath=BlGlobalVariable.IMG_QRCODE_EMP_DIR;
		}else if(qrtype.equals("store")){
			ctxPath=BlGlobalVariable.IMG_QRCODE_STORE_DIR;
		}
	}
	   
	String downLoadPath = ctxPath + "/" +  qrcode;   
	System.out.println(downLoadPath);   
	try {    
		long fileLength = new File(downLoadPath).length();    
		response.setContentType("application/x-msdownload;");    
		response.setHeader("Content-disposition", "attachment; filename="      + new String(qrcode.getBytes("utf-8"), "ISO8859-1"));    
		response.setHeader("Content-Length", String.valueOf(fileLength));    
		bis = new BufferedInputStream(new FileInputStream(downLoadPath));    
		bos = new BufferedOutputStream(response.getOutputStream());    
		byte[] buff = new byte[2048];    
		int bytesRead;    
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {     
			bos.write(buff, 0, bytesRead);    
			}    
		
	 } 
	catch (Exception e) {    
		e.printStackTrace();   
		} 
	finally {    
		if (bis != null)     
			bis.close();    
		if (bos != null)     
			bos.close();   
		}    
	return null;   
	}
	@RequestMapping(value = "/emp/add_emp_view.bl")
	public ModelAndView add_emp_view(@ModelAttribute("emp") Emp emp) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, List<Store>> commonCodeMapList=ContextUtil.getXmphStoreMapList();
		List<Store> areaList = commonCodeMapList.get("0");
		mav.addObject("areaList", areaList);
		List<Store> cityList=Lists.newArrayList();
		List<Store> storeList=Lists.newArrayList();
		if(StringUtils.isNotEmpty(emp.getEmpId())){
			emp=empService.getEmployeById(emp.getEmpId());
			if(emp!=null&&StringUtils.isNotBlank(emp.getStoreCode())){
				int length=emp.getStoreCode().length();
				if(length>2){
					cityList=commonCodeMapList.get(emp.getAreaCode());
					mav.addObject("cityList", cityList);
					if(length>4){
						storeList=commonCodeMapList.get(emp.getCityCode());
						mav.addObject("storeList", storeList);
					}
				}
				mav.setViewName("admin/update_emp_view");
			}else{
				mav.setViewName("admin/add_emp_view");
			}
			
		}else{
			mav.setViewName("admin/add_emp_view");
		}
		mav.addObject("emp", emp);
		List<XmphAuth> xmphAuthList = empService.getAllAuthList();
		mav.addObject("xmphAuthList", xmphAuthList);
		return mav;
	}
	
	@RequestMapping(value = "/emp/add_emp.bl", method = RequestMethod.POST)
	public ModelAndView add_emp(@ModelAttribute("emp") Emp emp) throws Exception {
		String pwd = Md5Util.getMD5("000000");
		if(StringUtils.isNotBlank(emp.getAuthType())){
			if(emp.getAuthType().equals("XMPHAUTHTP01")){
				emp.setStoreCode("0");
			} else
			if(emp.getAuthType().equals("XMPHAUTHTP02")){
				if(StringUtils.isBlank(emp.getAreaCode())){
					return super.getAlertNBackModelAndView("请选择大区！");
				}else{
					emp.setStoreCode(emp.getAreaCode());
				}
			} else if(emp.getAuthType().equals("XMPHAUTHTP03")){
				if(StringUtils.isBlank(emp.getAreaCode())||StringUtils.isBlank(emp.getCityCode())){
					return super.getAlertNBackModelAndView("请选择大区和城市！");
				}else{
					emp.setStoreCode(emp.getCityCode());
				}
			}else if(emp.getAuthType().equals("XMPHAUTHTP04")||emp.getAuthType().equals("XMPHAUTHTP05")){
				if(StringUtils.isBlank(emp.getStoreCode())){
					return super.getAlertNBackModelAndView("请选择门店！");
				}
			}
		}else{
			return super.getAlertNBackModelAndView("请选择权限！");
		}
		
		// 员工编号确定
		Emp p=empService.checkEmp(emp);
		if(p==null){
			//生成服务码
			String inviteCode=empService.getMaxInviteCode();
			if(StringUtils.isNumeric(inviteCode)){
				int invite=Integer.parseInt(inviteCode)+1;
				emp.setInviteCode(invite+"");
			}else{
				return super.getAlertNBackModelAndView("服务码生成错误，请联系系统管理员！");
			}
			emp.setEmpPw(pwd);
			emp.setCreateId(getEmpId());
			emp.setCreateDts(DateUtils.getCurDtsStr());
			emp.setQrcode(emp.getEmpId()+"_"+1024+".jpg");
			empService.insertEmploye(emp);
			//生成二维码
			QRCodeUtil.encoderEmpQRCode(emp.getEmpId(), 1024);
		}else{
			return super.getAlertNBackModelAndView("员工编码已经存在，请修改！");
		}
		
		ModelAndView mav = super.getRedirectModelAndView("/emp/emp_list.bl");
		return mav;
	}
	
	@RequestMapping(value = "/emp/update_emp.bl", method = RequestMethod.POST)
	public ModelAndView update_emp(@ModelAttribute("emp") Emp emp) throws Exception {
		String empId = super.getEmpId();
		String curDts = DateUtils.getCurDtsStr();
		Map map=Maps.newHashMap();
		if(StringUtils.isNotBlank(emp.getAuthType())){
			if(emp.getAuthType().equals("XMPHAUTHTP01")){
				emp.setStoreCode("0");
			} else if(emp.getAuthType().equals("XMPHAUTHTP02")){
				if(StringUtils.isBlank(emp.getAreaCode())){
					return super.getAlertNBackModelAndView("请选择大区！");
				}else{
					emp.setStoreCode(emp.getAreaCode());
				}
			} else if(emp.getAuthType().equals("XMPHAUTHTP03")){
				if(StringUtils.isBlank(emp.getAreaCode())||StringUtils.isBlank(emp.getCityCode())){
					return super.getAlertNBackModelAndView("请选择大区和城市！");
				}else{
					emp.setStoreCode(emp.getCityCode());
				}
			}else if(emp.getAuthType().equals("XMPHAUTHTP04")||emp.getAuthType().equals("XMPHAUTHTP05")){
				if(StringUtils.isBlank(emp.getStoreCode())){
					return super.getAlertNBackModelAndView("请选择门店！");
				}
			}
		}else{
			return super.getAlertNBackModelAndView("请选择权限！");
		}
		
		emp.setUpdateId(empId);
		emp.setUpdateDts(curDts);
	    empService.updateEmploye(emp);
		
		ModelAndView mav = super.getRedirectModelAndView("/emp/emp_list.bl");
		return mav;
	}
	
	@RequestMapping(value = "/emp/pw_change.bl")
	public ModelAndView pw_change() throws Exception {
		ModelAndView mav = super.getModelAndView();
		mav.setViewName("admin/pw_change");
		return mav;
	}
	
	@RequestMapping(value = "/ajax/commit_changed_pw.bl")
	public ModelAndView ajax_commit_changed_pw(@ModelAttribute("emp") Emp emp) throws Exception {
		ModelAndView mav = super.getModelAndView();
		String empId = super.getEmpId();
		Emp pEmp = new Emp();
		pEmp.setEmpId(empId);
		Emp existsEmp = empService.checkEmp(pEmp);
		StringBuffer errorMsg=new StringBuffer();
		if(existsEmp == null){
			return super.getAlertNBackModelAndView("您输入的原密码错误！");
		} else {
			if(StringUtils.isNotEmpty(emp.getEmpPw()) && StringUtils.isNotEmpty(emp.getEmpConfirmPw())){
				if(emp.getEmpPw().equals(emp.getEmpConfirmPw())){
					if(emp.getOriEmpPw().equals(emp.getEmpPw())){
						errorMsg.append("您输入的原密码与新密码相同，请输入与原密码不同的新密码！");
					} else {
						Emp updEmp = new Emp();
						updEmp.setUpdateId(empId);
						updEmp.setUpdateDts(DateUtils.getCurDtsStr());
						updEmp.setEmpId(empId);
						updEmp.setEmpPw(Md5Util.getMD5(emp.getEmpPw()));
						empService.updateEmploye(updEmp);
					}
				} else {
					errorMsg.append("您输入的新密码或确认新密码不一致！");
				}
			} else {
				errorMsg.append("您输入的新密码或确认新密码为空值， 请输入新密码或确认新密码！");
			}
		}
		if(errorMsg.length()>0){
			mav.addObject("jsonStr", "{success:false,errorMsg:'"+errorMsg.toString()+"'}");
		}else{
			mav.addObject("jsonStr", "{success:true}");
		}
		
		mav.setViewName("common/json");
		return mav;
	}

	/**
	 * 修改用户所对应的员工
	 * @param code 原邀请码
	 * @param newCode 新邀请码
	 * @param mobileNo 用户手机号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/emp/update_usertoemp.bl")
	public ModelAndView update_usertoemp(@RequestParam String code,@RequestParam String newCode,@RequestParam String mobileNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String,Object> param=Maps.newHashMap();
		param.put("code", code);
		param.put("newCode", newCode);
		param.put("mobileNo", mobileNo);
		User user=empService.getUserInfoByParam(param);
		if(user!=null){
			param.put("userId", user.getUserId());
			empService.updateUserInvideCode(param);
			mav.addObject("jsonStr", "变更成功");
		}else{
			mav.addObject("jsonStr", "无该用户："+mobileNo);
		}
		
		mav.setViewName("common/json");
		return mav;
	}
}
