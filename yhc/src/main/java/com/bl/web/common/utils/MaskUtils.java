package com.bl.web.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class MaskUtils {

	public static String maskStr(String inputStr, String nullDispStr) {
		StringBuffer outStr = new StringBuffer();
		if (StringUtils.isNotEmpty(inputStr)) {
			if (inputStr.length() == 11 && isNumber(inputStr)) {
				//手机号  : 前3位 + '****' + 后四位
				outStr.append(inputStr.substring(0, 3));
				//				outStr.append( "****" );
				//				outStr.append( inputStr.substring(7,11) );
				outStr.append(" **** ****");
			} else if (inputStr.length() == 18 && !inputStr.contains("@")) {
				//身份证号 : 前3位 + '***************'
				outStr.append(inputStr.substring(0, 3));
				outStr.append("**** **** **** ****");
			} else if (checkEmail(inputStr)) {
				//邮箱: 前3位 + *处理到@前为止  + @邮箱域名
				String mailId = inputStr.substring(0, inputStr.indexOf("@"));
				outStr.append(mailId.substring(0, 3));
				outStr.append(mailId.substring(3, mailId.length()).replaceAll(".", "*"));
				outStr.append(inputStr.substring(inputStr.indexOf("@"), inputStr.length()));
			} else if(inputStr.length() > 2){
				//用户名
				outStr.append(inputStr.substring(0, 3));
				outStr.append("*** ***");
			}
		} else {
			outStr.append(nullDispStr);
		}
		return outStr.toString();
	}

	public static String maskStr(String inputStr) {
		return maskStr(inputStr, "");
	}

	public static boolean isNumber(String No) {
		boolean flag = false;
		try {
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(No);
			flag = m.matches();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public static void main(String[] args) {
		String t = "1234567890";

		System.out.println(t.replaceAll(".", "*"));
	}
}
