package com.yhc.weixin.model;

import java.math.BigDecimal;

public class Personal extends BaseResult {
	
	/**每日收益*/
	private String dayIncome;
	/**历史总收益*/
	private String historyIncome;
	/**账户等级*/
	private String level;
	/**积分*/
	private String totalPoint;
	/**待投资*/
	private String toBeInvest;
	/**已投资*/
	private String invested;
	/**负债*/
	private String debt;
	/**生利宝余额*/
	private String slbAmt;
	/**余额*/
	private String totalAssets;
	
	public String getDayIncome() {
		return dayIncome;
	}
	public void setDayIncome(String dayIncome) {
		this.dayIncome = dayIncome;
	}
	public String getHistoryIncome() {
		return historyIncome;
	}
	public void setHistoryIncome(String historyIncome) {
		this.historyIncome = historyIncome;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}
	public String getToBeInvest() {
		return toBeInvest;
	}
	public void setToBeInvest(String toBeInvest) {
		this.toBeInvest = toBeInvest;
	}
	public String getInvested() {
		return invested;
	}
	public void setInvested(String invested) {
		this.invested = invested;
	}
	public String getDebt() {
		return debt;
	}
	public void setDebt(String debt) {
		this.debt = debt;
	}
	public String getSlbAmt() {
		return slbAmt;
	}
	public void setSlbAmt(String slbAmt) {
		this.slbAmt = slbAmt;
	}
	public String getTotalAssets() {
		if(invested==null || debt==null||toBeInvest==null||slbAmt==null){
			return totalAssets;
		}
		totalAssets = new BigDecimal(invested).subtract(new BigDecimal(debt)).add(new BigDecimal(toBeInvest)).add(new BigDecimal(slbAmt)).toString();
		return totalAssets;
	}
	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}
	
}
