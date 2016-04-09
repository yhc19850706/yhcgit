package com.yhc.weixin.model;

import java.math.BigDecimal;

public class WxUserProfile {
	
	private String profileId;      //微信抢红包个人主页Id
	private String nickName;    //微信名称
	private String imgUrl;      //微信头像链接
	private String wechatId;    //openId
	private String grabYn;      //是否抢过自己的钱包
	private BigDecimal redAmt;  //抢红包总金额
	private String exchangeYn;  //兑换红包与否
	private String exchangeDts; //兑换红包时间
	private String createDts;   //创建个人主页时间
	private String updateDts;   //修改时间
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
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
	public String getGrabYn() {
		return grabYn;
	}
	public void setGrabYn(String grabYn) {
		this.grabYn = grabYn;
	}
	public BigDecimal getRedAmt() {
		return redAmt;
	}
	public void setRedAmt(BigDecimal redAmt) {
		this.redAmt = redAmt;
	}
	public String getExchangeYn() {
		return exchangeYn;
	}
	public void setExchangeYn(String exchangeYn) {
		this.exchangeYn = exchangeYn;
	}
	public String getExchangeDts() {
		return exchangeDts;
	}
	public void setExchangeDts(String exchangeDts) {
		this.exchangeDts = exchangeDts;
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
