package com.yhc.weixin.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.yhc.weixin.model.WeixinMessage;

/**
 * XML 数据接收对象转换工具类
 */
public class XMLConverUtil{
	
	private static final XStream xs = new XStream(new StaxDriver());
	static {
		xs.autodetectAnnotations(true);
	}
	/**
	 * XML to Object
	 * @param <T>
	 * @param clazz
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T  convertToObject(String xmlStr,Class<T> cls){
		XStream xstream=new XStream(new StaxDriver());
        xstream.processAnnotations(cls);
        T obj=(T)xstream.fromXML(xmlStr);
        return obj;        
    } 
	
	/**
	 * Object to XML
	 * @param object
	 * @return
	 */
	public static String convertToXML(Object object){
		return xs.toXML(object);
	}
	
	public static void main(String[] args){
		String str ="<xml><ToUserName><![CDATA[gh_ac3514c7645d]]></ToUserName>\n" +
				"<FromUserName><![CDATA[ocuUKv7M9mnY1xFRglBgjJpdxJHk]]></FromUserName>\n" +
				"<CreateTime>1522163684</CreateTime>\n" +
				"<MsgType><![CDATA[text]]></MsgType>\n" +
				"<Content><![CDATA[gg]]></Content>\n" +
				"<MsgId>6537643242424511823</MsgId>\n" +
				"</xml>";
		WeixinMessage msg =  convertToObject(str,WeixinMessage.class);
		System.out.println(convertToXML(msg));
	}
}
