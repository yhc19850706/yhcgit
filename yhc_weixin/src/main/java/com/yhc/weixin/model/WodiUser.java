package com.yhc.weixin.model;

public class WodiUser {
	
	private String openId;
	
	private String name;
	
	public WodiUser(String openId, String name) {
		this.openId = openId;
		this.name = name;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
