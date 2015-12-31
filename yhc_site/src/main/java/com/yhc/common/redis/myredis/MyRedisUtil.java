package com.yhc.common.redis.myredis;

import javax.annotation.Resource;

public class MyRedisUtil {

	@Resource(name="redisClientTemplate")
	private RedisClientTemplate redisClientTemplate;
	
	public String getKeyValue(String key){
		return redisClientTemplate.get(key);
	}
	
	public String setKeyValue(String key,String value){
		return redisClientTemplate.set(key, value);
	}
}
