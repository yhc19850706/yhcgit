package com.yhc.common.redis.mycache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yhc.common.redis.cache.SerializeUtils;
import com.yhc.common.redis.myredis.RedisClientTemplate;
import com.yhc.common.redis.myredis.SerializeUtil;

public class RedisCache implements Cache{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private RedisClientTemplate cache;
	
	private String keyPrefix;
	
	public String getKeyPrefix() {
		return keyPrefix;
	}
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	
	/**
	 * 获得byte[]型的key
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Object key){
		if(key instanceof String){
			String preKey = this.keyPrefix + key;
    		return preKey.getBytes();
    	}else{
    		return SerializeUtils.serialize(key);
    	}
	}
	/**
	 * 通过一个RedisClientTemplate实例构造RedisCache
	 */
	public RedisCache(RedisClientTemplate cache){
		 if (cache == null) {
	         throw new IllegalArgumentException("Cache argument cannot be null.");
	     }
	     this.cache = cache;
	}
	
	/**
	 * Constructs a cache instance with the specified
	 * Redis manager and using a custom key prefix.
	 * @param cache The cache manager instance
	 * @param prefix The Redis key prefix
	 */
	public RedisCache(RedisClientTemplate cache, 
				String prefix){
		 
		this( cache );
		
		// set the prefix
		this.keyPrefix = prefix;
	}
	
 	
	@Override
	public Object get(Object key) throws CacheException {
		logger.debug("根据key从Redis中获取对象 key [" + key + "]");
		try {
			if (key == null) {
	            return null;
	        }else{
	        	byte[] value = cache.getByte(getByteKey(key));
	        	return value;
	        }
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	@Override
	public Object put(Object key, Object value) throws CacheException {
		logger.debug("根据key从存储 key [" + key + "]");
		 try {
			 	cache.setByte(getByteKey(key), SerializeUtil.serialize(value));
	            return value;
	        } catch (Throwable t) {
	            throw new CacheException(t);
	        }
	}

	@Override
	public Object remove(Object key) throws CacheException {
		logger.debug("从redis中删除 key [" + key + "]");
		try {
            Object previous = get(key);
            cache.delByte(getByteKey(key));
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public void clear() throws CacheException {
		throw new CacheException("未提供该方法");
	}

	@Override
	public int size() {
		throw new CacheException("未提供该方法");
	}

	@Override
	public Set<String> keys() {
		try {
            Set<String> keys = cache.hkeys(this.keyPrefix + "*");
            if (CollectionUtils.isEmpty(keys)) {
            	return Collections.emptySet();
            }else{
            	Set<String> newKeys = new HashSet<String>();
            	for(String key:keys){
            		newKeys.add((String)key);
            	}
            	return newKeys;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public Collection<String> values() {
		try {
            Set<String> keys = cache.hkeys(this.keyPrefix + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                List<String> values = new ArrayList<String>(keys.size());
                for (String key : keys) {
                    @SuppressWarnings("unchecked")
                    String value = (String) get(key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

}
