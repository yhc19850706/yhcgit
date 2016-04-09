package com.yhc.web.weixin.service;

import com.yhc.weixin.model.AccessToken;

public interface AccTokenService {
	public AccessToken addCurrentAccessToken() throws Exception;
}
