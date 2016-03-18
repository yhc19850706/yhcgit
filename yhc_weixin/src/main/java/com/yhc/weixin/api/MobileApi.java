package com.yhc.weixin.api;


import java.io.File;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.yhc.weixin.util.RestTemplateClient;

public class MobileApi { 
	

	

	public static void main(String[] args) throws Exception{
		RestTemplate restTemplate = RestTemplateClient.restTemplate();
		String testFilePath = "D:\\mobile.txt";
        File testFile = new File(testFilePath);
        List<String> lines = Files.readLines(testFile, Charsets.UTF_8);
        String url= "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel={mobileNo}";
        List<String> bjMobiles = Lists.newArrayList();
        for (String mobileNo : lines) {
        	String resp = restTemplate.getForObject(url, String.class,mobileNo);
        	String province = resp.substring(resp.indexOf("province:")+10,resp.indexOf("catName:")-8);
        	if(province.equals("北京")){
        		System.out.println(mobileNo+" 归属地 ："+province);
        		bjMobiles.add(mobileNo);
        	}
        }
        System.out.println("------------------------------------------------");
        for (String mobileNo : bjMobiles) {
        	System.out.println(mobileNo);
        }
	}

}
