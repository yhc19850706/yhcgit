package com.yhc.common.cache;

import org.apache.ibatis.cache.decorators.LoggingCache;

import com.yhc.common.redis.mycache.MybatisRedisCache;


public class LoggingRedisCache extends LoggingCache {  
	  
    public LoggingRedisCache(String id) {  
            super(new MybatisRedisCache(id));  
    }  

}
