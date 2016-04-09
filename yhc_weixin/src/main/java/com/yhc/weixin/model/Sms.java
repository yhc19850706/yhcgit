package com.yhc.weixin.model;

public class Sms {

	private int smsNo;
	private String userId;
	private String mobileNo;
	//验证码6位数字
	private String soceurCd;
	//验证码有效期开始时间
	private String validStartDts;
	//验证码有效期结束时间
	private String validEndDts;
	//创建者id
	private String createId;
	//创建时间(14位 :20130102152031)
	private String createDts;
	//更新者id
	private String updateId;
	//创建时间(14位 :20130102152031)
	private String updateDts;
	
	
	public int getSmsNo() {
		return smsNo;
	}
	public void setSmsNo(int smsNo) {
		this.smsNo = smsNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getSoceurCd() {
		return soceurCd;
	}
	public void setSoceurCd(String soceurCd) {
		this.soceurCd = soceurCd;
	}
	public String getValidStartDts() {
		return validStartDts;
	}
	public void setValidStartDts(String validStartDts) {
		this.validStartDts = validStartDts;
	}
	public String getValidEndDts() {
		return validEndDts;
	}
	public void setValidEndDts(String validEndDts) {
		this.validEndDts = validEndDts;
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

	
}
