package com.yhc.web.menu.service;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.SysMenu;

public interface SysMenuService {

	public List<SysMenu> selectPermissionsByRoleId(String id);
	public List<AuthMenu> getAuthMenuList(Map<String, Object> map);
}
