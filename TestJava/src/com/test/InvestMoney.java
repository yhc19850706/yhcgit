package com.test;

public class InvestMoney {
	private String creditId;
	private String period;
	private String originAmt;
	private String incomeAmt;//原收益
	private String lossIncomeAmt;//提前赎回损失的收益
	private String minIncomeAmt;//提前赎回的最小收益
	private String maxIncomeAmt;//提前赎回的最大收益
	private String buyDate;
	//private String investDays;//已投资天数
	private String surplusDays;//剩余日期
	private String redeemDes;//提前赎回
	
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getOriginAmt() {
		return originAmt;
	}
	public void setOriginAmt(String originAmt) {
		this.originAmt = originAmt;
	}
	public String getIncomeAmt() {
		return incomeAmt;
	}
	public void setIncomeAmt(String incomeAmt) {
		this.incomeAmt = incomeAmt;
	}
	public String getLossIncomeAmt() {
		return lossIncomeAmt;
	}
	public void setLossIncomeAmt(String lossIncomeAmt) {
		this.lossIncomeAmt = lossIncomeAmt;
	}
	public String getMinIncomeAmt() {
		return minIncomeAmt;
	}
	public void setMinIncomeAmt(String minIncomeAmt) {
		this.minIncomeAmt = minIncomeAmt;
	}
	public String getMaxIncomeAmt() {
		return maxIncomeAmt;
	}
	public void setMaxIncomeAmt(String maxIncomeAmt) {
		this.maxIncomeAmt = maxIncomeAmt;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getSurplusDays() {
		return surplusDays;
	}
	public void setSurplusDays(String surplusDays) {
		this.surplusDays = surplusDays;
	}
	public String getRedeemDes() {
		return redeemDes;
	}
	public void setRedeemDes(String redeemDes) {
		this.redeemDes = redeemDes;
	}

}
