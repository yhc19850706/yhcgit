package com.yhc.web.weixin.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.google.common.collect.Maps;
import com.yhc.common.exception.WeixinException;
import com.yhc.web.weixin.service.MessageHandler;
import com.yhc.web.weixin.service.WeixinService;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;

public class WeixinServiceImpl implements WeixinService,InitializingBean,ApplicationContextAware{
	private static final Log logger = LogFactory.getLog(WeixinServiceImpl.class );
	private ApplicationContext context;
	
	private Map<String, MessageHandler> handlers = Maps.newHashMap();
	
	@Override
	public XMLMessage handleMessage(WeixinMessage msg) throws WeixinException {
		MessageHandler handler = handlers.get(msg.getMsgType());
		if(handler==null){
			throw new WeixinException("未知的消息类型");
		}
		return handler.handleMessage(msg);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String,MessageHandler> handlerBeanMap= context.getBeansOfType(MessageHandler.class);
		for(Entry<String, MessageHandler> entry:handlerBeanMap.entrySet()){
			handlers.put(entry.getValue().getMsgType(), entry.getValue());
		}
		logger.info("MessageHandler 加载完成");
	}

	@Override
	public void setApplicationContext(ApplicationContext inputContext)
			throws BeansException {
		logger.info("ApplicationContext 注入完成");
		context = inputContext;
	}

}
