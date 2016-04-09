package com.yhc.web.weixin.action;

import static com.yhc.common.config.BlGlobalVariable.WEIXIN_TOKEN;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yhc.common.exception.WeixinException;
import com.yhc.web.weixin.service.WeixinService;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLMessage;
import com.yhc.weixin.util.SignatureUtil;
import com.yhc.weixin.util.XMLConverUtil;


@RestController
public class WeixinMPAction {
	
	@Resource(name = "weixinService")
	private WeixinService weixinService;
	
	@RequestMapping(value = "/api/weixin.wx",method=RequestMethod.GET)
	public @ResponseBody
	String authGet(@RequestParam("signature") String signature,
					@RequestParam("timestamp") String timestamp,
					@RequestParam("nonce") String nonce,
					@RequestParam("echostr") String echostr){
		if(signature.equals(SignatureUtil.generateEventMessageSignature(WEIXIN_TOKEN, timestamp, nonce))){
			return echostr;
		}else{
			return "error";
		}
	}

	@RequestMapping(value = "/api/weixin.wx",method=RequestMethod.POST)
	public @ResponseBody
	String authPost(@RequestParam("signature") String signature,
					@RequestParam("timestamp") String timestamp,
					@RequestParam("nonce") String nonce,
					@RequestBody String requestBody) throws WeixinException, Exception{
		if(!signature.equals(SignatureUtil.generateEventMessageSignature(WEIXIN_TOKEN, timestamp, nonce))){
			System.out.println("null");
			return null;
		}
		System.out.println(requestBody);
		WeixinMessage wxMessage = XMLConverUtil.convertToObject(requestBody,WeixinMessage.class);
		XMLMessage respMsg = weixinService.handleMessage(wxMessage);
		return respMsg==null?"":respMsg.toXML();
	}

}
