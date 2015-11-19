package com.yhc.web.role.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.SysRole;
import com.yhc.web.role.dao.SysRoleDao;
@Repository("roleDao")
public class SysRoleDaoImpl extends BaseDao implements SysRoleDao {

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysRole selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysRole> selectRolesByUserId(String id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("com.yhc.web.role.selectRolesByUserId", id);
	}

}
