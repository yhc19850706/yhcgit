package com.yhc.common.redis.mycache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yhc.common.redis.RedisUtil;
import com.yhc.common.redis.myredis.RedisClientTemplate;

public class MyRedisCacheManager implements CacheManager{

	private static final Logger logger = LoggerFactory.getLogger(MyRedisCacheManager.class);
	// fast lookup by name map
	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
	
	@Resource(name="redisClientTemplate")
	private RedisClientTemplate redisClientTemplate;

	/**
	 * The Redis key prefix for caches 
	 */
	private String keyPrefix = "my_shiro_redis_cache:";
	
	/**
	 * Returns the Redis session keys
	 * prefix.
	 * @return The prefix
	 */
	public String getKeyPrefix() {
		return keyPrefix;
	}
	/**
	 * Sets the Redis sessions key 
	 * prefix.
	 * @param keyPrefix The prefix
	 */
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	
	@Override
	public Cache getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		logger.debug("获取名称为: " + name + " 的RedisCache实例");
        Cache c = caches.get(name);
		
		if (c == null) {
			// create a new cache instance
			c = new RedisCache(redisClientTemplate, keyPrefix);
			caches.put(name, c);
		}
		return c;
	}

}
