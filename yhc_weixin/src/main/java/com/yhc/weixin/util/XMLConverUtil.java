package com.yhc.weixin.util;


import com.thoughtworks.xstream.XStream;
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
		String str = "<xml>"
					+"<ToUserName><![CDATA[toUser]]></ToUserName>"
					+"<FromUserName><![CDATA[fromUser]]></FromUserName> "
					+"<CreateTime>1348831860</CreateTime>"
					+"<MsgType><![CDATA[text]]></MsgType>"
					+"<Content><![CDATA[this is a test]]></Content>"
					+"<MsgId>1234567890123456</MsgId>"
					+"</xml>";
		WeixinMessage msg =  convertToObject(str,WeixinMessage.class);
		System.out.println(convertToXML(msg));
	}
}
