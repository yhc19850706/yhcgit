package com.bl.web.common.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;
import com.bl.web.common.utils.DateUtil;


public class DyhContractInfo {
	private String repayDay;
	private String repayEndDt;
	private String repayStartDt;
	private int apprPeriod;
	private BigDecimal monthRepayAmt;
	private BigDecimal apprAmt;
	private String loanPurpose;
	private String loanPurposeStr;
	private String userNm;
	private String userIdcardNo;
	private String userRealNm;
	private String createDts;
	private BigDecimal loanRate;
	private BigDecimal retConsultFeeRate;
	private BigDecimal retConsultFee;
	private List<String> apprAmtSplitStrList;
	private List<String> monthRepayAmtSplitStrList;
	private String sellerId;  //销售人员
	
	private String apprLvl; //信用等级
	
	private BigDecimal loanMngFeeRate; //0.30
	
	private BigDecimal svcFeeRate;  

	private BigDecimal totalFee;
	
	private String repayMode; //还款方式
	
	private String repayModeStr;
	
	private String contractNo;
	
	private String lendDts;  //借款日期
	
	private String dyhOrgHolderRealNm;//定月号合同转让方
	
	private String dyhOrgHolderIdcardNo;//定月号合同转让方证件号
	
	private int dyhId;//定月号 ID
	
	private int dyhAmt;//定月号总金额
	
	private int originAmt;//购买定月号债权金额
	
	private String dyhStatus;//定月号状态
	
	private BigDecimal investRate;//购买时的定月号年化率
	
	private String creditStatus;//购买定月号的债权状态
	
	private int repayOriginAmt;//购买的定月号债权，还款本金
	
	private int repayInterestAmt;//购买的定月号债权，还款利息
	
	private int repayBenxi;//购买定月号，到期本息总和
	
	private String repayDt;//定月号到期还款时间
	
	private String signDate;//购买定月号债权时间
	
	private String signDateStr;//购买定月号债权时间	显示2015年01月25日
	
	private String repayDtStr;//定月号到期还款时间	显示2015年01月25日
	private int signature;
	private String signatureStr;
	public String getLendDts() {
		return lendDts;
	}
	public void setLendDts(String lendDts) {
		this.lendDts = lendDts;
	}
	public String getRepayModeStr() {
		return repayModeStr;
	}
	public void setRepayModeStr(String repayModeStr) {
		this.repayModeStr = repayModeStr;
	}
	public String getRepayMode() {
		return repayMode;
	}
	public void setRepayMode(String repayMode) {
		this.repayMode = repayMode;
	}
	public BigDecimal getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}
	
	public String getApprLvl() {
		return apprLvl;
	}
	public void setApprLvl(String apprLvl) {
		this.apprLvl = apprLvl;
	}
	public BigDecimal getLoanMngFeeRate() {
		return loanMngFeeRate;
	}
	public void setLoanMngFeeRate(BigDecimal loanMngFeeRate) {
		this.loanMngFeeRate = loanMngFeeRate;
	}
	
	public BigDecimal getSvcFeeRate() {
		return svcFeeRate;
	}
	public void setSvcFeeRate(BigDecimal svcFeeRate) {
		this.svcFeeRate = svcFeeRate;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public BigDecimal getRetConsultFeeRate() {
		return retConsultFeeRate;
	}
	public void setRetConsultFeeRate(BigDecimal retConsultFeeRate) {
		this.retConsultFeeRate = retConsultFeeRate;
	}
	public BigDecimal getRetConsultFee() {
		return retConsultFee;
	}
	public void setRetConsultFee(BigDecimal retConsultFee) {
		this.retConsultFee = retConsultFee;
	}
	public void setLoanPurposeStr(String loanPurposeStr) {
		this.loanPurposeStr = loanPurposeStr;
	}
	public BigDecimal getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}
	public String getLoanPurposeStr() {
		loanPurposeStr = "";
		if (StringUtils.isNotEmpty(loanPurpose) && StringUtils.isNotEmpty(ContextUtil.getCommonCodeMap().get(loanPurpose))) {
			loanPurposeStr = ContextUtil.getCommonCodeMap().get(loanPurpose);
		}
		return loanPurposeStr;
	}
	public String getRepayDay() {
		return repayDay;
	}
	public void setRepayDay(String repayDay) {
		this.repayDay = repayDay;
	}
	public String getRepayEndDt() {
		return repayEndDt;
	}
	public void setRepayEndDt(String repayEndDt) {
		this.repayEndDt = repayEndDt;
	}
	public String getRepayStartDt() {
		return repayStartDt;
	}
	public void setRepayStartDt(String repayStartDt) {
		this.repayStartDt = repayStartDt;
	}
	public int getApprPeriod() {
		return apprPeriod;
	}
	public void setApprPeriod(int apprPeriod) {
		this.apprPeriod = apprPeriod;
	}
	public BigDecimal getMonthRepayAmt() {
		return monthRepayAmt;
	}
	public void setMonthRepayAmt(BigDecimal monthRepayAmt) {
		this.monthRepayAmt = monthRepayAmt;
	}
	public BigDecimal getApprAmt() {
		return apprAmt;
	}
	public void setApprAmt(BigDecimal apprAmt) {
		this.apprAmt = apprAmt;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserIdcardNo() {
		return userIdcardNo;
	}
	public void setUserIdcardNo(String userIdcardNo) {
		this.userIdcardNo = userIdcardNo;
	}
	public String getUserRealNm() {
		return userRealNm;
	}
	public void setUserRealNm(String userRealNm) {
		this.userRealNm = userRealNm;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	public List<String> getApprAmtSplitStrList() {
		return apprAmtSplitStrList;
	}
	public void setApprAmtSplitStrList(List<String> apprAmtSplitStrList) {
		this.apprAmtSplitStrList = apprAmtSplitStrList;
	}
	public List<String> getMonthRepayAmtSplitStrList() {
		return monthRepayAmtSplitStrList;
	}
	public void setMonthRepayAmtSplitStrList(List<String> monthRepayAmtSplitStrList) {
		this.monthRepayAmtSplitStrList = monthRepayAmtSplitStrList;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getDyhOrgHolderRealNm() {
		return dyhOrgHolderRealNm;
	}
	public void setDyhOrgHolderRealNm(String dyhOrgHolderRealNm) {
		this.dyhOrgHolderRealNm = dyhOrgHolderRealNm;
	}
	public String getDyhOrgHolderIdcardNo() {
		return dyhOrgHolderIdcardNo;
	}
	public void setDyhOrgHolderIdcardNo(String dyhOrgHolderIdcardNo) {
		this.dyhOrgHolderIdcardNo = dyhOrgHolderIdcardNo;
	}
	public int getDyhId() {
		return dyhId;
	}
	public void setDyhId(int dyhId) {
		this.dyhId = dyhId;
	}
	public int getDyhAmt() {
		return dyhAmt;
	}
	public void setDyhAmt(int dyhAmt) {
		this.dyhAmt = dyhAmt;
	}
	public int getOriginAmt() {
		return originAmt;
	}
	public void setOriginAmt(int originAmt) {
		this.originAmt = originAmt;
	}
	public String getDyhStatus() {
		return dyhStatus;
	}
	public void setDyhStatus(String dyhStatus) {
		this.dyhStatus = dyhStatus;
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
	public int getRepayOriginAmt() {
		return repayOriginAmt;
	}
	public void setRepayOriginAmt(int repayOriginAmt) {
		this.repayOriginAmt = repayOriginAmt;
	}
	public int getRepayInterestAmt() {
		return repayInterestAmt;
	}
	public void setRepayInterestAmt(int repayInterestAmt) {
		this.repayInterestAmt = repayInterestAmt;
	}
	public String getRepayDt() {
		return repayDt;
	}
	public void setRepayDt(String repayDt) {
		this.repayDt = repayDt;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSignDateStr() {
		signDateStr = null;
		if (signDate != null) {
			signDateStr = DateUtil.getChineseFormatDate(signDate);
		} 
		return signDateStr;
		 
	}
	
	public String getRepayDtStr() {
		repayDtStr = null;
		if (repayDt != null) {
			repayDtStr = DateUtil.getChineseFormatDate(repayDt);
		}
		return repayDtStr;
	}
	
	
	public int getSignature() {
		return signature;
	}
	public void setSignature(int signature) {
		this.signature = signature;
	}
	public String getSignatureStr() {
		if(getSignature()>0){
			signatureStr="qm_zly.gif";
		}else{
			signatureStr="qm_zx.png";
		}
		return signatureStr;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Field[] fields = this.getClass().getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			StringBuffer tempSb = new StringBuffer();
			try {
				if(fields[i].get(this)!=null){
					if(i > 0){
						sb.append(" | ");
					}
					String value = fields[i].get(this).toString();
					tempSb.append(fields[i].getName());
					tempSb.append("=");
					tempSb.append(value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(StringUtils.isNotEmpty(tempSb.toString())){
				sb.append(tempSb);
			}
			
		}
		
		
		return sb.toString();
	}
	public int getRepayBenxi() {
		return repayBenxi;
	}
	public void setRepayBenxi(int repayBenxi) {
		this.repayBenxi = repayBenxi;
	}
}
