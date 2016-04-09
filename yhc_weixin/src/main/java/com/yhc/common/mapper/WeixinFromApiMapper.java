package com.yhc.common.mapper;

import java.util.List;

import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.PointRule;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.UserPoint;
import com.yhc.weixin.model.UserSignin;
import com.yhc.weixin.model.WeiXinLoan;
import com.yhc.weixin.model.WeiXinUserFromApi;

public interface WeixinFromApiMapper {

	WeiXinUserFromApi checkUser(WeiXinUserFromApi user); 
	
	WeiXinUserFromApi getUser(String wxUid); 
	
	void updateUserBind(WeiXinUserFromApi user); 
	
	void updateUserUnBind(String wxUid); 
	
	Personal getIncome(String wxUid); 
	
	Personal getAccount(String wxUid); 
	
	List<WeiXinLoan> commingLoans();
	
	int checkSign(String wxUid); 

	PointRule getPointRuleByPointType(String pointType);

	List<UserPoint> getUserPoint(UserPoint param);

	void insertUserPoint(UserPoint userPoint);

	void updateUserPoint(UserPoint userPoint);

	UserSignin getUserSignin(String userId);

	void insertUserSignin(UserSignin userSignin);

	void updateUserSignin(UserSignin userSignin);
	
	Sign getSign(String userId);
	
	

}
