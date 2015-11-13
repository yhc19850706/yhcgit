package com.yhc.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.yhc.common.config.BlGlobalVariable;

public class BlCookieUtil {

	public static void addCookie(HttpServletResponse response, String name, String value, int max) {
		if (StringUtils.isNotBlank(value)) {
			//response.addHeader("Set-Cookie"," Domain=local.yinhu.com; Path=/; Max-Age=" + max +"; " + name + "=" + value+ "; expires = 0; HTTPOnly;");
			String expires = DateUtils.getGMTDateStr(max * 1000);
			response.addHeader("Set-Cookie",name + "=" + value+";expires="+expires+";Max-Age="+max+";Domain="+BlGlobalVariable.SITE_DOMAIN+";Path=/;HTTPOnly;");
		} else {
			response.addHeader("Set-Cookie", name + "=;expires=0;Max-Age=" + max + ";Domain="+BlGlobalVariable.SITE_DOMAIN+";Path=/;HTTPOnly");
		}
	}
	
	public static void addCookie(HttpServletResponse response, String name, String value) {
		if (StringUtils.isNotBlank(value)) {
			response.addHeader("Set-Cookie", name + "=" + value +";Domain="+BlGlobalVariable.SITE_DOMAIN+";Path=/;HTTPOnly");
		} else {
			response.addHeader("Set-Cookie", name + "=;Domain="+BlGlobalVariable.SITE_DOMAIN+"Path=/;HTTPOnly");
		}
	}
	
	public static String getCookieName(HttpServletRequest request, String name) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie != null) {
			return cookie.getName();
		} else {
			return "";
		}
	}

	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie cookie = getCookieByName(request, name);

		if (cookie != null) {
			return cookie.getValue();
		} else {
			return "";
		}
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String name) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie != null) {
			addCookie(response, cookie.getName(), null, 0);
		}
	}

	public static void deleteAllCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				addCookie(response, cookie.getName(), null, 0);
			}
		}
	}
	
	public static String getCookieValue(HttpServletRequest request,
			HttpServletResponse response, String name) {
		Cookie cookie = getCookieByName(request, name);
		Cookie cookieTime = getCookieByName(request, Constants.COOKIE_BL_TIME);
		
		if (cookie != null && cookieTime != null) {
			long startTimeMilies = ContextUtil.getServerStartTimeMili();
			//ie 的时候 
			if (StringUtils.isNotEmpty(cookieTime.getValue()) && !"null".equals(cookieTime.getValue()) && Long.parseLong(cookieTime.getValue()) <= startTimeMilies) {
				deleteCookie(request, response, name);
				deleteCookie(request, response, Constants.COOKIE_BL_UID);
				deleteCookie(request, response, Constants.COOKIE_BL_UNM);
				deleteCookie(request, response, Constants.COOKIE_BL_AUTH);
				deleteCookie(request, response, Constants.COOKIE_BL_TIME);
				return null;
			} else {
				return cookie.getValue();
			}
		} else {
			deleteCookie(request, response, name);
			deleteCookie(request, response, Constants.COOKIE_BL_UID);
			deleteCookie(request, response, Constants.COOKIE_BL_UNM);
			deleteCookie(request, response, Constants.COOKIE_BL_AUTH);
			deleteCookie(request, response, Constants.COOKIE_BL_TIME);
			return null;
		}
	}



}
