package com.yhc.weixin.model;

import java.math.BigDecimal;

public class CjUser {
	private String profileId;
	private String mobileNo;
	private BigDecimal redAmt;
	private String type;
	private String createDts;
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public BigDecimal getRedAmt() {
		return redAmt;
	}
	public void setRedAmt(BigDecimal redAmt) {
		this.redAmt = redAmt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}	
}
