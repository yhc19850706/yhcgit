package com.yhc.common.mapper;

import com.yhc.weixin.model.AccessToken;

public interface AccTokenMapper{
	
	AccessToken getAccessToken() throws Exception;
	void insertAccessToken(AccessToken accToken) throws Exception;
	void updateAccessTokenById(AccessToken accToken) throws Exception;
}
