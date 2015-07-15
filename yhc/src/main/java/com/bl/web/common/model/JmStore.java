package com.bl.web.common.model;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;

public class JmStore {

	private String storeCode;//门店编号  JM 01  01  001
	private String storeNm;
	private String storeAddress;
	private String contactNm;
	private String area;
	private String qrcode;
	private String province;
	private String city;
	private String mail;
	private String mobile;
	private String qq;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	private String parentCode;//归属门店
	private String areaCode;
	private String cityCode;
	private String isHq;// 是否归属总部  Y N
	private String parentStoreNm;//归属门店名称
	private String parentAreaCode;
	private String parentCityCode;
	private String parentStoreCode;
	private int visitors;//访问客户数量
	private int registers;//注册客户数量
	private int bindings;//绑定客户数量
	private BigDecimal tradeTotalAmt;//客户总交易额
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreNm() {
		return storeNm;
	}
	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getContactNm() {
		return contactNm;
	}
	public void setContactNm(String contactNm) {
		this.contactNm = contactNm;
	}
	public String getArea() {
		if(StringUtils.isNotBlank(getAreaCode())){
			area=ContextUtil.getXmphStoreCodeList().get(getAreaCode()).getStoreNm();
		}
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		if(StringUtils.isNotBlank(getCityCode())){
			city=ContextUtil.getXmphStoreCodeList().get(getCityCode()).getStoreNm();
		}
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getIsHq() {
		return isHq;
	}
	public void setIsHq(String isHq) {
		this.isHq = isHq;
	}
	public String getParentStoreNm() {
		if(StringUtils.isNotBlank(getParentCode())){
			if(getParentCode().equals("0")){
				parentStoreNm="总部";
			}else{
				parentStoreNm=ContextUtil.getXmphStoreCodeList().get(getParentCode()).getStoreNm();
			}
		}
		return parentStoreNm;
	}
	public void setParentStoreNm(String parentStoreNm) {
		this.parentStoreNm = parentStoreNm;
	}
	public int getVisitors() {
		return visitors;
	}
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	public int getRegisters() {
		return registers;
	}
	public void setRegisters(int registers) {
		this.registers = registers;
	}
	public int getBindings() {
		return bindings;
	}
	public void setBindings(int bindings) {
		this.bindings = bindings;
	}
	public BigDecimal getTradeTotalAmt() {
		return tradeTotalAmt;
	}
	public void setTradeTotalAmt(BigDecimal tradeTotalAmt) {
		this.tradeTotalAmt = tradeTotalAmt;
	}
	public String getParentAreaCode() {
		if(StringUtils.isNotBlank(getParentCode())&&!getParentCode().equals("0")){
			parentAreaCode=getParentCode().substring(0, 2);
		}
		return parentAreaCode;
	}
	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}
	public String getParentCityCode() {
		if(StringUtils.isNotBlank(getParentCode())&&!getParentCode().equals("0")){
			parentCityCode=getParentCode().substring(0, 4);
		}
		return parentCityCode;
	}
	public void setParentCityCode(String parentCityCode) {
		this.parentCityCode = parentCityCode;
	}
	public String getParentStoreCode() {
		if(StringUtils.isNotBlank(getParentCode())&&!getParentCode().equals("0")){
			parentAreaCode=getParentCode();
		}
		return parentStoreCode;
	}
	public void setParentStoreCode(String parentStoreCode) {
		this.parentStoreCode = parentStoreCode;
	}
}
