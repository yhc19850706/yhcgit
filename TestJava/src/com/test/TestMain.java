package com.test;

import java.lang.reflect.Field;

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
	    } 
	   
}
