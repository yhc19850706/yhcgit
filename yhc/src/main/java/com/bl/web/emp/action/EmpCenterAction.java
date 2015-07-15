package com.bl.web.emp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.http.HTTPException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bl.web.common.action.BaseAction;
import com.bl.web.common.config.BlGlobalVariable;
import com.bl.web.common.model.Emp;
import com.bl.web.common.model.Page;
import com.bl.web.common.model.Performance;
import com.bl.web.common.model.RegistMobile;
import com.bl.web.common.model.Trade;
import com.bl.web.common.model.User;
import com.bl.web.common.model.UserInfo;
import com.bl.web.common.utils.DateUtils;
import com.bl.web.emp.service.EmpService;

@Controller
public class EmpCenterAction extends BaseAction{

	@Resource
	private EmpService empService;
	
	@RequestMapping(value = "/emp/center.bl")
	public ModelAndView emp_list(@RequestParam(required = false) String empNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(empNo)){
			String authId = getAuthId();
			if("5".equals(authId)){
				throw new HTTPException(403);
			}
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/emp_perform_detail");
			
		}else{
			empId=getEmpId();
			mav.setViewName("center/center_page");
		}
		Emp emp=new Emp();
		emp.setEmpId(empId);
		pMap.put("emp", emp);
		pMap.put("storeCode", getStoreCode());
		Performance perf=empService.getEmpPerformance(pMap);
		if(perf==null){
			throw new HTTPException(403);
		}
		mav.addObject("emp", perf);
		Page page = new Page();
		pMap.put("page", page);
		pMap.put("empId", empId);
		Map<String, Object> rsltMap= empService.getBindingUserList(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("userList", (ArrayList<UserInfo>)rsltMap.get("list"));
		mav.addObject("page", page);
		mav.addObject("siteUrl",BlGlobalVariable.SITE_URL);
		
		return mav;
	}
	
	@RequestMapping(value = "/ajax/binding_user.bl")
	public ModelAndView ajax_binding_list(@RequestParam(required = false) String empNo,
			@RequestParam(required = false) Integer pageNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(empNo)){
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/emp_sub_binding_user");
		}else{
			empId=getEmpId();
			mav.setViewName("center/sub_binding_user");
		}
		pMap.put("empId", empId);
		Page page = new Page();
		page.setPageNo(pageNo);
		pMap.put("page", page);
		Map<String, Object> rsltMap= empService.getBindingUserList(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("userList", (ArrayList<UserInfo>)rsltMap.get("list"));
		mav.addObject("page", page);
		
		return mav;
	}
	
	@RequestMapping(value = "/ajax/visitor_user.bl")
	public ModelAndView ajax_vistor_list(@RequestParam(required = false) String empNo,
			@RequestParam(required = false) Integer pageNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(empNo)){
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/emp_sub_visitor_user");
		}else{
			empId=getEmpId();
			mav.setViewName("center/sub_visitor_user");
		}
		pMap.put("empId", empId);
		Page page = new Page();
		page.setPageNo(pageNo);
		pMap.put("page", page);
		Map<String, Object> rsltMap= empService.getVisitorUserList(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("userList", (ArrayList<RegistMobile>)rsltMap.get("list"));
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping(value = "/ajax/regist_user.bl")
	public ModelAndView ajax_regist_list(@RequestParam(required = false) String empNo,
			@RequestParam(required = false) Integer pageNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(empNo)){
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/emp_sub_regist_user");
		}else{
			empId=getEmpId();
			mav.setViewName("center/sub_regist_user");
		}
		pMap.put("empId", empId);
		Page page = new Page();
		page.setPageNo(pageNo);
		pMap.put("page", page);
		Map<String, Object> rsltMap= empService.getRegistUserList(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("userList", (ArrayList<UserInfo>)rsltMap.get("list"));
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping(value = "/trade/month_expire_repay.bl")
	public ModelAndView month_expire_repay(@RequestParam(required = true) String userId,@RequestParam(required = false) String empNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(userId)){
			pMap.put("userId", userId);
			mav.addObject("userId", userId);
		}
		if(StringUtils.isNotBlank(empNo)){
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/month_expire_trade_list");
		}else{
			empId=getEmpId();
			mav.setViewName("center/month_expire_trade_list");
		}
		pMap.put("empId", empId);
		UserInfo userInfo=empService.getUserInfoById(userId);
		if(userInfo!=null){
			mav.addObject("user", userInfo);
			Page page = new Page();
			pMap.put("page", page);
			Map<String, Object> rsltMap= empService.getMonthExpireRepay(pMap);
			page.setTotalRecords((Integer)rsltMap.get("cnt"));
			mav.addObject("tradeList", (ArrayList<Trade>)rsltMap.get("list"));
			mav.addObject("page", page);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/ajax/month_expire_repay.bl")
	public ModelAndView ajax_month_expire_repay(@RequestParam(required = true) String userId,@RequestParam(required = false) String empNo,
			@RequestParam(required = false) Integer pageNo) throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId="";
		if(StringUtils.isNotBlank(userId)){
			pMap.put("userId", userId);
			mav.addObject("userId", userId);
		}
		if(StringUtils.isNotBlank(empNo)){
			empId=empNo;
			mav.addObject("empNo", empNo);
			mav.setViewName("performance/emp_sub_expire_trade");
		}else{
			empId=getEmpId();
			mav.setViewName("center/sub_expire_trade");
		}
		pMap.put("empId", empId);
		Page page = new Page();
		page.setPageNo(pageNo);
		pMap.put("page", page);
		Map<String, Object> rsltMap= empService.getMonthExpireRepay(pMap);
		page.setTotalRecords((Integer)rsltMap.get("cnt"));
		mav.addObject("tradeList", (ArrayList<Trade>)rsltMap.get("list"));
		mav.addObject("page", page);
		return mav;
	}
	
	@RequestMapping(value = "/ajax/remove_visitor.bl")
	public ModelAndView removeVisitor(@RequestParam(required = true) String mobileNo,@RequestParam(required = true) String remark)throws Exception {
		ModelAndView mav = super.getModelAndView();
		Map<String, Object> pMap = new HashMap<String, Object>();
		String empId=getEmpId();
		RegistMobile rgm=new RegistMobile();
		rgm.setMobileNo(mobileNo);
		rgm.setUpdateId(empId);
		rgm.setUpdateDts(DateUtils.getCurDtsStr());
		rgm.setRemark(remark);
		empService.removeVistor(rgm);
		mav=super.getRedirectModelAndView("/ajax/visitor_user.bl");
		return mav;
	}
	
}
