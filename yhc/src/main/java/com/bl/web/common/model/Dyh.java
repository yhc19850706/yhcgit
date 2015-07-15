package com.bl.web.common.model;

import java.math.BigDecimal;

public class Dyh {

	private int dyhId;
	private String dyhNm;
	private long dyhAmt;
	private String moneyColStartDts;
	private String moneyColEndDts;
	private int dyhPeriod;
	private BigDecimal dyhMinRate;
	private BigDecimal dyhMaxRate;
	private String onlineYn;
	private String delYn;
	private String dyhStatus;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	private int packageNum;
	private BigDecimal packageTotalAmount;
	private long collectedAmt;
	public int getDyhId() {
		return dyhId;
	}
	public void setDyhId(int dyhId) {
		this.dyhId = dyhId;
	}
	public String getDyhNm() {
		return dyhNm;
	}
	public void setDyhNm(String dyhNm) {
		this.dyhNm = dyhNm;
	}
	public long getDyhAmt() {
		return dyhAmt;
	}
	public void setDyhAmt(long dyhAmt) {
		this.dyhAmt = dyhAmt;
	}
	public String getMoneyColStartDts() {
		return moneyColStartDts;
	}
	public void setMoneyColStartDts(String moneyColStartDts) {
		this.moneyColStartDts = moneyColStartDts;
	}
	public String getMoneyColEndDts() {
		return moneyColEndDts;
	}
	public void setMoneyColEndDts(String moneyColEndDts) {
		this.moneyColEndDts = moneyColEndDts;
	}
	public int getDyhPeriod() {
		return dyhPeriod;
	}
	public void setDyhPeriod(int dyhPeriod) {
		this.dyhPeriod = dyhPeriod;
	}
	public BigDecimal getDyhMinRate() {
		return dyhMinRate;
	}
	public void setDyhMinRate(BigDecimal dyhMinRate) {
		this.dyhMinRate = dyhMinRate;
	}
	public BigDecimal getDyhMaxRate() {
		return dyhMaxRate;
	}
	public void setDyhMaxRate(BigDecimal dyhMaxRate) {
		this.dyhMaxRate = dyhMaxRate;
	}
	public String getOnlineYn() {
		return onlineYn;
	}
	public void setOnlineYn(String onlineYn) {
		this.onlineYn = onlineYn;
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
	public String getDyhStatus() {
		return dyhStatus;
	}
	public void setDyhStatus(String dyhStatus) {
		this.dyhStatus = dyhStatus;
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
	public String getUpdateDts() {
		return updateDts;
	}
	public void setUpdateDts(String updateDts) {
		this.updateDts = updateDts;
	}
	public int getPackageNum() {
		return packageNum;
	}
	public void setPackageNum(int packageNum) {
		this.packageNum = packageNum;
	}
	public BigDecimal getPackageTotalAmount() {
		return packageTotalAmount;
	}
	public void setPackageTotalAmount(BigDecimal packageTotalAmount) {
		this.packageTotalAmount = packageTotalAmount;
	}
	public long getCollectedAmt() {
		return collectedAmt;
	}
	public void setCollectedAmt(long collectedAmt) {
		this.collectedAmt = collectedAmt;
	}
}
