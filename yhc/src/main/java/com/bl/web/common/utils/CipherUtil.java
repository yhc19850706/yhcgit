package com.bl.web.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CipherUtil {
//	private static CipherUtil instance = new CipherUtil();
	private Logger logger = Logger.getLogger(CipherUtil.class);
	private static String CRYPT_KEY = "";
	
	public void init() {
		logger.debug(">>>>>>>>>>>>>>>>>> init start <<<<<<<<<<<<<<<<<<<<");
		if (StringUtils.isBlank(CRYPT_KEY)) {
			CRYPT_KEY = EncryptUtil.encrypt(DateUtils.getCurDtStr());
		}
//		System.out.println("===============================>" + CRYPT_KEY);
		logger.debug(">>>>>>>>>>>>>>>>>> init end <<<<<<<<<<<<<<<<<<<<");
	}
	
	
	private static int randomNum(int max, int min) {
		Random rand = new Random();
		int randNumber = rand.nextInt(max - min + 1) + min;
		return randNumber;
	}
	
	public static final String randomString(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
        if (length < 1) {
            return null;
        }
        if (randGen == null) {
               randGen = new Random();
               numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                 //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                }
        char [] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
}
	
	private static String randomCryptKey() {
		int index = randomNum(3, 1);
//		System.out.println(index);
		StringBuffer key = new StringBuffer();
		for (int i = 0; i < index; i++) {
			String str = randomString(8);
			key.append(str);
//			System.out.println("str : " + str);
		}
//		System.out.println("key : " + key.toString());
		return key.toString();
	}
	
	
	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static byte[] encrypt(String content) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		try {
//			if (StringUtils.isBlank(CRYPT_KEY)) {
//				CRYPT_KEY = randomCryptKey();
//			}
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom =  SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(CRYPT_KEY.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			throw e;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw e;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw e;
		}
//		return null;
	}

	/**
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 * @throws  
	 */
	private static byte[] decrypt(byte[] content) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		try {
//			if (StringUtils.isBlank(CRYPT_KEY)) {
//				CRYPT_KEY = randomCryptKey();
//			}
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom =  SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(CRYPT_KEY.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			throw e;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw e;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw e;
		}
//		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	public static String encryptResult(String content) throws Exception {
		byte[] encryptResult = encrypt(content);
		return parseByte2HexStr(encryptResult);
	}
	
	public static String decryptResult(String content) throws Exception {
		byte[] decryptFrom = parseHexStr2Byte(content);
		return new String(decrypt(decryptFrom));
	}
	
	public static void main(String[] args) {
		try {
		String content = "测试01";
//		String password = "MIDUO_SECURITY_CODE_1233";
		// 加密
		System.out.println("加密前：" + content);
//		byte[] encryptResult = encrypt(content);
//		String encryptResultStr = parseByte2HexStr(encryptResult);
		String str = CipherUtil.encryptResult(content);
		System.out.println("加密后：" + str);
		// 解密
		
//		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
//		byte[] decryptResult = decrypt(decryptFrom);
		
			System.out.println("解密后：" + decryptResult(str));
			
//			System.out.println(decryptResult("BB49ECF7B6D1084020D1A01F59DDFAF5"));
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("加密前1：" + "18600457009");
//		System.out.println("MIDUO_SECURITY_CODE_1234：" + "MIDUO_SECURITY_CODE_1234".length());
//		System.out.println("加密后2：" + encrypt("18600457009"));
//		System.out.println("解密后3：" + new String(decryptResult));
		
	}
}
