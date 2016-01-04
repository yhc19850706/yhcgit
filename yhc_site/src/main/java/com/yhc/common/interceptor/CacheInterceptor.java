package com.yhc.common.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.yhc.common.config.BlGlobalVariable;
import com.yhc.common.redis.myredis.MyRedisUtil;

public class CacheInterceptor implements MethodInterceptor { 
	private Logger logger = Logger.getLogger(MethodCacheInterceptor.class); 
	private MyRedisUtil myRedisUtil; 
	private List<String> targetNamesList; // 不加入缓存的service名称 
	private List<String> methodNamesList; // 不加入缓存的方法名称 
	private Long defaultCacheExpireTime; // 缓存默认的过期时间 
	private Long xxxRecordManagerTime; // 
	private Long xxxSetRecordManagerTime; //
	/** 
	  * 初始化读取不需要加入缓存的类名和方法名称 
	  */ 
	public CacheInterceptor() { 
	  try {
	   // 分割字符串 
	   String[] targetNames =BlGlobalVariable.REDIS_TARGETNAMES.split(","); 
	   String[] methodNames =BlGlobalVariable.REDIS_METHODNAMES.split(","); 
	 
	   // 加载过期时间设置 
	   defaultCacheExpireTime = Long.valueOf(BlGlobalVariable.REDIS_DEFAULT_CACHE_EXPIRETIME); 
	   xxxRecordManagerTime = Long.valueOf(BlGlobalVariable.REDIS_RECORD_MANAGER); 
	   xxxSetRecordManagerTime = Long.valueOf(BlGlobalVariable.REDIS_SET_RECORD_MANAGER); 
	   // 创建list 
	   targetNamesList = new ArrayList<String>(targetNames.length); 
	   methodNamesList = new ArrayList<String>(methodNames.length); 
	   Integer maxLen = targetNames.length > methodNames.length ? targetNames.length 
	     : methodNames.length; 
	   // 将不需要缓存的类名和方法名添加到list中 
	   for (int i = 0; i < maxLen; i++) { 
	    if (i < targetNames.length) { 
	     targetNamesList.add(targetNames[i]); 
	    } 
	    if (i < methodNames.length) { 
	     methodNamesList.add(methodNames[i]); 
	    } 
	   } 
	  } catch (Exception e) { 
	   e.printStackTrace(); 
	  } 
	} 
	 
	@Override 
	public Object invoke(MethodInvocation invocation) throws Throwable { 
	  Object value = null; 
	 
	  String targetName = invocation.getThis().getClass().getName(); 
	  String methodName = invocation.getMethod().getName(); 
	  // 不需要缓存的内容 
	  //if (!isAddCache(StringUtil.subStrForLastDot(targetName), methodName)) { 
	  if (!isAddCache(targetName, methodName)) { 
	   // 执行方法返回结果 
	   return invocation.proceed(); 
	  } 
	  Object[] arguments = invocation.getArguments(); 
	  String key = getCacheKey(targetName, methodName, arguments); 
	  System.out.println(key); 
	 
	  try { 
	   // 判断是否有缓存 
	   if (myRedisUtil.exists(key)) { 
	    return myRedisUtil.get(key); 
	   } 
	   // 写入缓存 
	   value = invocation.proceed(); 
	   if (value != null) { 
	    final String tkey = key; 
	    final Object tvalue = value; 
	    new Thread(new Runnable() { 
	     @Override 
	     public void run() { 
	      if (tkey.startsWith("com.yhc.common.model")) { 
	    	  myRedisUtil.set(tkey, tvalue, xxxRecordManagerTime); 
	      } else if (tkey.startsWith("com.yhc.web")) { 
	    	  myRedisUtil.set(tkey, tvalue, xxxSetRecordManagerTime); 
	      } else { 
	    	  myRedisUtil.set(tkey, tvalue, defaultCacheExpireTime); 
	      } 
	     } 
	    }).start(); 
	   } 
	  } catch (Exception e) { 
	   e.printStackTrace(); 
	   if (value == null) { 
	    return invocation.proceed(); 
	   } 
	  } 
	  return value; 
	} 
	 
	/** 
	  * 是否加入缓存 
	  * 
	  * @return 
	  */ 
	private boolean isAddCache(String targetName, String methodName) { 
	  boolean flag = true; 
	  if (targetNamesList.contains(targetName) 
	    || methodNamesList.contains(methodName)) { 
	   flag = false; 
	  } 
	  return flag; 
	} 
	 
	/** 
	  * 创建缓存key 
	  * 
	  * @param targetName 
	  * @param methodName 
	  * @param arguments 
	  */ 
	private String getCacheKey(String targetName, String methodName, 
	   Object[] arguments) { 
	  StringBuffer sbu = new StringBuffer(); 
	  sbu.append(targetName).append("_").append(methodName); 
	  if ((arguments != null) && (arguments.length != 0)) { 
	   for (int i = 0; i < arguments.length; i++) { 
	    sbu.append("_").append(arguments[i]); 
	   } 
	  } 
	  return sbu.toString(); 
	} 
	 
	public void setMyRedisUtil(MyRedisUtil myRedisUtil) { 
	  this.myRedisUtil = myRedisUtil; 
	} 
	}
