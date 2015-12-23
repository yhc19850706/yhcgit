package com.yhc.web.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;
import com.yhc.web.user.dao.UserDao;
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	
	@Override
	public SysUser getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.yhc.web.user.getUserByUserId", userId);
	}

	@Override
	public SysUser selectByUsername(String loginName) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.yhc.web.user.selectByUsername", loginName);
	}

	@Override
	public SysUser authentication(SysUser user){
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.yhc.web.user.authentication", user);
	}

	@Override
	public void addUserInfo(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("com.yhc.web.user.addUserInfo", user);
	}
	
	
	

}
