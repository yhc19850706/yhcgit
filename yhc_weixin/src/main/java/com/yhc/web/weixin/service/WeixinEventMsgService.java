package com.yhc.web.weixin.service;

import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

public interface WeixinEventMsgService {
	/**
	 *关注
	 * 
	 **/
	public XMLMessage follow(WeixinMessage msg);
	/**
	 *取消关注
	 * 
	 **/
	public  XMLMessage unFollow(WeixinMessage msg);	
	/**
	 *每日签到
	 * 
	 **/
	public  XMLMessage sign(WeixinMessage msg);	
	/**
	 *平台简介
	 * 
	 **/
	public  XMLMessage platInfo(WeixinMessage msg);	
	/**
	 *股东背景
	 * 
	 **/
	public  XMLMessage background(WeixinMessage msg);	
	/**
	 *联系我们
	 * 
	 **/
	public  XMLMessage contact(WeixinMessage msg);
	/**
	 * @MethodName:template
	 * @param msg
	 * @return XMLMessage
	 * @Description:模板消息发送结果
	 * @author Yhc yinhc@yinhu.com
	 */
		
	public XMLMessage template(WeixinMessage msg);

}
