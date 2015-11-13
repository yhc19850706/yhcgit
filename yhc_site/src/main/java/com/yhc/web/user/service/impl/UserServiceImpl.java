package com.yhc.web.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yhc.common.model.UserInfo;
import com.yhc.web.user.dao.UserDao;
import com.yhc.web.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public UserInfo getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userId);
	}

}
