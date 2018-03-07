package com.yhc.weixin.model;

import java.math.BigDecimal;

public class ReUser {
	
	private String ruId;          //用户红包ID
	private int reId;          //红包ID	
	private String userId;        //用户ID
	private BigDecimal reAmt;     //红包金额
	private String reUseStartDts; //红包有效开始时间
	private String reUseEndDts;   //红包有效截止时间
	private String delYn;         //删除与否
	private String createId;      //创建人
	private String createDts;     //创建时间
	private String updateId;      //修改人
	private String updaetDts;     //修改时间
	private String useYn;         //红包使用与否状态
	
	public String getRuId() {
		return ruId;
	}
	public void setRuId(String ruId) {
		this.ruId = ruId;
	}	
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getReAmt() {
		return reAmt;
	}
	public void setReAmt(BigDecimal reAmt) {
		this.reAmt = reAmt;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
	public String getUpdaetDts() {
		return updaetDts;
	}
	public void setUpdaetDts(String updaetDts) {
		this.updaetDts = updaetDts;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
}
