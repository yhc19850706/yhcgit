package com.yhc.web.security;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import com.yhc.common.cache.EhcacheUtil;
/** 
* User： cutter.li 
* Date： 2014/6/30 0030 
* Time： 15:22   extends HashedCredentialsMatcher 
* 备注： 限制登录次数，如果5次出错，锁定1个小时 
*/ 
public class LimitRetryHashedMatcher extends HashedCredentialsMatcher{
//	   缓存管理器 com.yhc.common.cache.EhcacheUtil
//    @Override 
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) { 
//        String username = (String) token.getPrincipal(); 
//         //retrycount + 1 
//        Object element = EhcacheUtil.getItem(username); 
//        if (element == null) { 
//            EhcacheUtil.putItem(username, 1); 
//            element=0; 
//        }else{ 
//            int count=Integer.parseInt(element.toString())+1; 
//            element=count; 
//            EhcacheUtil.putItem(username,element); 
//        } 
//        AtomicInteger retryCount = new AtomicInteger(Integer.parseInt(element.toString())); 
//        if (retryCount.incrementAndGet() > 5) { 
//             //if retrycount >5 throw 
//            throw new ExcessiveAttemptsException(); 
//        } 
//        boolean matches = super.doCredentialsMatch(token, info); 
//        if (matches) { 
//            //clear retrycount 
//            EhcacheUtil.removeItem(username); 
//        } 
//        return matches; 
//    }
    //缓存管理器 org.apache.shiro.cache.ehcache.EhCacheManager
    private Cache<String, AtomicInteger> passwordRetryCache;

    public LimitRetryHashedMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }
        return matches;
    }

}