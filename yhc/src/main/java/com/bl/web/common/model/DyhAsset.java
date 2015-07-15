package com.bl.web.common.model;

public class DyhAsset {
	private int dyhCreditId;
	private int dyhId;
	private String loanId;
	private String rxtCreditId;
	private int rxtPackedAmt;
	private int creditPackedAmt;
	private int creditAvlAmt;
	private int redeemAmt;
	private String delYn;
	private String dyhCreditOrgContractNo;//原债权借款协议编号
	private String orgBorrowerNm;//原债权借款人
	
	public int getDyhCreditId() {
		return dyhCreditId;
	}
	public void setDyhCreditId(int dyhCreditId) {
		this.dyhCreditId = dyhCreditId;
	}
	public int getDyhId() {
		return dyhId;
	}
	public void setDyhId(int dyhId) {
		this.dyhId = dyhId;
	}
	public String getRxtCreditId() {
		return rxtCreditId;
	}
	public void setRxtCreditId(String rxtCreditId) {
		this.rxtCreditId = rxtCreditId;
	}
	public int getCreditPackedAmt() {
		return creditPackedAmt;
	}
	public void setCreditPackedAmt(int creditPackedAmt) {
		this.creditPackedAmt = creditPackedAmt;
	}
	public int getCreditAvlAmt() {
		return creditAvlAmt;
	}
	public void setCreditAvlAmt(int creditAvlAmt) {
		this.creditAvlAmt = creditAvlAmt;
	}
	public int getRedeemAmt() {
		return redeemAmt;
	}
	public void setRedeemAmt(int redeemAmt) {
		this.redeemAmt = redeemAmt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getDyhCreditOrgContractNo() {
		return dyhCreditOrgContractNo;
	}
	public void setDyhCreditOrgContractNo(String dyhCreditOrgContractNo) {
		this.dyhCreditOrgContractNo = dyhCreditOrgContractNo;
	}
	public String getOrgBorrowerNm() {
		return orgBorrowerNm;
	}
	public void setOrgBorrowerNm(String orgBorrowerNm) {
		this.orgBorrowerNm = orgBorrowerNm;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public int getRxtPackedAmt() {
		return rxtPackedAmt;
	}
	public void setRxtPackedAmt(int rxtPackedAmt) {
		this.rxtPackedAmt = rxtPackedAmt;
	}

}
