package com.test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

import redis.clients.jedis.Jedis;

public class TestMain {
/**
 * 
 * @param args
 */
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException { 
//		 String str1="20151212000000",investUserMobile="13813204059";
//		 String str2="20151212";
//		 investUserMobile=investUserMobile.substring(0,3)+"****"+investUserMobile.substring(7,11);
//		 System.out.println("investUserMobile="+investUserMobile);
//		int result=str1.compareTo(str2);
//		if(result>0)
//		System.out.println("str1>str2");
//		else if(result==0)
//		System.out.println("str1=str2");
//		else
//		System.out.println("str1<str2");

		String str1="com.sillycat.easyaop.dao.impl.RoleDAOImpl.saveRole";
		  String str2="com.sillycat.easyaop.dao.impl.UserDAOImpl.save";
		  String str3="com.sillycat.easyaop.dao.impl.BaseDAOImpl.save";
		  Pattern pattern=Pattern.compile( 
		    ".*DAOImpl[.]save.*");
		  Matcher matcher1=pattern.matcher(str1);
		  Matcher matcher2=pattern.matcher(str2);
		  Matcher matcher3=pattern.matcher(str3);
		  System.out.println(matcher1.matches());
		  System.out.println(matcher2.matches());
		  System.out.println(matcher3.matches());
		  
		 }
		 static void v(int i)
		 {
		  System.out.println("i : "+i);
		 }
	   
}
