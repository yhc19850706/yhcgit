package com.yhc.weixin.model;

import java.math.BigDecimal;

public class RedEnvelopes {
	
	private int redEnvelopesId;
	
	private String redEnvelopesNm;			//红包标题
	
	private String redEnvelopesSource;		//红包来源
	
	private BigDecimal redEnvelopesAmt;		//红包金额
	
	private String distributionType;		//红包发放方式
	
	private String startDts;				//发行开始时间
		
	private String endDts;					//发行结束时间
	
	private String realEndDts;				//实际结束时间
	
	private String reType;				    //红包类型
	
	private String delYn;					//是否失效	
	
	private String createId;				//创建者id
	
	private String createDts;				//创建时间(14位 :20130102152031)
	
	private String updateId;				//更新者id
	
	private String updateDts;				//创建时间(14位 :20130102152031)
	
	private int effectiveDate;			    //红包有效期
	
	private String aepeatAbleYn;			    //红包是否可重复
	
	private String reUseType;				//红包使用类型
	
	private BigDecimal reUseUpperLimit;	    //使用红包投资占比上限
	
	private String reInvestType;			//红包定向投资类型

	public int getRedEnvelopesId() {
		return redEnvelopesId;
	}

	public void setRedEnvelopesId(int redEnvelopesId) {
		this.redEnvelopesId = redEnvelopesId;
	}

	public String getRedEnvelopesNm() {
		return redEnvelopesNm;
	}

	public void setRedEnvelopesNm(String redEnvelopesNm) {
		this.redEnvelopesNm = redEnvelopesNm;
	}

	public String getRedEnvelopesSource() {
		return redEnvelopesSource;
	}

	public void setRedEnvelopesSource(String redEnvelopesSource) {
		this.redEnvelopesSource = redEnvelopesSource;
	}

	public BigDecimal getRedEnvelopesAmt() {
		return redEnvelopesAmt;
	}

	public void setRedEnvelopesAmt(BigDecimal redEnvelopesAmt) {
		this.redEnvelopesAmt = redEnvelopesAmt;
	}

	public String getDistributionType() {
		return distributionType;
	}

	public void setDistributionType(String distributionType) {
		this.distributionType = distributionType;
	}

	public String getStartDts() {
		return startDts;
	}

	public void setStartDts(String startDts) {
		this.startDts = startDts;
	}

	public String getEndDts() {
		return endDts;
	}

	public void setEndDts(String endDts) {
		this.endDts = endDts;
	}

	public String getRealEndDts() {
		return realEndDts;
	}

	public void setRealEndDts(String realEndDts) {
		this.realEndDts = realEndDts;
	}

	public String getReType() {
		return reType;
	}

	public void setReType(String reType) {
		this.reType = reType;
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

	public int getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(int effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getAepeatAbleYn() {
		return aepeatAbleYn;
	}

	public void setAepeatAbleYn(String aepeatAbleYn) {
		this.aepeatAbleYn = aepeatAbleYn;
	}

	public String getReUseType() {
		return reUseType;
	}

	public void setReUseType(String reUseType) {
		this.reUseType = reUseType;
	}

	public BigDecimal getReUseUpperLimit() {
		return reUseUpperLimit;
	}

	public void setReUseUpperLimit(BigDecimal reUseUpperLimit) {
		this.reUseUpperLimit = reUseUpperLimit;
	}

	public String getReInvestType() {
		return reInvestType;
	}

	public void setReInvestType(String reInvestType) {
		this.reInvestType = reInvestType;
	}

}