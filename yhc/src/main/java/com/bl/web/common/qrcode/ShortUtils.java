package com.bl.web.common.qrcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.bl.web.common.utils.HttpClientWrapperUtil;
import com.bl.web.common.utils.JacksonUtil;
import com.google.common.collect.Maps;

public class ShortUtils {
	

	public static String getShortUrl(String url) throws Exception{
		Map<String, String> params = Maps.newHashMap();
		params.put("url", url);
		Map<String, Object> responseMap = HttpClientWrapperUtil.getInstance().sendPostRequest("http://dwz.cn", 80, "/create.php", null, params, 5000, 5000);
		//System.out.println(responseMap);
		Map body  = JacksonUtil.convertJson2Map((String)responseMap.get("body"));
		return (String)body.get("tinyurl");
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Map<String,Object> map=Maps.newHashMap();
		map.put("罗余", "0300104");
		map.put("李巧林", "0300105");
		map.put("黄敏", "0300203");
		map.put("何佳", "0300204");
		Set set=map.keySet();
		Iterator<String> e=set.iterator();
		while(e.hasNext()){
			String key=e.next();
			String shortUrl=getShortUrl("http://m.xmfin.com/app.bl?empId="+map.get(key));
			System.out.println(shortUrl);
			QRCodeUtil utils = new QRCodeUtil();
//			utils.encoderQRCode(shortUrl, "D:\\qrcode\\xmph\\newadd\\"+key+"_"+map.get(key)+"_1024_qrcode.jpg", 1024);
		}
		
	}

}
