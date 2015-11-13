package com.test.cms;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.Store;

/**
 * @Project：TestJava
 * @Package：com.test.cms
 * @ClassName: DigitalSignature
 * @Description: 数字签名
 * @author Yhc yinhc@yinhu.com
 * @date 2015年10月13日 上午11:08:56
 */
public class DigitalSignature {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------列出加密服务提供者-----");
		Provider[] pro=Security.getProviders();
		for(Provider p:pro){
		System.out.println("Provider:"+p.getName()+" - version:"+p.getVersion());
		System.out.println(p.getInfo());
		}
		System.out.println("");
		System.out.println("-------列出系统支持的消息摘要算法：");
		for(String s:Security.getAlgorithms("MessageDigest")){
		System.out.println(s);
		}
		System.out.println("-------列出系统支持的生成公钥和私钥对的算法：");
		for(String s:Security.getAlgorithms("KeyPairGenerator")){
		System.out.println(s);
		}
	}

}
