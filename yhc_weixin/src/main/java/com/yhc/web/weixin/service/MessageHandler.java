package com.yhc.web.weixin.service;

import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

public interface MessageHandler {
	
	/** 文本消息 */
	final String MSG_TYPE_TEXT = "text";
	/** 图片消息 */
	final String MSG_TYPE_IMAGE = "image";
	/** 语音消息 */
	final String MSG_TYPE_VOICE = "voice";
	/** 视频消息 */
	final String MSG_TYPE_VIDEO = "video";
	/** 地理位置消息 */
	final String MSG_TYPE_LOCATION = "location";
	/** 链接消息 */
	final String MSG_TYPE_LINK = "link";
	/** 事件消息 */
	final String MSG_TYPE_EVENT = "event";
	
	public XMLMessage handleMessage(WeixinMessage msg);
	
	public String getMsgType();

}
