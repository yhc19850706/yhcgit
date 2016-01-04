package com.yhc.common.redis.myredis;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;

import com.yhc.common.utils.JacksonUtil;

import redis.clients.jedis.Jedis;

public class MyRedisUtil {

	private static String keyPrefix = "my_shiro_redis_cache:";
	
	@Resource(name="redisClientTemplate")
	private RedisClientTemplate redisClientTemplate;
	
	public String getKeyValue(String key){
		return redisClientTemplate.get(key);
	}
	
	public String setKeyValue(String key,String value){
		return redisClientTemplate.set(key, value);
	}
	private static byte[] getByteKey(Object key){
		if(key instanceof String){
			String preKey = keyPrefix + key;
    		return preKey.getBytes();
    	}else{
    		return SerializeUtil.serialize(key);
    	}
	}
	public static void main(String[] args){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		String keys = "shiro_redis_session:admin";
		Object valueObject=SerializeUtil.deserialize(jedis.get(getByteKey("passwordRetryCache")));
		System.out.println(JacksonUtil.doJackson(valueObject));
	}
	
	/**
	 * 批量删除对应的value
	 * 
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 * 
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<String> keys = redisClientTemplate.hkeys(pattern);
		if (keys.size() > 0){
			for(String key:keys){
				remove(key);
			}
		}
	}

	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisClientTemplate.del(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisClientTemplate.exists(key);
	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		Object result = null;
		result = redisClientTemplate.get(key);
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			
			redisClientTemplate.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			redisClientTemplate.set(key, value);
			redisClientTemplate.expire(key, expireTime.intValue());
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
