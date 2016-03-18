package com.yhc.web.weixin.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.common.mapper.WeixinFromApiMapper;
import com.yhc.web.weixin.service.WeixinFromApiService;
import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.WeiXinLoan;
import com.yhc.weixin.model.WeiXinUserFromApi;

@Service("weixinFromApiService")
public class WeixinFromApiServiceImpl implements WeixinFromApiService{
	
	@Autowired
	private WeixinFromApiMapper weixinFromApiMapper;

	@Override
	public WeiXinUserFromApi checkUser(WeiXinUserFromApi user) {
		if(user.getLoginId().contains("@")) {
			user.setEmail(user.getLoginId());
		}
		else if(isNumeric(user.getLoginId())) {
			user.setMobileNo(user.getLoginId());
		}
		else{
			user.setUserNm(user.getLoginId());
		}
		return weixinFromApiMapper.checkUser(user);
	}

	@Override
	public void updateUserBind(WeiXinUserFromApi user) {
		weixinFromApiMapper.updateUserBind(user);
	}

	@Override
	public void updateUserUnBind(String wxUid) {
		weixinFromApiMapper.updateUserUnBind(wxUid);
	}

	@Override
	public boolean isBind(String wxUid) {
		return this.getUser(wxUid)!=null;
	}
	
	@Override
	public boolean hasSign(String wxUid) {
		return weixinFromApiMapper.checkSign(wxUid)>0;
	}

	@Override
	public Sign getSign(String userId) {
		return weixinFromApiMapper.getSign(userId);
	}
	

	@Override
	public Personal getIncome(String wxUid) {
		return weixinFromApiMapper.getIncome(wxUid);
	}

	@Override
	public Personal getAccount(String wxUid) {
		return weixinFromApiMapper.getAccount(wxUid);
	}

	@Override
	public List<WeiXinLoan> commingLoans() {
		return weixinFromApiMapper.commingLoans();
	}

	@Override
	public WeiXinUserFromApi getUser(String wxUid) {
		return weixinFromApiMapper.getUser(wxUid);
	}
	
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 }

}
