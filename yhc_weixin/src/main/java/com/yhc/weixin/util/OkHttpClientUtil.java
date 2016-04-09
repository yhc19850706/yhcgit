package com.yhc.weixin.util;

import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class OkHttpClientUtil {

	static OkHttpClient				client	= new OkHttpClient();

	public static final MediaType	JSON	= MediaType
													.parse("application/json; charset=utf-8");

	public static String get(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}

	public static void main(String[] args) throws IOException {

//		TemplateMessageData data = new TemplateMessageData();
//		data.setTemplateId("hdaC1Ou4aExI1xz99kPUP13TqhU7e0G4ozw0l5crfuM");
//		data.setWechatId("ocuUKv7M9mnY1xFRglBgjJpdxJHk");
//		Map<String, String> dataMap = Maps.newHashMap();
//		dataMap.put("first", "购买45个产品");
//		dataMap.put("keynote1", "苹果41");
//		dataMap.put("keynote2", "橘子3");
//		dataMap.put("keynote3", "香蕉1");
//		data.setDataMap(dataMap);
//		data.getSign();
//		String response = post("http://localhost:8080/api/send_template.bl",
//				JacksonUtil.doJackson(data));
		System.out.println("keyword1Amt".replace("Amt", ""));
		System.out.println("originmt".replace("Amt", ""));
	}
}
