package com.test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

import javax.xml.crypto.Data;

import redis.clients.jedis.Jedis;

public class TestMain {
/**
 * 
 * @param args
 */
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException { 
		 String str1="20151212000000",investUserMobile="13813204059";
		 String str2="20151212";
		 investUserMobile=investUserMobile.substring(0,3)+"****"+investUserMobile.substring(7,11);
		 System.out.println("investUserMobile="+investUserMobile);
		int result=str1.compareTo(str2);
		if(result>0)
		System.out.println("str1>str2");
		else if(result==0)
		System.out.println("str1=str2");
		else
		System.out.println("str1<str2");
		
		Jedis jedis = new Jedis("127.0.0.1",6379);
		String keys = "shiro_redis_session:admin";
		// 取数据 
				Set<String> value = jedis.keys("*yhc*");
                 Iterator<String> eIterable=value.iterator();
                while(eIterable.hasNext()){
                	String valueString=eIterable.next();
                	byte[] bytes;
					try {
						bytes = valueString.getBytes("utf-8");
						String str = new String(bytes,"utf-8");
	                	System.out.println(str);
					} catch (UnsupportedEncodingException e) {
						// TODO  Auto-generated catch block
								e.printStackTrace();
							
					}//""里面的参数为需要转化的编码，一般是ISO8859-1 
                	
                } 
		// 删数据
		// 存数据
//		jedis.set(keys, "sdfs");
		// 取数据 
	    } 
	   
}
