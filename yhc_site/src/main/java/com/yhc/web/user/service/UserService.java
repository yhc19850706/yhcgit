package com.yhc.web.user.service;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;

public interface UserService {

	public SysUser getUserByUserId(String userId) throws Exception;

	public SysUser selectByUsername(String loginName) throws Exception;

	public SysUser authentication(SysUser user);

	public void addUserInfo(SysUser user) throws Exception;
	
	public void updateUserInfo(SysUser user) throws Exception;

	public List<SysUser> getSysUserList(Map<String, Object> paraMap) throws Exception;

	public int getSysUserListCnt(Map<String, Object> paraMap) throws Exception;
}
