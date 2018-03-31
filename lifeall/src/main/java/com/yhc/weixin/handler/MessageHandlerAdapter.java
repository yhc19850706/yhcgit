package com.yhc.weixin.handler;

import com.yhc.weixin.model.MessageType;
import com.yhc.weixin.model.WeixinMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * 消息适配器:对于特定的消息类型进行适配,如text文本、voice语音消息
 * 
 * @className MessageHandlerAdapter
 */
@SuppressWarnings("unchecked")
public class MessageHandlerAdapter {

	private MessageType msgType;



	public void doHandle(){

	}


}
