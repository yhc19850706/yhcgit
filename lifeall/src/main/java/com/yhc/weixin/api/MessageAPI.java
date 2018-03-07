package com.yhc.weixin.api;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhc.weixin.model.BaseResult;
import com.yhc.weixin.model.Message;
import com.yhc.weixin.model.TemplateMessage;
import com.yhc.weixin.model.TemplateMessageResult;
import org.springframework.http.*;

import java.nio.charset.Charset;

/**
 * 当用户主动发消息给公众号的时候
 * （包括发送信息、点击自定义菜单click事件、订阅事件、扫描二维码事件、支付成功事件、用户维权），
 * 微信将会把消息数据推送给开发者，
 * 开发者在一段时间内（目前修改为48小时）可以调用客服消息接口，
 * 通过POST一个JSON数据包来发送消息给普通用户，
 * 在48小时内不限制发送次数。
 * 此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
 *
 */
public class MessageAPI extends BaseAPI{
	
	private ObjectMapper objectMapper  = new ObjectMapper();
	
	{
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,false);
	}
	
	/**
	 * 消息发送
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token, String messageJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/custom/send?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 消息发送
	 * @param access_token
	 * @param message
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token, Message message){
		try {
			String str = objectMapper.writeValueAsString(message);
			return messageCustomSend(access_token,str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 模板消息发送
	 * @param access_token
	 * @param templateMessage
	 * @return
	 */
	public  TemplateMessageResult messageTemplateSend(String access_token,TemplateMessage templateMessage){
		try {
			String messageJson = objectMapper.writeValueAsString(templateMessage);
			MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(mediaType);
			HttpEntity<String> httpEntity = new HttpEntity<String>(messageJson,headers);
			ResponseEntity<TemplateMessageResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/message/template/send?access_token={access_token}", HttpMethod.POST,httpEntity,TemplateMessageResult.class, access_token);
			return responseEntity.getBody();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
