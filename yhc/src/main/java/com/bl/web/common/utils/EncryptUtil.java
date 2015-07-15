package com.bl.web.common.utils;



public class EncryptUtil {
	public static String encrypt(String orgString) {
		String dutyStr = "E6DF316BC4B4BCB23D0942EFB5BDEEE583B588214B128E84";
		dutyStr = "";
		String rtnString;
		rtnString = Md5Util.getMD5(orgString + dutyStr);
		return rtnString;
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("1qaz2wsx"));
	}
}
