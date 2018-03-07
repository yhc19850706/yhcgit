package com.yhc.weixin.model;

public class AccessToken {

	private String id;          //id pk
	private String accessToken; //access_token是公众号的全局唯一票据
	private String jsapiTicket; //微信提供的js的 api 也是唯一的ticket
	private String createDts;   //创建时间
	private String updateDts;   //修改时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getJsapiTicket() {
		return jsapiTicket;
	}
	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	public String getUpdateDts() {
		return updateDts;
	}
	public void setUpdateDts(String updateDts) {
		this.updateDts = updateDts;
	}
	
	

}
