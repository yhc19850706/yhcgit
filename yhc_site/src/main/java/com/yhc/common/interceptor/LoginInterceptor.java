package com.yhc.common.interceptor;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yhc.common.utils.BlCookieUtil;
import com.yhc.common.utils.CipherUtil;
import com.yhc.common.utils.Constants;
import com.yhc.common.utils.CookieUtils;

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
		String userId =CookieUtils.getCookie(request, response, Constants.COOKIE_YHC_UID);
		for (String url : excludedUrls) {
			if (requestUri.indexOf(url) >= 0) {
				logger.info("start check login goto click url");
				return super.preHandle(request, response, handler);
			}
		}
        
        if (StringUtils.isBlank(userId)) {
        	response.sendRedirect("/user/login_page.yhc");
			return false;
		} else {
			
			String empId = CipherUtil.decryptResult(CookieUtils.getCookie(request,  Constants.COOKIE_YHC_UID));
			String empNm = CipherUtil.decryptResult(CookieUtils.getCookie(request,  Constants.COOKIE_YHC_UNM));
			long expireTimeMillis = System.currentTimeMillis();
			
			CookieUtils.addCookie(response, Constants.COOKIE_YHC_UID, CipherUtil.encryptResult(empId), "/", Constants.COOKIE_MAX_TIME_HALF_HOUR);
            CookieUtils.addCookie(response,Constants.COOKIE_YHC_UNM,CipherUtil.encryptResult(empNm),"/",  Constants.COOKIE_MAX_TIME_HALF_HOUR);
			CookieUtils.addCookie(response, Constants.COOKIE_YHC_TIME, String.valueOf(expireTimeMillis),"/",  Constants.COOKIE_MAX_TIME_HALF_HOUR);
			return super.preHandle(request, response, handler);
		}
        
	}
	
}
