package com.bl.web.common.interceptor;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bl.web.common.utils.BlCookieUtil;
import com.bl.web.common.utils.CipherUtil;
import com.bl.web.common.utils.Constants;
import com.bl.web.common.utils.ContextUtil;
import com.bl.web.common.utils.XmphAuthUtils;

public class EmpAuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(EmpAuthInterceptor.class);
	private List<String> excludedUrls;
	private String ajaxRegex = "^[/]ajax[/][a-z0-9A-Z_]+[.]bl.*$";
	
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
		logger.debug("<<<<<<<<<<<<<<<<<<<<<<<<<      start EmpAuthInterceptor     >>>>>>>>>>>>>>>>>>>>>>>>>>");
		String reqMethod = request.getMethod();
		
		if("GET".equalsIgnoreCase(reqMethod)){
			String requestUri = request.getRequestURI();
			
			Pattern pattern = Pattern.compile(ajaxRegex);
			if(pattern.matcher(requestUri).matches()){
				logger.debug("<<<<<<<<<<<<<<<<<<<<<<<<<      ajax     >>>>>>>>>>>>>>>>>>>>>>>>>>");
				return super.preHandle(request, response, handler);
			}
			
			
			for (String url : excludedUrls) {
				if (requestUri.indexOf(url) >= 0) {
					logger.debug("<<<<<<<<<<<<<<<     EmpAuthInterceptor excludedUrls     >>>>>>>>>>>>>>>>>>");
					return super.preHandle(request, response, handler);
				}
			}
			
			String empAuth = CipherUtil.decryptResult(BlCookieUtil.getCookieValue(request, response, Constants.COOKIE_BL_AUTH));
			
			if (StringUtils.isNotBlank(empAuth)) {
				logger.debug("<<<<<<<<<<<<<<<     EmpAuthInterceptor have empAuth     >>>>>>>>>>>>>>>>>>");
				
				String authId = null;
				
				String[] authIds = empAuth.split("_");
				
				if (authIds != null && authIds.length == 2 && authIds[0].compareTo("0") > 0) {
					authId = authIds[0];
				}
				String action = request.getRequestURI();
				
				List<Integer> menuIdList = XmphAuthUtils.getUriList(authId);
				Integer menuId = ContextUtil.getUriMenuId().get(action);
				
				boolean isAuthUrl = false;
				if (menuIdList != null && menuIdList.size() > 0) {
					if (menuIdList.contains(menuId)) {         
						isAuthUrl = true;                                  
					}                                                    
				}
				
				if (isAuthUrl) {
					logger.debug("<<<<<<<<<<<<<<<     EmpAuthInterceptor emp have this action auth     >>>>>>>>>>>>>>>>>>");
					return super.preHandle(request, response, handler);
				} else {
					String redirectUrl = "/error.bl?statusCode=403";
					response.sendRedirect(redirectUrl);
					logger.debug("<<<<<<<<<<<<<<<     EmpAuthInterceptor reqMethod=["+reqMethod+"]   from  "+requestUri+"    redirect to " + redirectUrl + "     >>>>>>>>>>>>>>>>>>");
					return false;
				}
				
			} else {
				logger.debug("<<<<<<<<<<<<<<<     EmpAuthInterceptor not have  empAuth      >>>>>>>>>>>>>>>>>>");
				response.sendRedirect("/login_page.bl");
				return false;
			}
		} else {
			return super.preHandle(request, response, handler);
		}
	}
}
