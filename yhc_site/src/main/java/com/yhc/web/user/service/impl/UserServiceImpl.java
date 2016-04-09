package com.yhc.web.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;
import com.yhc.web.user.dao.UserDao;
import com.yhc.web.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public SysUser getUserByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(userId);
	}
	@Override
	public SysUser selectByUsername(String loginName) throws Exception{
		// TODO Auto-generated method stub
		return userDao.selectByUsername(loginName);
	}
	@Override
	public SysUser authentication(SysUser user){
		// TODO Auto-generated method stub
		return userDao.authentication(user);
	}
	@Override
	public void addUserInfo(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUserInfo(user);
	}
	@Override
	public void updateUserInfo(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateUserInfo(user);
	}
	@Override
	public List<SysUser> getSysUserList(Map<String, Object> paraMap)
			throws Exception {
		// TODO Auto-generated method stub
		return userDao.getSysUserList(paraMap);
	}
	@Override
	public int getSysUserListCnt(Map<String, Object> paraMap) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getSysUserListCnt(paraMap);
	}

}
