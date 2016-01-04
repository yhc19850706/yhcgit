package com.yhc.common.redis.mycache;


import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;  
import java.util.concurrent.locks.ReentrantReadWriteLock;  

import javax.annotation.Resource;

import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.apache.ibatis.cache.Cache;
import org.mybatis.caches.redis.SerializeUtil;

import com.yhc.common.redis.myredis.RedisClientTemplate;
/**
 * 
 * @author lenovo
 *使用第三方缓存服务器redis，处理二级缓存
 */
public class MybatisRedisCache   implements Cache {  
        private static Log log = LogFactory.getLog(MybatisRedisCache.class);  
        /** The ReadWriteLock. */  
        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();  
        @Resource(name="redisClientTemplate")
    	private RedisClientTemplate redisClientTemplate;
        private String keyPrefix = "mybatis_redis_cache:";
        private String id;  
        public MybatisRedisCache(final String id) {  
                if (id == null) {  
                        throw new IllegalArgumentException("必须传入ID");  
                }  
                log.debug("MybatisRedisCache:id=" + id);  
                this.id=id;  
        }  
        private byte[] getByteKey(Object key){
    		if(key instanceof String){
    			String preKey = this.keyPrefix + key;
        		return preKey.getBytes();
        	}else{
        		return SerializeUtil.serialize(key);
        	}
    	}  
        @Override  
        public String getId() {  
                return this.id;  
        }  
  
        @Override  
        public int getSize() {  
        	Map<byte[], byte[]> result = redisClientTemplate.hgetAll(id.toString().getBytes());
            return result.size();   
        }  
  
        @Override  
        public void putObject(Object key, Object value) {  
                if(log.isDebugEnabled())  
                log.debug("putObject:" + key.hashCode() + "=" + value);  
                if(log.isInfoEnabled())  
                log.info("put to redis sql :" +key.toString());  
                redisClientTemplate.hset(id.toString().getBytes(), getByteKey(key), SerializeUtil.serialize(value)); 
        }  
  
        @Override  
        public Object getObject(Object key) {
                Object value = null;  
                value=SerializeUtil.unserialize(redisClientTemplate.hget(id.toString().getBytes(), getByteKey(key))); 
                if(log.isDebugEnabled())  
                log.debug("getObject:" + key.hashCode() + "=" + value);  
                return value;  
        }  
  
        @Override  
        public Object removeObject(Object key) {  
                Object value = null;
                value  = redisClientTemplate.expire(getByteKey(key), 0); 
                if(log.isDebugEnabled())  
                log.debug("getObject:" + key.hashCode() + "=" + value);  
                return value;  
        }  
  
        @Override  
        public void clear() {  
        	redisClientTemplate.delByte(id.toString().getBytes());
        }  
  
        @Override  
        public ReadWriteLock getReadWriteLock() {  
                return readWriteLock;  
        }
}