package com.yhc.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptUtil {
	public static BasicTextEncryptor encryptor = new BasicTextEncryptor();
	static {
		encryptor.setPassword("Y123H654W098X765");
	}

	/**
	 * 
	 * @MethodName:encrypt
	 * @param orgString
	 * @return String
	 * @Description: MD5加密
	 */
	public static String encrypt(String orgString) {
		String dutyStr = "E6DF316BC4B4BCB23D0942EFB5BDEEE583B588214B128E84";
		dutyStr = "";
		String rtnString;
		rtnString = Md5Util.getMD5(orgString + dutyStr);
		return rtnString;
	}

	/**
	 * 
	 * @MethodName:jasyptEncrypt
	 * @param orgString
	 * @return String
	 * @Description:加密
	 * @author Yhc yinhc@yinhu.com
	 */
	public static String jasyptEncrypt(String orgString) {
		try {
			String rtnString = URLEncoder.encode(encryptor.encrypt(orgString),
					"UTF-8");
			System.out.println("加密：" + rtnString);
			return rtnString;
		} catch (UnsupportedEncodingException e) {
			// TODOAuto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @MethodName:jasyptEncrypt
	 * @param orgString
	 * @return String
	 * @Description:解密 http请求时会自动解码，因此解密时不需要encode
	 * @author Yhc yinhc@yinhu.com
	 */
	public static String jasyptDecrypt(String orgString) {

		String rtnString = encryptor.decrypt(orgString);
		return rtnString;

	}

	/**
	 * 64位编码
	 * @param data
	 * @return String
	 */
	public static String base64Encode(String data) {
		if (StringUtils.isBlank(data)) {
			return null;
        }
		String strEncode=null;
		try {
			strEncode= Base64.encodeBase64String(data.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return strEncode;
	}

	/**
	 * 64位解码
	 * @param data
	 * @return String
	 */
	public static String base64Decode(String data) {
		if (StringUtils.isBlank(data)) {
            return null;
        }
		byte[] strByte=Base64.decodeBase64(data.getBytes());
		String strEncode=null;
		try {
			strEncode = new String(strByte,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return strEncode;
	}

	public static String md5(String data) {
		return DigestUtils.md5Hex(data);
	}

	public static String sha1(String data) {
		return DigestUtils.sha1Hex(data);
	}

	public static String sha256Hex(String data) {
		return DigestUtils.sha256Hex(data);
	}

	public static void main(String[] args) {
		System.out.println(encrypt("1qaz2wsx"));
	}
}
