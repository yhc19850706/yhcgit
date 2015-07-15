package com.bl.web.common.model;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;

public class Store {

	private String storeCode;//门店编号
	protected String storeNm;
	protected String storeAddress;
	protected String contactNm;
	protected String area;
	protected String qrcode;
	protected String province;
	protected String city;
	protected String mail;
	protected String mobile;
	protected String qq;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	
	private String parentCode;//门店上级编号
	private String areaCode;
	private String cityCode;
	
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
			Store s=ContextUtil.getXmphStoreCodeList().get(getAreaCode());
			if(s!=null){
				area=s.getStoreNm();
			}
			
		}
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		if(StringUtils.isNotBlank(getCityCode())){
			Store s=ContextUtil.getXmphStoreCodeList().get(getCityCode());
			if(s!=null){
				city=s.getStoreNm();
			}
		}
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getAreaCode() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>2){
			cityCode=getStoreCode().substring(0, 2);
		}
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCityCode() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>4){
			cityCode=getStoreCode().substring(0, 4);
		}
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
}
