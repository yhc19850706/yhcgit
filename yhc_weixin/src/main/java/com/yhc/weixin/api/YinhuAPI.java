package com.yhc.weixin.api;

import java.util.List;

import com.yhc.common.utils.AESEcryptUtils;
import com.yhc.common.utils.EncryptUtil;
import com.yhc.common.utils.JacksonUtil;
import com.yhc.weixin.model.BaseResult;
import com.yhc.weixin.model.Loan;
import com.yhc.weixin.model.LoanList;
import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.WeiXinUser;

import static com.yhc.common.config.BlGlobalVariable.YHC_URI;

public class YinhuAPI extends BaseAPI{
	
	
	public BaseResult weixinBind(String weixinId,String username,String password) throws Exception{
		String encryptPwd = EncryptUtil.encrypt(password);
		WeiXinUser user = new WeiXinUser();
		user.setLoginId(username);
		user.setPassword(encryptPwd);
		user.setWxUid(weixinId);
		String jsonStr = JacksonUtil.doJackson(user);
		String info = AESEcryptUtils.encryptStr(jsonStr);
		return super.restTemplate.postForObject(
				YHC_URI+"/weixin/bind_weixin.bl?info={info}",
				null,
				BaseResult.class,
				info);
	}
	
	public void weixinUnBind(String weixinId){
		super.restTemplate.postForObject(
				YHC_URI+"/weixin/unbind_weixin.bl?wxUid={weixinId}",
				null,
				BaseResult.class,
				weixinId);
	}
	
	public Sign sign(String weixinId){
		return super.restTemplate.postForObject(
				YHC_URI+"/weixin/sign.bl?wxUid={weixinId}",
				null,
				Sign.class,
				weixinId);
	}
	
	public Personal getIncome(String weixinId){
		return super.restTemplate.getForObject(
				YHC_URI+"/weixin/getIncome.bl?wxUid={weixinId}",
				Personal.class,
				weixinId);
	}
	
	public Personal getAccount(String weixinId){
		return super.restTemplate.getForObject(
				YHC_URI+"/weixin/getAccount.bl?wxUid={weixinId}",
				Personal.class,
				weixinId);
	}
	
	public boolean userIsBind(String weixinId){
		BaseResult result = super.restTemplate.getForObject(
				YHC_URI+"/weixin/isBind.bl?wxUid={weixinId}",
				BaseResult.class,
				weixinId);
		if(result!=null&&result.getErrcode().equals("102")){
			return true;
		}
		return false;
	}
	
	public List<Loan> commingLoans(){
		return super.restTemplate.getForObject(
				YHC_URI+"/weixin/commingLoans.bl",
				LoanList.class);
	}
	
	public static void main(String[] args){
		//YinhuAPI api = new YinhuAPI();
		//Sign sign = api.sign("testweixinID");
		//Personal personal = api.getIncome("ocByyt7-7AHOEZ0daT7Qu2W5x4hA");
		//Personal personal = api.getAccount("testweixinID");
		//api.weixinUnBind("testweixinID");
	}
	
}
