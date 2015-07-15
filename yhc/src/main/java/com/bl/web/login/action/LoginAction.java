package com.bl.web.login.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bl.web.common.action.BaseAction;
import com.bl.web.common.model.Emp;
import com.bl.web.common.utils.BlCookieUtil;
import com.bl.web.common.utils.CipherUtil;
import com.bl.web.common.utils.Constants;
import com.bl.web.emp.service.EmpService;

@Controller
public class LoginAction  extends BaseAction {
	
	@Resource(name = "empService")
	private EmpService empService;
	
	@RequestMapping(value = "/login_page.bl")
	public ModelAndView login_page() throws Exception {
		ModelAndView mav = super.getModelAndView();
		String empId = BlCookieUtil.getCookieValue(getRequest(), Constants.COOKIE_BL_REUNM);
		if (StringUtils.isNotBlank(empId)) {
		    mav.addObject("empId", empId);
		}
		mav.setViewName("login/login");
		return mav;
	}
	
    /**
     * 用户登录
     * @param user
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/login.bl", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("emp") Emp emp,HttpServletResponse response, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Emp empInfo = empService.checkEmp(emp);
		if( empInfo == null ) {
			mav.addObject(Constants.ALTMSG, "用户名或密码错误");
			mav.setViewName("common/alert_back");
			return mav;
		}
		long expireTimeMillis = System.currentTimeMillis();
     	BlCookieUtil.addCookie(response,Constants.COOKIE_BL_UID,CipherUtil.encryptResult(empInfo.getEmpId()), Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	BlCookieUtil.addCookie(response,Constants.COOKIE_BL_UNM,CipherUtil.encryptResult(empInfo.getEmpNm()), Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	BlCookieUtil.addCookie(response,Constants.COOKIE_BL_AUTH,CipherUtil.encryptResult(empInfo.getAuthId()+"_"+empInfo.getStoreCode()), Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	BlCookieUtil.addCookie(response, Constants.COOKIE_BL_TIME, String.valueOf(expireTimeMillis), Constants.COOKIE_MAX_TIME_HALF_HOUR);
		mav.setView(new RedirectView("/main.bl"));
		return mav;
		
	}
	
	@RequestMapping(value = "/main.bl")
	public ModelAndView main(HttpServletResponse response, HttpServletRequest request) throws Exception{
		ModelAndView mav = super.getModelAndView();

		mav.setViewName("main/main");
		return mav;
		
	}
	
	/**
	 * 用户退出
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout.bl")
	public String logout(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		String userId = super.getEmpId();
		
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("userId", userId);
		paraMap.put("apprYn", "N");
		
		BlCookieUtil.deleteCookie(request, response, Constants.COOKIE_BL_UID);
		BlCookieUtil.deleteCookie(request, response, Constants.COOKIE_BL_UNM);
		BlCookieUtil.deleteCookie(request, response, Constants.COOKIE_BL_AUTH);
		BlCookieUtil.deleteCookie(request, response, Constants.COOKIE_BL_TIME);
		return "redirect:/login_page.bl";
	}
	
}
