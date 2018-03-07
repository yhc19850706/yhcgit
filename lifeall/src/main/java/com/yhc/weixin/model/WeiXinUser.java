package com.yhc.weixin.model;

public class WeiXinUser {
	
	private String loginId;
	private String password;
	private String wxUid;
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWxUid() {
		return wxUid;
	}

	public void setWxUid(String wxUid) {
		this.wxUid = wxUid;
	}
}
