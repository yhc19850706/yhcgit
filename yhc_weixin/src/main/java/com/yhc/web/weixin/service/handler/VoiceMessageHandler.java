package com.yhc.web.weixin.service.handler;

import org.springframework.stereotype.Component;

import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;
import com.yhc.weixin.model.XMLTextMessage;

@Component
public class VoiceMessageHandler extends AbstractMessageHandler{

	@Override
	public String getMsgType() {
		return MSG_TYPE_VOICE;
	}
	
	@Override
	public XMLMessage handleMessage(WeixinMessage msg) {
		String content = msg.getRecognition();
		if(content.contains("签到")||content.contains("千岛")||content.contains("天道")){
			return yinhuMsgSupport.sign(msg);
		}else if(content.contains("收益")||content.contains("受益")||content.contains("手艺")||content.contains("兽医")){
			return yinhuMsgSupport.income(msg);
		}else if(content.contains("账户")||content.contains("帐户")||content.contains("账号")){
			return yinhuMsgSupport.account(msg);
		}else if(content.contains("预告")){
			return yinhuMsgSupport.itemNotice(msg);
		}else if(content.contains("平台")){
			return yinhuMsgSupport.platInfo(msg);
		}else if(content.contains("北京")||content.contains("背景")){
			return yinhuMsgSupport.background(msg);
		}else if(content.contains("你们")||content.contains("联系")||content.contains("电话")){
			return yinhuMsgSupport.contact(msg);
		}else{
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "小湖猜你说的是："+content);
		}
	}

}
