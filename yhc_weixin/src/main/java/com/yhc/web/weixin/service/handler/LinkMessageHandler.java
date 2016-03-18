package com.yhc.web.weixin.service.handler;

import org.springframework.stereotype.Component;

@Component
public class LinkMessageHandler extends AbstractMessageHandler{

	@Override
	public String getMsgType() {
		return MSG_TYPE_LINK;
	}

}
