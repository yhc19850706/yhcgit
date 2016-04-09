
package com.yhc.common.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yhc.common.config.BlGlobalVariable;
import com.yhc.common.utils.BlCookieUtil;
import com.yhc.common.utils.CipherUtil;
import com.yhc.common.utils.Constants;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.weixin.model.AccessToken;
import com.yhc.weixin.util.JsUtil;
@Controller
public class BaseAction {
	protected Log logger = LogFactory.getLog(BaseAction.class);
	@Resource(name = "accTokenService")
	private AccTokenService accTokenService;
	protected ModelAndView getModelAndView() {
		ModelAndView modelAndView = new ModelAndView();		
		return modelAndView;
	}

	protected ModelAndView getRedirectModelAndView(String url) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new RedirectView(url));
		return modelAndView;
	}
	
	protected ModelAndView getAlertNBackModelAndView(String msg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(Constants.ALTMSG, msg);
		modelAndView.setViewName("common/alert_back");
		return modelAndView;
	}

	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	

 public String getJSSDKConfig(HttpServletRequest request) throws Exception{
	String queryStr = request.getQueryString();
	StringBuffer ub = request.getRequestURL();
	if(StringUtils.isNotBlank(queryStr)){
		ub = ub.append("?").append(queryStr);
	}
	AccessToken accessToken = accTokenService.addCurrentAccessToken();
	String ticket =accessToken.getJsapiTicket();
	return JsUtil.generateConfigJson(ticket, false, BlGlobalVariable.WEIXIN_APPID, ub.toString(), "onMenuShareTimeline","onMenuShareAppMessage");
}

 public String getJSSDKConfigForHideMenu(HttpServletRequest request) throws Exception{
	String queryStr = request.getQueryString();
	StringBuffer ub = request.getRequestURL();
	if(StringUtils.isNotBlank(queryStr)){
		ub = ub.append("?").append(queryStr);
	}
	AccessToken accessToken = accTokenService.addCurrentAccessToken();
	String ticket =accessToken.getJsapiTicket();
	return JsUtil.generateConfigJson(ticket, false, BlGlobalVariable.WEIXIN_APPID, ub.toString(), "hideOptionMenu");
}
}

	