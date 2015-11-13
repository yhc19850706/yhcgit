/**
 * 使用Java发送HTTP请求和提取数据
 */
package com.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JavaHttpRequest {
	public static void main(String[] args) {
//		try {
//			URL my_url = new URL(
//					"http://developer.51cto.com/art/200906/128274.htm");
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					my_url.openStream(), "GB2312"));
//			String strTemp = "";
//			while (null != (strTemp = br.readLine())) {
//				System.out.println(strTemp);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("hbid", "62102");
			
		String xml = HttpXmlClient.post("http://dev.bbs.yinhu.com/api/credit_selectlog.php", params);
		System.out.println(xml);
	}
}
