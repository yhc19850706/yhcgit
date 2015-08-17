package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.URI;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * java调用Http接口
 * @author lenovo
 *
 */
public class TestHttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String userName="hb0001";
		String mobileNo="16800001001";
		String cVal="685a8b9c10bf09f25163ba04221dba99";
		String ts="201412231713888";
		String rn="100";
		String smsUrl="http://localhost:8080/user/investing_money.bl?userName=hb0001&mobileNo=16800001001&cVal=685a8b9c10bf09f25163ba04221dba99&ts=201412231713888&rn=100";
		
		String ret= executeGet(smsUrl);//sendSms(userName ,mobileNo,cVal,ts,rn);
		System.out.println(ret);
		JSONObject sobj = new JSONObject();
		sobj = sobj.fromObject(ret);
		String rcVal = sobj.getString("cVal");
		String code = sobj.getString("code");
		if(code.equals("101")){
			JSONArray jarray=JSONArray.fromObject(sobj.getString("body"));
			List<InvestMoney> list=new ArrayList<InvestMoney>();
	        list= JSONArray.toList(jarray,InvestMoney.class);
			for(InvestMoney invest:list ){
				System.out.println(invest.getIncomeAmt());
				System.out.println(invest.getOriginAmt());
				System.out.println(invest.getPeriod());
			}
		}
		
		if(ret.indexOf("失败")<0)
		{
			System.out.println("成功发送sms");
		}
		else
		{
			System.out.println("失败发送");
		}

	}
	
	
    /**
     * HttpPost方法
     * @param userName
     * @param mobileNo
     * @param cVal
     * @param ts
     * @param rn
     * @return
     */
	public static String sendSms(String userName,String mobileNo,String cVal,String ts,String rn){
		HttpClient httpclient = new DefaultHttpClient();
		String smsUrl="http://localhost:8080/user/investing_money.bl?userName=hb0001&mobileNo=16800001001&cVal=685a8b9c10bf09f25163ba04221dba99&ts=201412231713888&rn=100";
		HttpPost httppost = new HttpPost(smsUrl);
		String strResult = "";
		
		try {
			
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				JSONObject jobj = new JSONObject();
				jobj.put("userName", userName);
				jobj.put("mobileNo", mobileNo);
				jobj.put("cVal",cVal);
				jobj.put("ts",ts);
				jobj.put("rn",rn);
				
				
				nameValuePairs.add(new BasicNameValuePair("msg", getStringFromJson(jobj)));
				httppost.addHeader("Content-type", "application/x-json");
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
				
				HttpResponse response = httpclient.execute(httppost);
				if (response.getStatusLine().getStatusCode() == 200) {
					/*读返回数据*/
					String conResult = EntityUtils.toString(response
							.getEntity());
					JSONObject sobj = new JSONObject();
					sobj = sobj.fromObject(conResult);
					String rcVal = sobj.getString("cVal");
					String code = sobj.getString("code");
					JSONArray jarray=JSONArray.fromObject(sobj.getString("body"));
					if(code.equals("101")){
						strResult += "发送成功"+rcVal+sobj.getString("body");
					}else{
						strResult += "发送失败，"+code;
					}
					
				} else {
					String err = response.getStatusLine().getStatusCode()+"";
					strResult += "发送失败:"+err;
				}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strResult;
	}

	
	private static String getStringFromJson(JSONObject adata) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(Object key:adata.keySet()){
			sb.append("\""+key+"\":\""+adata.get(key)+"\",");
		}
		String rtn = sb.toString().substring(0, sb.toString().length()-1)+"}";
		return rtn;
	}
	
	/**
	 * HttpGet方法
	 * @param adata
	 * @return
	 */
		public static String executeGet(String url){
			BufferedReader in = null;

			String content = null;
			try {
				// 定义HttpClient
				HttpClient client = new DefaultHttpClient();
				// 实例化HTTP方法
				HttpGet request = new HttpGet(url);
				HttpResponse response = client.execute(request);

				in = new BufferedReader(new InputStreamReader(response.getEntity()
						.getContent()));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				in.close();
				content = sb.toString();
			} finally {
				if (in != null) {
					try {
						in.close();// 最后要关闭BufferedReader
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return content;
			}
		}

}
