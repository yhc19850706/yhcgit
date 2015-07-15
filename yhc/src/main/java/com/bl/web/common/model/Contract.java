package com.bl.web.common.model;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;

public class Contract {

	private String tradeNumber;
	private String userNm;
	private String city;
	private String storeNm;
	private BigDecimal originAmt;
	private int period;
	private String flag;
	private String creditId;
	private String storeCode;
	private String createDts;
	
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>=4){
			storeNm=ContextUtil.getXmphStoreCodeList().get(getStoreCode().substring(0,4)).getStoreNm();
		}
		this.city = city;
	}
	public String getStoreNm() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>4){
			storeNm=ContextUtil.getXmphStoreCodeList().get(getStoreCode()).getStoreNm();
		}
		return storeNm;
	}
	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
	}
	
	public BigDecimal getOriginAmt() {
		return originAmt;
	}
	public void setOriginAmt(BigDecimal originAmt) {
		this.originAmt = originAmt;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	
}
