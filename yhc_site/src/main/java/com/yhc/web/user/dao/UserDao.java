package com.yhc.web.user.dao;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.SysUser;

public interface UserDao {
	public SysUser getUserByUserId(String userId) throws Exception;
	public SysUser selectByUsername(String loginName) throws Exception;
	public void addUserInfo(SysUser user) throws Exception;
	public SysUser authentication(SysUser user);
	public void updateUserInfo(SysUser user) throws Exception;

	public List<SysUser> getSysUserList(Map<String, Object> paraMap) throws Exception;

	public int getSysUserListCnt(Map<String, Object> paraMap) throws Exception;
}
