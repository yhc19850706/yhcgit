package com.yhc.weixin.model;

public class WxStatistics {
	
	private String id;        //pk
	private String profileId;    //用户ID
	private String activeId;  //活动ID
	private String shareType; //分享方式 1：发送给朋友 2：发送到朋友圈
	private String createDts; //创建时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getActiveId() {
		return activeId;
	}
	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}
	public String getShareType() {
		return shareType;
	}
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	
}
