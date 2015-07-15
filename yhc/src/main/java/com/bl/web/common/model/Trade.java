package com.bl.web.common.model;

import java.math.BigDecimal;

public class Trade {
	private String tradeId;
	private String tradeType;
	private String accountId;
	private BigDecimal inputAmt;
	private BigDecimal outputAmt;
	private String channelTradeId;
	private String loanId;
	private String creditId;
	private String repayId;
	private String tradeCommentCd;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	private String tradeTypeNm;
	private String tradeCommentNm;
	private BigDecimal redEnvelopeAmt = new BigDecimal(0);//投资标的时所使用的红包金额,需要在交易记录中提示
	private String useEnvelopeYn;//投资标的时使用红包与否
	private String excleShowOutputAmt;
	private String tradeStauts;				//交易状态
	private String dyhId;
    private String repayDt;//赎回日期
    private int period;//投资周期
    
	public String getDyhId() {
		return dyhId;
	}

	public void setDyhId(String dyhId) {
		this.dyhId = dyhId;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getInputAmt() {
		return inputAmt;
	}

	public void setInputAmt(BigDecimal inputAmt) {
		this.inputAmt = inputAmt;
	}

	public BigDecimal getOutputAmt() {
		return outputAmt;
	}

	public void setOutputAmt(BigDecimal outputAmt) {
		this.outputAmt = outputAmt;
	}

	public String getChannelTradeId() {
		return channelTradeId;
	}

	public void setChannelTradeId(String channelTradeId) {
		this.channelTradeId = channelTradeId;
	}

	public String getTradeCommentCd() {
		return tradeCommentCd;
	}

	public void setTradeCommentCd(String tradeCommentCd) {
		this.tradeCommentCd = tradeCommentCd;
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

	public String getTradeTypeNm() {
	    return tradeTypeNm;
	}

	public void setTradeTypeNm(String tradeTypeNm) {
	    this.tradeTypeNm = tradeTypeNm;
	}

	public String getTradeCommentNm() {
	    return tradeCommentNm;
	}

	public void setTradeCommentNm(String tradeCommentNm) {
	    this.tradeCommentNm = tradeCommentNm;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getRepayId() {
		return repayId;
	}

	public void setRepayId(String repayId) {
		this.repayId = repayId;
	}

	public BigDecimal getRedEnvelopeAmt() {
		return redEnvelopeAmt;
	}

	public void setRedEnvelopeAmt(BigDecimal redEnvelopeAmt) {
		this.redEnvelopeAmt = redEnvelopeAmt;
	}

	public String getUseEnvelopeYn() {
		return useEnvelopeYn;
	}

	public void setUseEnvelopeYn(String useEnvelopeYn) {
		this.useEnvelopeYn = useEnvelopeYn;
	}

	public String getExcleShowOutputAmt() {
		
		if (redEnvelopeAmt !=null && (redEnvelopeAmt.compareTo(new BigDecimal(0))) == 1) {
			excleShowOutputAmt = outputAmt + "+红包" + redEnvelopeAmt;
		} else {
			excleShowOutputAmt = outputAmt + "";
		} 
		return excleShowOutputAmt;
	}

	public void setExcleShowOutputAmt(String excleShowOutputAmt) {
		this.excleShowOutputAmt = excleShowOutputAmt;
	}

	public String getTradeStauts() {
		return tradeStauts;
	}

	public void setTradeStauts(String tradeStauts) {
		if ("SUCCESS".equals(tradeStauts)) {
			tradeStauts = "TRADESTATUS01";
		} else if ("WAITING".equals(tradeStauts)) {
			tradeStauts = "TRADESTATUS02";
		} else if ("FAILURE".equals(tradeStauts)) {
			tradeStauts = "TRADESTATUS03";
		} else if ("CANCEL".equals(tradeStauts)) {
			tradeStauts = "TRADESTATUS04";
		}
		this.tradeStauts = tradeStauts;
	}

	public String getRepayDt() {
		return repayDt;
	}

	public void setRepayDt(String repayDt) {
		this.repayDt = repayDt;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}
	
	

}
