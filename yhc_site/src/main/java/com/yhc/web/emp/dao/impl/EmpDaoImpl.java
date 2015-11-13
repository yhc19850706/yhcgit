package com.yhc.web.emp.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.Emp;
import com.yhc.web.emp.dao.EmpDao;
@Repository("empDao")
public class EmpDaoImpl extends BaseDao implements EmpDao {

	@Override
	public int deleteByPrimaryKey(String empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Emp selectByPrimaryKey(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Emp record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthMenu> getAuthMenuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("com.yhc.web.emp.getAuthMenuList", map);
	}

}
