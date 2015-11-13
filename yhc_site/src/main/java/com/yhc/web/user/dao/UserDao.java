package com.yhc.web.user.dao;

import com.yhc.common.model.UserInfo;

public interface UserDao {
	public UserInfo getUserByUserId(String userId);
}
