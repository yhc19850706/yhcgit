package com.yhc.web.user.service;

import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;

public interface UserService {

	public SysUser getUserByUserId(String userId) throws Exception;

	public SysUser selectByUsername(String loginName) throws Exception;

	public SysUser authentication(SysUser user);

	public void addUserInfo(SysUser user) throws Exception;
}
