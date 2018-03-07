package com.yhc.weixin.model;

import java.math.BigDecimal;

public class WxUserFriend {
	
	private String id;          //唯一主键
	private String nickName;    //朋友(包括自己)微信名称
	private String imgUrl;      //朋友(包括自己)微信头像链接
	private String wechatId;    //openId
	private String friendId;    //朋友(包括自己)的个人主页Id
	private BigDecimal grabAmt; //抢红包金额
	private String createDts;   //抢红包时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public BigDecimal getGrabAmt() {
		return grabAmt;
	}
	public void setGrabAmt(BigDecimal grabAmt) {
		this.grabAmt = grabAmt;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	
}
