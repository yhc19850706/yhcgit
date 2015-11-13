/**   
 * DefaultTokenManager.java 
 * com.common.token.impl 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2015年10月27日 下午5:14:12 
 * @version V1.0   
 */

package com.yhc.web.token.service.impl;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.yhc.web.token.service.TokenManager;

@Service("tokenManager")
public class DefaultTokenManager implements TokenManager {

	private static Map<String, String>	tokenMap	= new ConcurrentHashMap<>();

	@Override
	public String createToken(String username) {
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		tokenMap.put(token, username);
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		return !StringUtils.isEmpty(token) && tokenMap.containsKey(token);
	}
}
