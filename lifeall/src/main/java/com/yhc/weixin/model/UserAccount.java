package com.yhc.weixin.model;

import java.math.BigDecimal;

public class UserAccount {
	private String userId;
	private String accountId;
	private int channelId;
	private String channelNm;
	private String channelUserId;
	private String channelUserNm;
	private String delYn;
	
	private BigDecimal avlAmt;
	private BigDecimal freezeAmt;
	private BigDecimal finalAmt;
	private BigDecimal slbAvlAmt;//生利宝余额
	private BigDecimal slbProfitAmt;//生利宝总收益
	
	private BigDecimal creditStartAmt;
	
	private BigDecimal creditDyhStartAmt;
	
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	
	private String userNm;

	
	private BigDecimal dailyIncome;
	private BigDecimal invest;
	private BigDecimal debt;
	private BigDecimal netAsset;
	private BigDecimal remainAmt;
	private BigDecimal earnAmt;
	private BigDecimal unFinishedEarnAmt;
	private BigDecimal totalLoanAmt;
	
	private int creditCount;
	
	private String dailyIncomeHint;
	private int accountSecureLvl = 1;
	
	private BigDecimal inputAmtSum;  //已充值总额
	
	private BigDecimal outputAmtSum; //已提现总额
	
	private String syncDts;
	private int tradeCnt;
	private int slbTradeCnt;//生利宝交易次数
	private String slbSyncDts;
	
	private String mobileNo;
	
	private String wechatId;
	
	private BigDecimal loanRemainAmt;
	
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelNm() {
		return channelNm;
	}
	public void setChannelNm(String channelNm) {
		this.channelNm = channelNm;
	}
	public String getChannelUserId() {
		return channelUserId;
	}
	public void setChannelUserId(String channelUserId) {
		this.channelUserId = channelUserId;
	}
	public String getChannelUserNm() {
		return channelUserNm;
	}
	public void setChannelUserNm(String channelUserNm) {
		this.channelUserNm = channelUserNm;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public BigDecimal getAvlAmt() {
		return avlAmt;
	}
	public void setAvlAmt(BigDecimal avlAmt) {
		this.avlAmt = avlAmt;
	}
	public BigDecimal getFreezeAmt() {
		return freezeAmt;
	}
	public void setFreezeAmt(BigDecimal freezeAmt) {
		this.freezeAmt = freezeAmt;
	}
	public BigDecimal getFinalAmt() {
		return finalAmt;
	}
	public void setFinalAmt(BigDecimal finalAmt) {
		this.finalAmt = finalAmt;
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
	public BigDecimal getSlbAvlAmt() {
		return slbAvlAmt;
	}
	public void setSlbAvlAmt(BigDecimal slbAvlAmt) {
		this.slbAvlAmt = slbAvlAmt;
	}
	public BigDecimal getSlbProfitAmt() {
		return slbProfitAmt;
	}
	public void setSlbProfitAmt(BigDecimal slbProfitAmt) {
		this.slbProfitAmt = slbProfitAmt;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public BigDecimal getCreditStartAmt() {
		creditStartAmt = new BigDecimal(100);
		return creditStartAmt;
	}
	public void setCreditStartAmt(BigDecimal creditStartAmt) {
		this.creditStartAmt = creditStartAmt;
	}

	public BigDecimal getCreditDyhStartAmt() {
		creditDyhStartAmt = new BigDecimal(1000);
		return creditDyhStartAmt;
	}
	public void setCreditDyhStartAmt(BigDecimal creditDyhStartAmt) {
		this.creditDyhStartAmt = creditDyhStartAmt;
	}
	public BigDecimal getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(BigDecimal dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	public BigDecimal getInvest() {
		return invest;
	}
	public void setInvest(BigDecimal invest) {
		this.invest = invest;
	}
	public BigDecimal getDebt() {
		return debt;
	}
	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}
	public BigDecimal getNetAsset() {
		//		netAsset = invest - debt + finalAmt + svlAvlAmt;
		netAsset = loanRemainAmt.subtract(debt).add(finalAmt).add(slbAvlAmt);///增加生利宝账户后的账户净资产
		//      netAsset = invest - debt + finalAmt;//增加生利宝交易之前计算公式
//		netAsset = invest.subtract(debt).add(finalAmt);//增加生利宝交易之前账户净资产
		return netAsset;
	}
	public void setNetAsset(BigDecimal netAsset) {
		this.netAsset = netAsset;
	}
	public BigDecimal getRemainAmt() {
		return remainAmt;
	}
	public void setRemainAmt(BigDecimal remainAmt) {
		this.remainAmt = remainAmt;
	}
	public BigDecimal getEarnAmt() {
		return earnAmt;
	}
	public void setEarnAmt(BigDecimal earnAmt) {
		this.earnAmt = earnAmt;
	}
	public BigDecimal getUnFinishedEarnAmt() {
		return unFinishedEarnAmt;
	}
	public void setUnFinishedEarnAmt(BigDecimal unFinishedEarnAmt) {
		this.unFinishedEarnAmt = unFinishedEarnAmt;
	}
	public BigDecimal getTotalLoanAmt() {
		return totalLoanAmt;
	}
	public void setTotalLoanAmt(BigDecimal totalLoanAmt) {
		this.totalLoanAmt = totalLoanAmt;
	}
	public int getCreditCount() {
		return creditCount;
	}
	public void setCreditCount(int creditCount) {
		this.creditCount = creditCount;
	}
	public String getDailyIncomeHint() {
		return dailyIncomeHint;
	}
	public void setDailyIncomeHint(String dailyIncomeHint) {
		this.dailyIncomeHint = dailyIncomeHint;
	}
	public int getAccountSecureLvl() {
		return accountSecureLvl;
	}
	public void setAccountSecureLvl(int accountSecureLvl) {
		this.accountSecureLvl = accountSecureLvl;
	}
	public BigDecimal getInputAmtSum() {
		return inputAmtSum;
	}
	public void setInputAmtSum(BigDecimal inputAmtSum) {
		this.inputAmtSum = inputAmtSum;
	}
	public BigDecimal getOutputAmtSum() {
		return outputAmtSum;
	}
	public void setOutputAmtSum(BigDecimal outputAmtSum) {
		this.outputAmtSum = outputAmtSum;
	}
	public String getSyncDts() {
		return syncDts;
	}
	public void setSyncDts(String syncDts) {
		this.syncDts = syncDts;
	}
	public int getTradeCnt() {
		return tradeCnt;
	}
	public void setTradeCnt(int tradeCnt) {
		this.tradeCnt = tradeCnt;
	}
	public int getSlbTradeCnt() {
		return slbTradeCnt;
	}
	public void setSlbTradeCnt(int slbTradeCnt) {
		this.slbTradeCnt = slbTradeCnt;
	}
	public String getSlbSyncDts() {
		return slbSyncDts;
	}
	public void setSlbSyncDts(String slbSyncDts) {
		this.slbSyncDts = slbSyncDts;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public BigDecimal getLoanRemainAmt() {
		return loanRemainAmt;
	}
	public void setLoanRemainAmt(BigDecimal loanRemainAmt) {
		this.loanRemainAmt = loanRemainAmt;
	}
	

}
