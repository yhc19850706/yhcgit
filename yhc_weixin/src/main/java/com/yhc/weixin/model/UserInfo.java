package com.yhc.weixin.model;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.yhc.common.utils.DateUtils;

public class UserInfo {

	//用户ID
	private String userId;
	//用户名
	private String userNm;
	//用户登陆密码
	private String userPw;
	//用户提现密码
	private String userCashPw;
	//用户类型(我要理财，我要借款)
	private String userType;
	//用户积分
	private int userPoint;
	//创建者id
	private String createId;
	//创建时间(14位 :20130102152031)
	private String createDts;
	//更新者id
	private String updateId;
	//创建时间(14位 :20130102152031)
	private String updateDts;
	//邮箱地址
	private String email;
	//手机号
	private String mobileNo;
	//用户登录的时候填写的ID
	private String loginId;
	//用户输入的验证码
	private String code;

	private boolean remember;
	//手机短信验证码
	private String smsCode;

	private String userRealNm;
	private String userIdcardNo;
	private String userHeadFileDir;
	private String hukouProvince;
	private String hukouCity;

	// 签到
	private int continueSigninCnt;
	private String userGradeNm;
	private String userGrade;
	

	private int userNextGradeInterval;
	private String signinDts;
	private boolean signed;
	private String signinDtsWeek;
	private String signinDtsWeekStr;

	//原密码 
	private String oriUserPw;
	
	//广告来源名称
	private String sourceNm;
	
	//广告来源代码
	private String sourceCode;
	
	private String sourceMedium;
	
	private String sourceCampaign;
	
	//允许访问与否(用户ID不以RXT开头的,融信通还款中的用户,限制访问)
	private String accessYn;
	
	//用户邀请码
	private int inviteCode;
	
	private String clientSide;
	
	private BigDecimal sumOriginAmt;
	
	public String getSourceNm() {
		return sourceNm;
	}

	public void setSourceNm(String sourceNm) {
		this.sourceNm = sourceNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserCashPw() {
		return userCashPw;
	}

	public void setUserCashPw(String userCashPw) {
		this.userCashPw = userCashPw;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateDts() {
		return createDts;
	}

	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateDts() {
		return updateDts;
	}

	public void setUpdateDts(String updateDts) {
		this.updateDts = updateDts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getUserRealNm() {
		return userRealNm;
	}

	public void setUserRealNm(String userRealNm) {
		this.userRealNm = userRealNm;
	}

	public String getUserIdcardNo() {
		return userIdcardNo;
	}

	public void setUserIdcardNo(String userIdcardNo) {
		this.userIdcardNo = userIdcardNo;
	}

	public String getUserHeadFileDir() {
		return userHeadFileDir;
	}

	public void setUserHeadFileDir(String userHeadFileDir) {
		this.userHeadFileDir = userHeadFileDir;
	}

	public String getHukouProvince() {
		return hukouProvince;
	}

	public void setHukouProvince(String hukouProvince) {
		this.hukouProvince = hukouProvince;
	}

	public String getHukouCity() {
		return hukouCity;
	}

	public void setHukouCity(String hukouCity) {
		this.hukouCity = hukouCity;
	}

	public int getContinueSigninCnt() {
		return continueSigninCnt;
	}

	public void setContinueSigninCnt(int continueSigninCnt) {
		this.continueSigninCnt = continueSigninCnt;
	}

	public String getUserGradeNm() {
		return userGradeNm;
	}

	public void setUserGradeNm(String userGradeNm) {
		this.userGradeNm = userGradeNm;
	}

	public int getUserNextGradeInterval() {
		return userNextGradeInterval;
	}

	public void setUserNextGradeInterval(int userNextGradeInterval) {
		this.userNextGradeInterval = userNextGradeInterval;
	}

	public String getSigninDts() {
		return signinDts;
	}

	public void setSigninDts(String signinDts) {
		this.signinDts = signinDts;
	}

	public String getSigninDtsWeek() {
		return signinDtsWeek;
	}

	public void setSigninDtsWeek(String signinDtsWeek) {
		this.signinDtsWeek = signinDtsWeek;
	}

	public String getSigninDtsWeekStr() {
		return signinDtsWeekStr;
	}

	public String getOriUserPw() {
		return oriUserPw;
	}

	public void setOriUserPw(String oriUserPw) {
		this.oriUserPw = oriUserPw;
	}

	public boolean isSigned() {
		signed = false;
		if(StringUtils.isNotEmpty(signinDts) && DateUtils.getCurDtStr().equals(signinDts.substring(0,8))){
			signed = true;
		}
		return signed;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getAccessYn() {
		return accessYn;
	}

	public void setAccessYn(String accessYn) {
		this.accessYn = accessYn;
	}

	public int getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(int inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getClientSide() {
		return clientSide;
	}

	public void setClientSide(String clientSide) {
		this.clientSide = clientSide;
	}
	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public BigDecimal getSumOriginAmt() {
		return sumOriginAmt;
	}

	public void setSumOriginAmt(BigDecimal sumOriginAmt) {
		this.sumOriginAmt = sumOriginAmt;
	}

	public String getSourceMedium() {
		return sourceMedium;
	}

	public void setSourceMedium(String sourceMedium) {
		this.sourceMedium = sourceMedium;
	}

	public String getSourceCampaign() {
		return sourceCampaign;
	}

	public void setSourceCampaign(String sourceCampaign) {
		this.sourceCampaign = sourceCampaign;
	}
	
}
