package com.bl.web.common.model;

import java.math.BigDecimal;

public class DyhCreditRepay {

	private int repayId;
	private String creditId;
	private String repayStatus;
	private String repayDt;
	private int repayOriginAmt;
	private BigDecimal repayInterestAmt;
	private String redeemDt;
	private int redeemOriginAmt;//提前赎回时的本金
	private BigDecimal redeemRtnIntAmt;//提前赎回时返还的利息
	private String createId;
	private String createDts;
	//待赎回
	private String nextDts;
	private String days;
	private BigDecimal redeemTotalAmount;
	private BigDecimal itemTotalAmount;
	
	//
	private String empId;
	private String realName;
	private String itemNm;
	private int period;
	private int originDts;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getRepayId() {
		return repayId;
	}
	public void setRepayId(int repayId) {
		this.repayId = repayId;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getRepayStatus() {
		return repayStatus;
	}
	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}
	public String getRepayDt() {
		return repayDt;
	}
	public void setRepayDt(String repayDt) {
		this.repayDt = repayDt;
	}
	public int getRepayOriginAmt() {
		return repayOriginAmt;
	}
	public void setRepayOriginAmt(int repayOriginAmt) {
		this.repayOriginAmt = repayOriginAmt;
	}
	public BigDecimal getRepayInterestAmt() {
		return repayInterestAmt;
	}
	public void setRepayInterestAmt(BigDecimal repayInterestAmt) {
		this.repayInterestAmt = repayInterestAmt;
	}
	public String getRedeemDt() {
		return redeemDt;
	}
	public void setRedeemDt(String redeemDt) {
		this.redeemDt = redeemDt;
	}
	public int getRedeemOriginAmt() {
		return redeemOriginAmt;
	}
	public void setRedeemOriginAmt(int redeemOriginAmt) {
		this.redeemOriginAmt = redeemOriginAmt;
	}
	public BigDecimal getRedeemRtnIntAmt() {
		return redeemRtnIntAmt;
	}
	public void setRedeemRtnIntAmt(BigDecimal redeemRtnIntAmt) {
		this.redeemRtnIntAmt = redeemRtnIntAmt;
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
	public String getNextDts() {
		return nextDts;
	}
	public void setNextDts(String nextDts) {
		this.nextDts = nextDts;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	 
	public BigDecimal getRedeemTotalAmount() {
		return redeemTotalAmount;
	}
	public void setRedeemTotalAmount(BigDecimal redeemTotalAmount) {
		this.redeemTotalAmount = redeemTotalAmount;
	}
	public BigDecimal getItemTotalAmount() {
		return itemTotalAmount;
	}
	public void setItemTotalAmount(BigDecimal itemTotalAmount) {
		this.itemTotalAmount = itemTotalAmount;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	 
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getOriginDts() {
		return originDts;
	}
	public void setOriginDts(int originDts) {
		this.originDts = originDts;
	}
	
}
