package com.yhc.web.weixin.service;

import com.yhc.common.exception.WeixinException;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

public interface WeixinService {
	
	public XMLMessage handleMessage(WeixinMessage msg) throws WeixinException;

}
