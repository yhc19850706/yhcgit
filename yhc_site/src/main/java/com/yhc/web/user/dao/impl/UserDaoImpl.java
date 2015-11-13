package com.yhc.web.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.UserInfo;
import com.yhc.web.user.dao.UserDao;
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	
	@Override
	public UserInfo getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.yhc.web.user.getUserByUserId", userId);
	}
	
	
	

}
