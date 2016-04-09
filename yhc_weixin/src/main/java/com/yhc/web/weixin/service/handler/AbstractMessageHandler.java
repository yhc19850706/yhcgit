package com.yhc.web.weixin.service.handler;

import com.yhc.web.weixin.service.MessageHandler;
import com.yhc.web.weixin.service.handler.support.YihuMsgSupport;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

public abstract class AbstractMessageHandler implements MessageHandler{
	
	protected YihuMsgSupport yinhuMsgSupport = new YihuMsgSupport();
	
	@Override
	public XMLMessage handleMessage(WeixinMessage msg) {
		return yinhuMsgSupport.defaultReply(msg);
	}

}
