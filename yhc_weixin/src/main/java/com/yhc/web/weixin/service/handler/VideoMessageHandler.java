package com.yhc.web.weixin.service.handler;

import org.springframework.stereotype.Component;

@Component
public class VideoMessageHandler extends AbstractMessageHandler{

	@Override
	public String getMsgType() {
		return MSG_TYPE_VIDEO;
	}

}
