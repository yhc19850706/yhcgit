package com.yhc.web.weixin.action;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.yhc.common.utils.Constants;
import com.yhc.common.utils.EncryptUtil;
import com.yhc.common.utils.JacksonUtil;
import com.yhc.common.utils.Md5Util;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.weixin.api.MessageAPI;
import com.yhc.weixin.model.AccessToken;
import com.yhc.weixin.model.TemplateMessage;
import com.yhc.weixin.model.TemplateMessageData;
import com.yhc.weixin.model.TemplateMessageItem;
import com.yhc.weixin.model.TemplateMessageResult;
@Controller
public class WeixinTemplateAction {
	Log logger=LogFactory.getLog(WeixinTemplateAction.class);
	@Resource(name="accTokenService")
	private AccTokenService accTokenService;
	
	private static final String KEY_CODE = "6InnDpeVBhxksVPyN4VNh3m9RXppOB";
	

	

	/**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
	@RequestMapping(value = "/api/template.bl",method=RequestMethod.GET)
    public ModelAndView send_template_message() {
		ModelAndView mav = new ModelAndView();
		TemplateMessageItem first=new TemplateMessageItem("购买3个产品", "");
		TemplateMessageItem keynote1=new TemplateMessageItem("100000", "#FF0000");
		TemplateMessageItem keynote2=new TemplateMessageItem("2015年12月1日", "");
		TemplateMessageItem keynote3=new TemplateMessageItem("香蕉你个巴拉", "");
		LinkedHashMap<String,TemplateMessageItem> data=Maps.newLinkedHashMap();
		data.put("first", first);
		data.put("keyword1", keynote1);
		data.put("keyword2", keynote2);
		data.put("remark", keynote3);
		TemplateMessage templateMessage=new TemplateMessage();
		templateMessage.setData(data);
		templateMessage.setTemplate_id("lp-PpKKyiclnrhmGumJIV0t0YQHDlyTn9k6isL6axBU");
		templateMessage.setTouser("ocuUKv7M9mnY1xFRglBgjJpdxJHk");
		templateMessage.setTopcolor("#FF3E96");
//		String jsonString=JacksonUtil.doJackson(templateMessage);
		try {
			AccessToken accessToken=accTokenService.addCurrentAccessToken();
			String access_token=accessToken.getAccessToken();
			TemplateMessageResult result=new MessageAPI().messageTemplateSend(access_token, templateMessage);
		     if(result!=null){
		    	 System.out.println(result.getErrcode());
			     System.out.println(result.getErrmsg());
			     System.out.println(result.getMsgid()); 
		     }
		     mav.setViewName("error/403");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mav.setViewName("error/404");
		}
	     return mav;
	}
	
	/**
	 * 
	 * @MethodName:sendRechargeTemplate
	 * @param postData 模板消息
	 * @throws Exception
	 * @Description:发送模板消息
	 * @author Yhc yinhc@yinhu.com
	 */
	@RequestMapping(value = "/api/send_template.bl",method=RequestMethod.POST)
	public @ResponseBody String sendTemplateMessage(String postData)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		postData=EncryptUtil.jasyptDecrypt(new String(Base64.decodeBase64(postData.getBytes())));
		TemplateMessageData messageData=JacksonUtil.convertJson2Bean(postData, TemplateMessageData.class);
		sb.append(Md5Util.getMD5Lower(messageData.getWechatId()));
		sb.append(".");
		sb.append(KEY_CODE);
		sb.append(".");
		sb.append(Md5Util.getMD5Lower(messageData.getTemplateId()));
		String signChk =  Md5Util.getMD5Lower(sb.toString());
		if (StringUtils.isNotBlank(messageData.getSign())&&signChk.equals(messageData.getSign())) {
			//匹配sign
			
			Map<String,String> dataMap=messageData.getDataMap();
			LinkedHashMap<String,TemplateMessageItem> data=Maps.newLinkedHashMap();
			for(Entry<String, String> entry:dataMap.entrySet()){    
				TemplateMessageItem  keynote=new TemplateMessageItem(entry.getValue(),"");
				data.put(entry.getKey(), keynote);
			}
			TemplateMessage templateMessage=new TemplateMessage();
			templateMessage.setData(data);
			templateMessage.setTemplate_id(Constants.WEIXIN_TEMPLATE_ID_MAP.get(messageData.getTemplateId()));
			templateMessage.setTouser(messageData.getWechatId());
			try {
				AccessToken accessToken=accTokenService.addCurrentAccessToken();
				String access_token=accessToken.getAccessToken();
				TemplateMessageResult result=new MessageAPI().messageTemplateSend(access_token, templateMessage);
			     if(result!=null){
			    	logger.info("<<<<< WeixinTemplateAction sendTemplateMessage end wechatId["+messageData.getWechatId()+"] TemplateId["+templateMessage.getTemplate_id()+"]>>>>>>>>");
					logger.info("<<<<< WeixinTemplateAction sendTemplateMessage Errcode["+result.getErrcode()+"] Errmsg["+result.getErrmsg()+"] Msgid["+result.getMsgid()+"]>>>>>>>>");
				     return "ERROR CODE=["+result.getErrcode()+"]Errmsg["+result.getErrmsg()+"]";
			     }else{
			    	 logger.info("<<<<< WeixinTemplateAction sendTemplateMessage fail wechatId["+messageData.getWechatId()+"] TemplateId["+templateMessage.getTemplate_id()+"]>>>>>>>>");
			    	 return "fail";
			     }
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("<<<<< WeixinTemplateAction sendTemplateMessage exception wechatId["+messageData.getWechatId()+"] TemplateId["+templateMessage.getTemplate_id()+"]>>>>>>>>");
				e.printStackTrace();
				 return "exception";
			}
		}else{
			logger.info("<<<<< WeixinTemplateAction sendTemplateMessage exception wechatId["+messageData.getWechatId()+"] TemplateId["+messageData.getTemplateId()+"]>>>>>>>>");
			return "sign error";
		}	
	}
	

	
}

	