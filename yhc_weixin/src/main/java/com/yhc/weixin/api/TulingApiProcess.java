package com.yhc.weixin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import com.yhc.weixin.model.TulingResponse;
import com.yhc.weixin.util.JsonUtil;

/**
 * 调用图灵机器人api接口，获取智能回复内容
 * @author pamchen-1
 *
 */
public class TulingApiProcess extends BaseAPI{
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * @param content
	 * @return
	 */
	public static String getTulingResult(String content){
		//图灵机器人数据库接口
		String APIKEY = "fd713d6df7744c610e605ee17f26a96d";
		StringBuffer sb = new StringBuffer();
		String result = "";
		try {
			String INFO = URLEncoder.encode(content, "utf-8"); 
			String getURL = "http://www.tuling123.com/openapi/api?key="
					+ APIKEY + "&info=" + INFO;
			URL getUrl = new URL(getURL);
			HttpURLConnection connection = (HttpURLConnection) getUrl
					.openConnection();
			connection.connect();

			// 取得输入流，并使用Reader读取
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));

			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			// 断开连接
			connection.disconnect();
			JSONObject json = new JSONObject(sb.toString());
			result = json.getString("text");
			if(100000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        }else if(200000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        } else if(302000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        } else if(308000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        } else if(313000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        }  else if(314000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        }   
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * @param content
	 * @return
	 */
	public TulingResponse getTulingResponse(String content,String userId){
		//图灵机器人数据库接口
		String APIKEY = "fd713d6df7744c610e605ee17f26a96d";
		StringBuffer sb = new StringBuffer();
		String result = "";
		try {
			String INFO = URLEncoder.encode(content, "utf-8"); 
			String getURL = "http://www.tuling123.com/openapi/api?key="
					+ APIKEY + "&info=" + INFO+ "&userid=ocuUKv7M9mnY1xFRglBgjJpdxJHk";// + userId;
			URL getUrl = new URL(getURL);
			HttpURLConnection connection = (HttpURLConnection) getUrl
					.openConnection();
			connection.connect();

			// 取得输入流，并使用Reader读取
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));

			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			// 断开连接
			connection.disconnect();
//			JSONObject json = new JSONObject(sb.toString());
			return JsonUtil.parseObject(sb.toString(), TulingResponse.class);   
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 调用图灵机器人平台接口 
	 * 描述：@param args
	 * 描述：@throws IOException
	 * 作者：herosky
	 */
	public static void main(String[] args) throws IOException { 

	     String APIKEY = "fd713d6df7744c610e605ee17f26a96d"; 
	     //String INFO = URLEncoder.encode("合肥天气", "utf-8"); 
	     String INFO = "想入非非"; 
	    //String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO; 
	    String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO; 
	    URL getUrl = new URL(getURL); 
	    HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); 
	    connection.connect(); 

	    // 取得输入流，并使用Reader读取 
	    BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
	    StringBuffer sb = new StringBuffer(); 
	    String line = ""; 
		String result = null;
	    while ((line = reader.readLine()) != null) { 
	        sb.append(line); 
	    } 
	    reader.close(); 
	    // 断开连接 
	    connection.disconnect(); 
	    System.out.println(sb); 
	    JSONObject json;
	    try {
	    	json = new JSONObject(sb.toString());
	    	if(100000==json.getInt("code"))
	    	{  
	            result = json.getString("text");  
	        }  
			result = new String(result.getBytes(), "UTF-8");
			System.out.println(result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
}