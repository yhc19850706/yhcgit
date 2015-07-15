package com.bl.web.common.model;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class UserAccount extends User {
	private String accountId;
	private int channelId;
	private String channelNm;
	private String channelUserId;
	private String channelUserNm;
	private BigDecimal avlAmt;
	private BigDecimal freezeAmt;
	private BigDecimal finalAmt;
	private BigDecimal slbAvlAmt;//生利宝余额
	private BigDecimal slbProfitAmt;//生利宝总收益
	private BigDecimal slbInputAmtSum;//生利宝已转入总额
	private BigDecimal slbOutputAmtSum;//生利宝已转出总额
	private String delYn;

	private BigDecimal dailyIncome;
	private BigDecimal invest;
	private BigDecimal debt;
	private BigDecimal netAsset;
	private BigDecimal remainAmt;
	private BigDecimal earnAmt;
	private BigDecimal unFinishedEarnAmt;
	private BigDecimal totalLoanAmt;
	
	private int creditCount;
	
	private int creditStartAmt;

	private String dailyIncomeHint;
	private int accountSecureLvl = 1;
	
	private BigDecimal inputAmtSum;  //已充值总额
	
	private BigDecimal outputAmtSum; //已提现总额
	
	private String syncDts;
	private int tradeCnt;
	private int slbTradeCnt;//生利宝交易次数
	private String slbSyncDts;
	
	private String nextRepayDt; //下一个还款日期
	private BigDecimal nextRepayAmt;//下一个还款金额
	
	private BigDecimal repayInvest; //待收本金
	private BigDecimal repayInterest; //待收收益
	
	private String signYn;
	
	private int redTotal;
	
	private String tradeCreateDts;//记录账户同步时，判断用的最新生成的交易记录的生成时间
	
	private BigDecimal investingAmt;
	
	private BigDecimal yestdayIncome;
	
	private BigDecimal accuAmt;
	
	private String recentTradeDts;
	
	private int creditDyhStartAmt;
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
	
	public String getSignYn() {
		return signYn;
	}

	public void setSignYn(String signYn) {
		this.signYn = signYn;
	}

	public BigDecimal getNetAsset() {
		//		netAsset = invest - debt + finalAmt + svlAvlAmt;
		netAsset = invest.subtract(debt).add(finalAmt).add(slbAvlAmt);//增加生利宝账户后的账户净资产
		//      netAsset = invest - debt + finalAmt;//增加生利宝交易之前计算公式
//		netAsset = invest.subtract(debt).add(finalAmt);//增加生利宝交易之前账户净资产
		return netAsset;
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

	public String getDailyIncomeHint() {
		if (dailyIncome.compareTo(BigDecimal.valueOf(0)) == 1 && dailyIncome.compareTo(BigDecimal.valueOf(1)) <= 0) {
			dailyIncomeHint = "收益只够磕几个瓜子啊， 赶紧多抢一些标的吧！";
		} else if (dailyIncome.compareTo(BigDecimal.valueOf(1)) == 1
			&& dailyIncome.compareTo(BigDecimal.valueOf(5)) <= 0) {
			dailyIncomeHint = "收益能买几个茶叶蛋了，分享到朋友圈炫下富？";
		} else if (dailyIncome.compareTo(BigDecimal.valueOf(5)) == 1
			&& dailyIncome.compareTo(BigDecimal.valueOf(15)) <= 0) {
			dailyIncomeHint = "收益足够吃一顿营养早餐了，每天按时吃早饭哦！";
		} else if (dailyIncome.compareTo(BigDecimal.valueOf(15)) == 1
			&& dailyIncome.compareTo(BigDecimal.valueOf(50)) <= 0) {
			dailyIncomeHint = "午饭不愁了，中午好好犒劳下自己吧！";
		} else if (dailyIncome.compareTo(BigDecimal.valueOf(50)) == 1
			&& dailyIncome.compareTo(BigDecimal.valueOf(100)) <= 0) {
			dailyIncomeHint = "按照这个速度，今年的利息就够换一部手机了！";
		} else if (dailyIncome.compareTo(BigDecimal.valueOf(100)) == 1) {
			dailyIncomeHint = "每天利息都这么高，土豪，我们交个朋友好不？";
		} else {
			dailyIncomeHint = "您还没有收益，赶快来投资吧！";
		}
		return dailyIncomeHint;
	}

	public int getAccountSecureLvl() {
		if (StringUtils.isNotEmpty(super.getUserIdcardNo())) {
			accountSecureLvl += 1;
		}
		if (StringUtils.isNotEmpty(super.getEmail())) {
			accountSecureLvl += 1;
		}
		if (StringUtils.isNotEmpty(channelUserId)) {
			accountSecureLvl += 1;
		}
		return accountSecureLvl;
	}

	public int getCreditCount() {
		return creditCount;
	}

	public void setCreditCount(int creditCount) {
//		if(creditCount>0) {
//			this.setCreditStartAmt(1000);
//		} else {
//			this.setCreditStartAmt(100);
//		}
		this.creditCount = creditCount;
	}

	public int getCreditStartAmt() {
		creditStartAmt = 100;
		return creditStartAmt;
	}

	public void setCreditStartAmt(int creditStartAmt) {
		this.creditStartAmt = creditStartAmt;
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

	public BigDecimal getSlbInputAmtSum() {
		return slbInputAmtSum;
	}

	public void setSlbInputAmtSum(BigDecimal slbInputAmtSum) {
		this.slbInputAmtSum = slbInputAmtSum;
	}

	public BigDecimal getSlbOutputAmtSum() {
		return slbOutputAmtSum;
	}

	public void setSlbOutputAmtSum(BigDecimal slbOutputAmtSum) {
		this.slbOutputAmtSum = slbOutputAmtSum;
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

	public String getNextRepayDt() {
		return nextRepayDt;
	}

	public void setNextRepayDt(String nextRepayDt) {
		this.nextRepayDt = nextRepayDt;
	}

	public BigDecimal getNextRepayAmt() {
		return nextRepayAmt;
	}

	public void setNextRepayAmt(BigDecimal nextRepayAmt) {
		this.nextRepayAmt = nextRepayAmt;
	}

	public BigDecimal getRepayInvest() {
		return repayInvest;
	}

	public void setRepayInvest(BigDecimal repayInvest) {
		this.repayInvest = repayInvest;
	}

	public BigDecimal getRepayInterest() {
		return repayInterest;
	}

	public void setRepayInterest(BigDecimal repayInterest) {
		this.repayInterest = repayInterest;
	}

	public int getRedTotal() {
		return redTotal;
	}

	public void setRedTotal(int redTotal) {
		this.redTotal = redTotal;
	}

	public String getTradeCreateDts() {
		return tradeCreateDts;
	}

	public void setTradeCreateDts(String tradeCreateDts) {
		this.tradeCreateDts = tradeCreateDts;
	}

	public BigDecimal getInvestingAmt() {
		return investingAmt;
	}

	public void setInvestingAmt(BigDecimal investingAmt) {
		this.investingAmt = investingAmt;
	}

	public BigDecimal getAccuAmt() {
		return accuAmt;
	}

	public void setAccuAmt(BigDecimal accuAmt) {
		this.accuAmt = accuAmt;
	}

	public String getRecentTradeDts() {
		return recentTradeDts;
	}

	public void setRecentTradeDts(String recentTradeDts) {
		this.recentTradeDts = recentTradeDts;
	}

	public BigDecimal getYestdayIncome() {
		return yestdayIncome;
	}

	public void setYestdayIncome(BigDecimal yestdayIncome) {
		this.yestdayIncome = yestdayIncome;
	}
	public int getCreditDyhStartAmt() {
		creditDyhStartAmt = 1000;
		return creditDyhStartAmt;
	}
}
