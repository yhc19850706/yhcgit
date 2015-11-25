package com.yhc.web.menu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.SysMenu;
import com.yhc.web.menu.dao.SysMenuDao;
import com.yhc.web.menu.service.SysMenuService;
@Service("menuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Resource(name="menuDao")
	private SysMenuDao menuDao;

	@Override
	public List<SysMenu> selectPermissionsByRoleId(String id) {
		// TODO Auto-generated method stub
		return menuDao.selectPermissionsByRoleId(id);
	}

	@Override
	public List<AuthMenu> getAuthMenuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return menuDao.getAuthMenuList(map);
	}

	@Override
	public List<SysMenu> selectMenusByRoleId(String userId) throws Exception{
		// TODO Auto-generated method stub
		return menuDao.selectMenusByRoleId(userId);
	}
}
