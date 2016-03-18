package com.yhc.web.weixin.service;

import java.util.List;

import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.UserSignin;
import com.yhc.weixin.model.WeiXinLoan;
import com.yhc.weixin.model.WeiXinUserFromApi;

public interface WeixinFromApiService {
	
	public WeiXinUserFromApi checkUser(WeiXinUserFromApi user);
	
	public WeiXinUserFromApi getUser(String wxUid);
	
	public void updateUserBind(WeiXinUserFromApi user);
	
	public void updateUserUnBind(String wxUid);
	
	public boolean isBind(String wxUid);
	
	public Personal getIncome(String wxUid);
	
	public Personal getAccount(String wxUid);
	
	public List<WeiXinLoan> commingLoans();

	public boolean hasSign(String wxUid);
	
	public Sign getSign(String wxUid);
	
}
