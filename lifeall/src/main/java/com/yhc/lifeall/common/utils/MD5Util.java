package com.yhc.lifeall.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * MD5加密
     *
     * @param data
     *            待加密数据
     * @return byte[] 消息摘要
     *
     * @throws Exception
     */
//    public static byte[] encodeMD5(String data) throws Exception {
//
//        // 执行消息摘要
//        return DigestUtils.md5(data);
//    }

    /**
     * MD5加密
     *
     * @param data
     *            待加密数据
     * @return byte[] 消息摘要
     *
     * @throws Exception
     */
    public static String encodeMD5Hex(String data) {
        // 执行消息摘要
        return DigestUtils.md5Hex(data);
    }

    public static String byte2hex(byte[] b) { // 二行制转字符
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static String getMD5(String password) {
        String returnStr = null;
        try {
            MessageDigest alga = MessageDigest.getInstance("MD5");
            alga.update(password.getBytes());
            byte[] digesta = alga.digest();
            returnStr = byte2hex(digesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStr;
    }

    public static String encodeMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    public static String decodeMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }

    public static String encode(String str,String miyao) {
        return encodeMD5(getMD5(str));
    }

    public static String decode(String str) {
        return decodeMD5(str);
    }

    public static String getMD5Lower(String password,String miyao) {
        String returnStr = null;
        try {
            MessageDigest alga = MessageDigest.getInstance(miyao);

            alga.update(password.getBytes());
            byte[] digesta = alga.digest();
            returnStr = byte2hex(digesta);
        } catch (Exception e) {
        }
        return returnStr.toLowerCase();
    }

    public static void main(String[] args) {
       String sss= MD5Util.encodeMD5Hex("123456");
        System.out.println(sss);
       System.out.println(sss.length());
    }
}
