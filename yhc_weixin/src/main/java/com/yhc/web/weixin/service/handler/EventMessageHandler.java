package com.yhc.web.weixin.service.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yhc.common.utils.Constants;
import com.yhc.web.weixin.service.WeixinEventMsgService;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

@Component
public class EventMessageHandler extends AbstractMessageHandler{
	
	@Resource(name = "weixinEventMsgService")
	private WeixinEventMsgService weixinEventMsgService;
	
	@Override
	public XMLMessage handleMessage(WeixinMessage msg) {
		String event = msg.getEvent();
		String eventKey = msg.getEventKey();
		if(event.equals(Constants.EVENT_SUB)){//关注
			return weixinEventMsgService.follow(msg);
		} else if(event.equals(Constants.EVENT_UNSUB)){//取消关注
			return weixinEventMsgService.unFollow(msg);
		}else if(event.equals(Constants.EVENT_TEMPLATE)){//发送模板消息返回结果
			return weixinEventMsgService.template(msg);
		}
		if(eventKey.equals(Constants.EVENT_CURTAIN_TYPE)){//窗帘类型
			return weixinEventMsgService.sign(msg);
		}else if(eventKey.equals(Constants.EVENT_PLATINFO)){//门店信息
			return weixinEventMsgService.platInfo(msg);
		}else if(eventKey.equals(Constants.EVENT_PREVIEW)){//预览
			return weixinEventMsgService.contact(msg);
		}else if(eventKey.equals(Constants.EVENT_NEW_PRODUCT_NOTICE)){//新产品通知
			return weixinEventMsgService.contact(msg);
		}else{
			return super.handleMessage(msg);
		}
	}
	

	@Override
	public String getMsgType() {
		return MSG_TYPE_EVENT;
	}
	
	public static void main(String[] args){
		EventMessageHandler handler = new EventMessageHandler();
		WeixinMessage msg = new WeixinMessage();
		msg.setEvent("click");
		msg.setEventKey("item");
		msg.setFromUserName("ocByyt7-7AHOEZ0daT7Qu2W5x4hA");
		handler.handleMessage(msg);
	}
	

}
