package com.yhc.web.menu.service;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.SysMenu;

public interface SysMenuService {

	public List<SysMenu> selectPermissionsByRoleId(String id);
	public List<SysMenu> selectMenusByRoleId(String userId) throws Exception;
}
