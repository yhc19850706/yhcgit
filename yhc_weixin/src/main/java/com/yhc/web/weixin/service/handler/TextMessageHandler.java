package com.yhc.web.weixin.service.handler;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.yhc.common.config.BlGlobalVariable;
import com.yhc.weixin.api.MessageAPI;
import com.yhc.weixin.api.TulingApiProcess;
import com.yhc.weixin.model.TulingList;
import com.yhc.weixin.model.TulingResponse;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;
import com.yhc.weixin.model.XMLNewsMessage;
import com.yhc.weixin.model.XMLTextMessage;
import com.yhc.weixin.model.XMLNewsMessage.Article;


@Component
public class TextMessageHandler extends AbstractMessageHandler{
	
	private MessageAPI messageAPI = new MessageAPI();
	
	@Override
	public String getMsgType() {
		return MSG_TYPE_TEXT;
	}

	@Override
	public XMLMessage handleMessage(WeixinMessage msg) {
		String content = StringUtils.trimToEmpty(msg.getContent());
		if(StringUtils.isNotBlank(content)){
			TulingResponse response=new TulingResponse();
			TulingApiProcess process=new TulingApiProcess();
			response=process.getTulingResponse(content,msg.getToUserName());
			if(Integer.parseInt(response.getCode())<100000){
				return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),response.getText());
			}else{
				if(Integer.parseInt(response.getCode())==100000){
					return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),response.getText());
				}else if(Integer.parseInt(response.getCode())==200000){
					return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),response.getTextUrl());
				}else if(Integer.parseInt(response.getCode())==302000){
					List<TulingList> list=response.getList();
					List<Article> articles = Lists.newArrayList();
					int i=1;
					if(list!=null&&list.size()>0){
						for(TulingList tl:list){
							Article article = new Article();
							article.setDescription(tl.getSource());
							article.setTitle(tl.getArticle());
							article.setPicurl(tl.getIcon());
							article.setUrl(tl.getDetailurl());
							articles.add(article);
							i++;
							if(i>10){
								break;
							}
						}
					}
					return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
				}else if(Integer.parseInt(response.getCode())==308000){
					List<TulingList> list=response.getList();
					List<Article> articles = Lists.newArrayList();
					int i=1;
					if(list!=null&&list.size()>0){
						for(TulingList tl:list){
							Article article = new Article();
							article.setDescription(tl.getInfo());
							article.setTitle(tl.getName());
							article.setPicurl(tl.getIcon());
							article.setUrl(tl.getDetailurl());
							articles.add(article);
							i++;
							if(i>10){
								break;
							}
						}
					}
					return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
				}else if(Integer.parseInt(response.getCode())==313000){
					return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),response.getText());
				}else if(Integer.parseInt(response.getCode())==314000){
					return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),response.getText());
				}
			}
			
		}
		return super.handleMessage(msg);
	}
	
	

}
