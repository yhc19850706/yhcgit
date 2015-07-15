package com.bl.web.common.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DyhCredit {

	private String creditId;
	private int dyhId;
	private String userId;
	private int originAmt;
	private BigDecimal investRate;
	private String creditStatus;
	private String freezeTrxId;
	private String lendOrderId;
	private int dyhPeriod;
	private int redEnvelopAmt;
	private String delYn;
	private String inviteEmpId;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	
	private String channelUserId;
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public int getDyhId() {
		return dyhId;
	}
	public void setDyhId(int dyhId) {
		this.dyhId = dyhId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOriginAmt() {
		return originAmt;
	}
	public void setOriginAmt(int originAmt) {
		this.originAmt = originAmt;
	}
	public BigDecimal getInvestRate() {
		return investRate;
	}
	public void setInvestRate(BigDecimal investRate) {
		this.investRate = investRate;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getFreezeTrxId() {
		return freezeTrxId;
	}
	public void setFreezeTrxId(String freezeTrxId) {
		this.freezeTrxId = freezeTrxId;
	}
	public String getLendOrderId() {
		return lendOrderId;
	}
	public void setLendOrderId(String lendOrderId) {
		this.lendOrderId = lendOrderId;
	}
	public int getRedEnvelopAmt() {
		return redEnvelopAmt;
	}
	public void setRedEnvelopAmt(int redEnvelopAmt) {
		this.redEnvelopAmt = redEnvelopAmt;
	}
	public String getInviteEmpId() {
		return inviteEmpId;
	}
	public void setInviteEmpId(String inviteEmpId) {
		this.inviteEmpId = inviteEmpId;
	}
	public int getDyhPeriod() {
		return dyhPeriod;
	}
	public void setDyhPeriod(int dyhPeriod) {
		this.dyhPeriod = dyhPeriod;
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
	public String getUpdateDts() {
		return updateDts;
	}
	public void setUpdateDts(String updateDts) {
		this.updateDts = updateDts;
	}
	public String getChannelUserId() {
		return channelUserId;
	}
	public void setChannelUserId(String channelUserId) {
		this.channelUserId = channelUserId;
	}
}
