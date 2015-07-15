package com.bl.web.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.bl.web.common.model.XmphAuthMenu;

public class XmphAuthUtils {

	public static List<XmphAuthMenu> getMenuList(String storeAuthId, String teamAuthId) throws Exception {
		List<XmphAuthMenu> storeAuthMenuList = ContextUtil.getXmphAuthMenuMapList().get(storeAuthId);
		List<XmphAuthMenu> teamAuthMenuList = ContextUtil.getXmphAuthMenuMapList().get(teamAuthId);

		List<String> menuList = new ArrayList<String>();
		List<XmphAuthMenu> xmphMenuList = new ArrayList<XmphAuthMenu>();
		
		if (storeAuthMenuList != null && storeAuthMenuList.size() > 0) {
			for (XmphAuthMenu xmphAuthMenu : storeAuthMenuList) {
				if (!menuList.contains(xmphAuthMenu.getMenuId() + "")) {
					menuList.add(xmphAuthMenu.getMenuId() + "");
					xmphMenuList.add(xmphAuthMenu);
				}
			}
		}
		
		if (teamAuthMenuList != null && teamAuthMenuList.size() > 0) {
			for (XmphAuthMenu xmphAuthMenu : teamAuthMenuList) {
				if (!menuList.contains(xmphAuthMenu.getMenuId() + "")) {
					menuList.add(xmphAuthMenu.getMenuId() + "");
					xmphMenuList.add(xmphAuthMenu);
				}
			}
		}

		return xmphMenuList;
	}
	
	public static List<Integer> getUriList(String authId) throws Exception {
		List<XmphAuthMenu> storeAuthMenuList = ContextUtil.getXmphAuthUriMapList().get(authId);
		
		List<Integer> menuIdList = new ArrayList<Integer>();
		List<XmphAuthMenu> xmphMenuList = new ArrayList<XmphAuthMenu>();
		
		if (storeAuthMenuList != null && storeAuthMenuList.size() > 0) {
			for (XmphAuthMenu xmphAuthMenu : storeAuthMenuList) {
				if (!menuIdList.contains(xmphAuthMenu.getMenuId())) {
					menuIdList.add(xmphAuthMenu.getMenuId());
					xmphMenuList.add(xmphAuthMenu);
				}
			}
		}
		
		return menuIdList;
	}
}
