package com.yhc.weixin.model;

public class RedEnvelopesUser extends RedEnvelopes{
	
	private String reUserId;//用户红包ID
	
	private String userId;//用户ID
	
	private String reUseStartDts;//红包有效开始时间
	
	private String reUseEndDts;//红包有效截止时间
	
	private String useYn;//红包使用与否状态
	
	private String creditId; //投资红包，投资的债权ID
	
	public String getReUserId() {
		return reUserId;
	}

	public void setReUserId(String reUserId) {
		this.reUserId = reUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReUseStartDts() {
		return reUseStartDts;
	}

	public void setReUseStartDts(String reUseStartDts) {
		this.reUseStartDts = reUseStartDts;
	}

	public String getReUseEndDts() {
		return reUseEndDts;
	}

	public void setReUseEndDts(String reUseEndDts) {
		this.reUseEndDts = reUseEndDts;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
}
