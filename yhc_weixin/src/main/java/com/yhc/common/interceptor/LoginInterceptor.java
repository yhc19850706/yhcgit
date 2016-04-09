package com.yhc.common.interceptor;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yhc.common.utils.BlCookieUtil;
import com.yhc.common.utils.Constants;

public class LoginInterceptor extends HandlerInterceptorAdapter{

private static final Logger logger = Logger.getLogger(LoginInterceptor.class);
	

	
	private List<String> excludedUrls;
	 
	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mav) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		String userId = BlCookieUtil.getCookieValue(request, response, Constants.COOKIE_BL_UID);
		for (String url : excludedUrls) {
			if (requestUri.indexOf(url) >= 0) {
				logger.info("start check login goto click url");
				return super.preHandle(request, response, handler);
			}
		}
        
        if (StringUtils.isBlank(userId)) {
        	response.sendRedirect("/re_login_page.bl");
			return false;
		} else {
			
			String empId = BlCookieUtil.getCookieValue(request,  Constants.COOKIE_BL_UID);
			String empNm = BlCookieUtil.getCookieValue(request,  Constants.COOKIE_BL_UNM);
			String empAuth = BlCookieUtil.getCookieValue(request,  Constants.COOKIE_BL_AUTH);
			long expireTimeMillis = System.currentTimeMillis();
			
    		BlCookieUtil.addCookie(response, Constants.COOKIE_BL_UID, empId, Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	    BlCookieUtil.addCookie(response, Constants.COOKIE_BL_UNM, empNm, Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	    BlCookieUtil.addCookie(response, Constants.COOKIE_BL_AUTH, empAuth, Constants.COOKIE_MAX_TIME_HALF_HOUR);
    	    BlCookieUtil.addCookie(response, Constants.COOKIE_BL_TIME, String.valueOf(expireTimeMillis), Constants.COOKIE_MAX_TIME_HALF_HOUR);
    		
			return super.preHandle(request, response, handler);
		}
        
	}
	
}
