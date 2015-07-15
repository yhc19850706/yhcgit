package com.bl.web.common.model;

import java.math.BigDecimal;

public class UserInfo {

	private String userId;
	private String userRealNm;
	private String userMobile;
	private String visitorDts;
	private String registDts;
	private String bindingDts;
	private String tradeFirstDts;
	private String tradeLastDts;
	private String tradeNumber;
	private BigDecimal monthRepayAmt;
	private String monthDts;
	private String remarks;
	private String empId;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRealNm() {
		return userRealNm;
	}
	public void setUserRealNm(String userRealNm) {
		this.userRealNm = userRealNm;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getVisitorDts() {
		return visitorDts;
	}
	public void setVisitorDts(String visitorDts) {
		this.visitorDts = visitorDts;
	}
	public String getRegistDts() {
		return registDts;
	}
	public void setRegistDts(String registDts) {
		this.registDts = registDts;
	}
	public String getBindingDts() {
		return bindingDts;
	}
	public void setBindingDts(String bindingDts) {
		this.bindingDts = bindingDts;
	}
	public String getTradeFirstDts() {
		return tradeFirstDts;
	}
	public void setTradeFirstDts(String tradeFirstDts) {
		this.tradeFirstDts = tradeFirstDts;
	}
	public String getTradeLastDts() {
		return tradeLastDts;
	}
	public void setTradeLastDts(String tradeLastDts) {
		this.tradeLastDts = tradeLastDts;
	}
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public BigDecimal getMonthRepayAmt() {
		return monthRepayAmt;
	}
	public void setMonthRepayAmt(BigDecimal monthRepayAmt) {
		this.monthRepayAmt = monthRepayAmt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getMonthDts() {
		return monthDts;
	}
	public void setMonthDts(String monthDts) {
		this.monthDts = monthDts;
	}
	
}
