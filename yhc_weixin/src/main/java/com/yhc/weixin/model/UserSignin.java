package com.yhc.weixin.model;

public class UserSignin {
	private String userId;
	private int continueSigninCnt;
	private String signinDts;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getContinueSigninCnt() {
		return continueSigninCnt;
	}

	public void setContinueSigninCnt(int continueSigninCnt) {
		this.continueSigninCnt = continueSigninCnt;
	}

	public String getSigninDts() {
		return signinDts;
	}

	public void setSigninDts(String signinDts) {
		this.signinDts = signinDts;
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
