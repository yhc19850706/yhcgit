package com.yhc.web.user.dao;

import com.yhc.common.model.SysUser;

public interface UserDao {
	public SysUser getUserByUserId(String userId) throws Exception;
	public SysUser selectByUsername(String loginName) throws Exception;

	public SysUser authentication(SysUser user);
}
