package com.yhc.web.menu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.SysMenu;
import com.yhc.web.menu.dao.SysMenuDao;
@Repository("menuDao")
public class SysMenuDaoImpl extends BaseDao implements SysMenuDao {

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysMenu selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysMenu> selectPermissionsByRoleId(String id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("com.yhc.web.menu.selectPermissionsByRoleId", id);
	}

	@Override
	public List<AuthMenu> getAuthMenuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("com.yhc.web.menu.getAuthMenuList", map);
	}

}
