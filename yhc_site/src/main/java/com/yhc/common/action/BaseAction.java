
package com.yhc.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.yhc.common.model.AuthMenu;
import com.yhc.common.utils.BlCookieUtil;
import com.yhc.common.utils.CipherUtil;
import com.yhc.common.utils.Constants;
import com.yhc.common.utils.ContextUtil;
import com.yhc.web.menu.service.SysMenuService;
@Controller
public class BaseAction {
	protected Log logger = LogFactory.getLog(BaseAction.class);

	@Resource(name = "menuService")
	protected SysMenuService menuService;
	
	protected ModelAndView getModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			String authId = getAuthId();
			String storeCode = getStoreCode();
			String userNm = getEmpNm();
			if (StringUtils.isNotBlank(userNm)) {
				modelAndView.addObject("baseUserNm", userNm);
			}
			if (StringUtils.isNotBlank(authId)) {
				modelAndView.addObject("userAuth", authId);
			}
			if (StringUtils.isNotBlank(storeCode)) {
				modelAndView.addObject("userStoreCode", storeCode);
			}

			List<AuthMenu> MenuList = getMenuList("1");
			
			List<Map<String, Object>> parentMenuList = getParentMenuList(MenuList);
			modelAndView.addObject("parentMenuList", parentMenuList);
			modelAndView.addObject("MenuList", MenuList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	protected String getEmpId() throws Exception {
		String encrypt = BlCookieUtil.getCookieValue(getRequest(), Constants.COOKIE_BL_UID);
		if (StringUtils.isBlank(encrypt)) {
			return null;
		}
		return CipherUtil.decryptResult(encrypt);
	}

	/**
	 * 从cookie里获得当前登录用户的AuthId
	 * @return
	 * @throws Exception
	 */
	private String getCookieAuthId() throws Exception {
		String encrypt = BlCookieUtil.getCookieValue(getRequest(), Constants.COOKIE_BL_AUTH);
		if (StringUtils.isBlank(encrypt)) {
			return null;
		}
		return CipherUtil.decryptResult(encrypt);
	}

	protected String getAuthId() throws Exception {
		String cookieAutthId = getCookieAuthId();
		if (StringUtils.isBlank(cookieAutthId))
			return null;
		String[] authIds = cookieAutthId.split("_");
		
		if (authIds[0].compareTo("0") > 0)
			return authIds[0];
		return null;
	}
	
	protected String getStoreCode() throws Exception {
		String cookieAutthId = getCookieAuthId();
		if (StringUtils.isBlank(cookieAutthId))
			return null;
		String[] authIds = cookieAutthId.split("_");
		
		if (authIds.length==2)
			return authIds[1];
		return null;
	}
	
	/**
	 * 从cookie里获得当前登录用户的EmpNm
	 * @return
	 * @throws Exception
	 */
	protected String getEmpNm() throws Exception {
		String encrypt = BlCookieUtil.getCookieValue(getRequest(), Constants.COOKIE_BL_UNM);
		if (StringUtils.isBlank(encrypt)) {
			return null;
		}
		return CipherUtil.decryptResult(encrypt);
	}
	
	private List<AuthMenu> getMenuList(String authId) throws Exception {
		List<AuthMenu> storeMenuList = ContextUtil.getAuthMenuMapList().get(authId);

		if ((storeMenuList == null || storeMenuList.size() == 0) && StringUtils.isNotBlank(authId)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("authId", authId);
			map.put("delYn", "N");
			map.put("authDelYn", "N");
			map.put("menuDelYn", "N");
			map.put("dispYn", "Y");
			storeMenuList = menuService.getAuthMenuList(map);
		}
		
		List<String> menuList = new ArrayList<String>();
		List<AuthMenu> MenuList = new ArrayList<AuthMenu>();
		
		if (storeMenuList != null && storeMenuList.size() > 0) {
			for (AuthMenu AuthMenu : storeMenuList) {
				if (!menuList.contains(AuthMenu.getMenuId() + "")) {
					menuList.add(AuthMenu.getMenuId() + "");
					MenuList.add(AuthMenu);
				}
			}
		}

		return MenuList;
	}

	private List<Map<String, Object>> getParentMenuList(List<AuthMenu> menuList) throws Exception {
		List<Map<String, Object>> strList = new ArrayList<Map<String, Object>>();

		if (menuList != null && menuList.size() > 0) {

			List<String> nameList = new ArrayList<String>();
			List<String> tagList = new ArrayList<String>();

			for (int i = 0; i < menuList.size(); i++) {

				if (!nameList.contains(menuList.get(i).getParentMenuNm())) {
					nameList.add(menuList.get(i).getParentMenuNm());
					tagList.add(menuList.get(i).getMenuTagNm().substring(0, menuList.get(i).getMenuTagNm().indexOf("_")));
				}

			}

			for (int i = 0; i < nameList.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", nameList.get(i));
				map.put("tag", tagList.get(i));
				strList.add(map);
			}

		}
		return strList;
	}
}

	