
package com.yhc.common.action;

import java.util.List;
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

import com.google.common.collect.Lists;
import com.yhc.common.model.SysMenu;
import com.yhc.common.utils.CipherUtil;
import com.yhc.common.utils.Constants;
import com.yhc.common.utils.CookieUtils;
import com.yhc.web.menu.service.SysMenuService;
@Controller
public class BaseAction {
	protected Log logger = LogFactory.getLog(BaseAction.class);

	@Resource(name = "menuService")
	protected SysMenuService menuService;
	
	protected ModelAndView getModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			String userId = getUserId();
			String userNm = getUserNm();
			if (StringUtils.isNotBlank(userNm)) {
				modelAndView.addObject("baseUserNm", userNm);
			}

			List<SysMenu> menulist=getSysMenusList(userId);
			List<SysMenu> pareMenuList=getParentSysMenusList(menulist);
			modelAndView.addObject("menulist", menulist);
			modelAndView.addObject("pareMenuList", pareMenuList);

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
	
	protected String getUserId() throws Exception {
		String encrypt = CookieUtils.getCookie(getRequest(), Constants.COOKIE_YHC_UID);
		if (StringUtils.isBlank(encrypt)) {
			return null;
		}
		return CipherUtil.decryptResult(encrypt);
	}
	
	/**
	 * 从cookie里获得当前登录用户的loginName
	 * @return
	 * @throws Exception
	 */
	protected String getUserNm() throws Exception {
		String encrypt = CookieUtils.getCookie(getRequest(), Constants.COOKIE_YHC_UNM);
		if (StringUtils.isBlank(encrypt)) {
			return null;
		}
		return CipherUtil.decryptResult(encrypt);
	}
	
	private List<SysMenu> getParentSysMenusList(List<SysMenu> sysMenus) throws Exception {
		List<SysMenu> parentMenuList=Lists.newArrayList();
		if(sysMenus!=null&&sysMenus.size()>0){
			for(SysMenu menu:sysMenus){
				if(StringUtils.isNotBlank(menu.getParentId())&"1".equals(menu.getParentId())){
					parentMenuList.add(menu);
				}
			}
		}
		return parentMenuList;
	}
	
	private List<SysMenu> getSysMenusList(String userId) throws Exception {
		List<SysMenu> menuList=Lists.newArrayList();
		menuList =menuService.selectMenusByRoleId(userId);
		return menuList;
	}
}

	