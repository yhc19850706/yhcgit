package com.yhc.web.weixin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.common.config.BlGlobalVariable;
import com.yhc.common.mapper.AccTokenMapper;
import com.yhc.common.utils.DateUtils;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.weixin.api.TicketAPI;
import com.yhc.weixin.api.TokenAPI;
import com.yhc.weixin.model.AccessToken;

@Service("accTokenService")
public class AccTokenServiceImpl implements AccTokenService {

	@Autowired
	private AccTokenMapper accTokenMapper;
	private static TokenAPI tokenAPI = new TokenAPI();
	
	private static TicketAPI ticketAPI = new TicketAPI();
	
	public AccessToken addCurrentAccessToken(){
		long nh = 1000*60*60;//一小时的毫秒数
		
		String accessToken="";
		String jsapiTicket="";
		AccessToken accToken = null;
		try {
			accToken =accTokenMapper.getAccessToken();
			if (null ==accToken){
				//应用第一次请求时生成头一次access_token
				accessToken = tokenAPI.token(BlGlobalVariable.WEIXIN_APPID, BlGlobalVariable.WEIXIN_SECRET).getAccess_token();
				accToken = new AccessToken();
				accToken.setAccessToken(accessToken);
				
				jsapiTicket = ticketAPI.ticketGetticket(accessToken).getTicket();
				accToken.setJsapiTicket(jsapiTicket);
				
				accToken.setCreateDts(DateUtils.getCurDtsStr());
				
				//数据库里保存当前的access_token
				accTokenMapper.insertAccessToken(accToken);
			}else {
				long longCurDts = DateUtils.getCurrentMillisecond();
				long longDbDts=0;
				String updateDts = accToken.getUpdateDts();
				if(null==updateDts||"".equals(updateDts)){
					longDbDts = DateUtils.parseStringToLong(accToken.getCreateDts());
				}else{
					longDbDts = DateUtils.parseStringToLong(accToken.getUpdateDts());
				}
				//用当前时间比较数据库最后一次生成access_token 的时间超过一个小时就重新生成新的access_token
				if(longCurDts - longDbDts > nh){
					accessToken = tokenAPI.token(BlGlobalVariable.WEIXIN_APPID, BlGlobalVariable.WEIXIN_SECRET).getAccess_token();
					accToken.setAccessToken(accessToken);
					accToken.setUpdateDts(DateUtils.getCurDtsStr());
					jsapiTicket = ticketAPI.ticketGetticket(accessToken).getTicket();
					accToken.setJsapiTicket(jsapiTicket);
					accTokenMapper.updateAccessTokenById(accToken);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  accToken;
	}
}
