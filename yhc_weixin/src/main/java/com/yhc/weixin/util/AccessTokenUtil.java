package com.yhc.weixin.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.yhc.weixin.api.TokenAPI;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_APPID;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_SECRET;

public class AccessTokenUtil {

	private static final String TOKEN_KEY = "token";

	private static Cache<String, String> cache =CacheBuilder
			.newBuilder()
			.expireAfterWrite(7000, TimeUnit.SECONDS)
			.build(); 


	private static TokenAPI tokenAPI = new TokenAPI();

	public static String getAccessToken(){
		try {
			return cache.get(TOKEN_KEY,new Callable<String>() {
				@Override
				public String call() throws Exception {
					return tokenAPI.token(WEIXIN_APPID, WEIXIN_SECRET).getAccess_token();
				}
			});
		} catch (Exception e) {
			return "";
		}
	}

}
