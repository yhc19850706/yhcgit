package com.yhc.common.redis.mycache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yhc.common.redis.myredis.RedisClientTemplate;
import com.yhc.common.redis.myredis.SerializeUtil;
import com.yhc.common.utils.JacksonUtil;

public class RedisCache<K,V> implements Cache<K,V>{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private RedisClientTemplate cache;
	
	private String keyPrefix="my_shiro_redis_cache:";
	
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
    		return SerializeUtil.serialize(key);
    	}
	}
	
	private String keyToString(K key){
		String k = String.valueOf(key);
		if(StringUtils.startsWith(k, this.keyPrefix)){
			return k;
		}
		return this.keyPrefix+k;
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
	public V get(K key) throws CacheException {
		logger.debug("根据key从Redis中获取对象 key [" + key + "]");
		try {
			if (key == null) {
	            return null;
	        }else{
	        	byte[] rawValue =cache.get(getByteKey(key));
	        	@SuppressWarnings("unchecked")
				V value = (V)SerializeUtil.deserialize(rawValue);
	        	logger.debug("根据key从Redis中获取对象 key的value [" + JacksonUtil.doJackson(value) + "]");
	        	return value;
	        }
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	@Override
	public V put(K key, V value) throws CacheException {
		logger.debug("根据key从存储 key [" + key + "]");
		 try {
			 	cache.set(getByteKey(key), SerializeUtil.serialize(value));
//			 cache.set(keyToString(key), value);
	            return value;
	        } catch (Throwable t) {
	            throw new CacheException(t);
	        }
	}

	@Override
	public V remove(K key) throws CacheException {
		logger.debug("从redis中删除 key [" + key + "]");
		try {
            V previous = get(key);
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
	public Set<K> keys() {
		try {
            Set<byte[]> keys = cache.hkeys(getByteKey(this.keyPrefix + "*"));
            if (CollectionUtils.isEmpty(keys)) {
            	return Collections.emptySet();
            }else{
            	Set<K> newKeys =new HashSet<K>();
            	for(byte[] key:keys){
            		newKeys.add((K)key);
            	}
            	return newKeys;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}

	@Override
	public Collection<V> values() {
		try {
			Set<byte[]> keys = cache.hkeys(getByteKey(this.keyPrefix + "*"));
            if (!CollectionUtils.isEmpty(keys)) {
            	return (Collection<V>) cache.hvals(getByteKey(this.keyPrefix + "*"));
                
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
	}
}
