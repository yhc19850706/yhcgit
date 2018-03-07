package com.yhc.weixin.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.yhc.lifeall.common.config.WeixinConfig;
import com.yhc.weixin.api.TokenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Component
public class AccessTokenUtil {
	@Autowired
	private static WeixinConfig weixinConfig;

	private static Cache<String, String> cache = CacheBuilder
			.newBuilder()
			.expireAfterWrite(7000, TimeUnit.SECONDS)
			.build(); 


	private static TokenAPI tokenAPI = new TokenAPI();

	public static String getAccessToken(){
		try {
			return cache.get(weixinConfig.getTOKEN_KEY(),new Callable<String>() {
				@Override
				public String call() throws Exception {
					return tokenAPI.token(weixinConfig.getWEIXIN_APPID(), weixinConfig.getWEIXIN_SECRET()).getAccess_token();
				}
			});
		} catch (Exception e) {
			return "";
		}
	}

}
