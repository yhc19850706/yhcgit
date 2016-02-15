package com.common.http.okhttp;

import java.io.IOException;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class OkhttpClient {

	static OkHttpClient	client	= new OkHttpClient();

	/**
	 * 
	 * @MethodName:run
	 * @param url
	 * @return
	 * @throws IOException
	 * String
	 * @Description: GET
	 * @author Yhc yinhc@yinhu.com
	 */
	public static String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
   
	public static final MediaType	JSON	= MediaType .parse("application/json; charset=utf-8");
    /**
     * 
     * @MethodName:post
     * @param url
     * @param json
     * @return
     * @throws IOException
     * String
     * @Description: POST
     * @author Yhc yinhc@yinhu.com
     */
	public static String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		//通过POST方式把键值对数据传送到服务器
//		RequestBody body = new FormEncodingBuilder()
//
//	    .add("platform", "android")
//
//	    .add("name", "bug")
//
//	    .add("subject", "XXXXXXXXXXXXXXX")
//
//	    .build();
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String bowlingJson(String player1, String player2) {
		return "{'winCondition':'HIGH_SCORE'," + "'name':'Bowling',"
				+ "'round':4," + "'lastSaved':1367702411696,"
				+ "'dateStarted':1367702378785," + "'players':[" + "{'name':'"
				+ player1
				+ "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
				+ "{'name':'" + player2
				+ "','history':[6,10,5,10,10],'color':-48060,'total':41}"
				+ "]}";
	}

	String postJson(String url, String json) throws IOException {
	     RequestBody body = RequestBody.create(JSON, json);
	      Request request = new Request.Builder()
	      .url(url)
	      .post(body)
	      .build();
	      Response response = client.newCall(request).execute();
	    if (response.isSuccessful()) {
	        return response.body().string();
	    } else {
	        throw new IOException("Unexpected code " + response);
	    }
	}
	public static void main(String[] args) throws IOException {
//		String response = run("https://raw.github.com/square/okhttp/master/README.md");
//		System.out.println(response);

		String json=bowlingJson("Jesse", "Jake");
		String response=post("http://www.roundsapp.com/post", json);
		System.out.println(response);
	}
}
