package com.yhc.web.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yhc.common.dao.BaseDao;
import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;
import com.yhc.web.user.dao.UserDao;
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	public static String PREFIX="com.yhc.web.user.";
	@Override
	public SysUser getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(PREFIX+"getUserByUserId", userId);
	}

	@Override
	public SysUser selectByUsername(String loginName) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(PREFIX+"selectByUsername", loginName);
	}

	@Override
	public SysUser authentication(SysUser user){
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(PREFIX+"authentication", user);
	}

	@Override
	public void addUserInfo(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(PREFIX+"addUserInfo", user);
	}

	@Override
	public void updateUserInfo(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlSession().update(PREFIX+"updateUserInfo", user);
	}

	@Override
	public List<SysUser> getSysUserList(Map<String, Object> paraMap)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(PREFIX+"getSysUserList",paraMap);
	}

	@Override
	public int getSysUserListCnt(Map<String, Object> paraMap) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(PREFIX+"getSysUserListCnt", paraMap);
	}
}
