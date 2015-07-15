package com.bl.web.common.model;

public class RegistMobile {

	private int rgId;
	private String mobileNo;
	private String empId;
	private String storeCode;
	private String registYn;
	private String delYn;
	private String remark;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	private String source;//可好来源
	private String jmStoreCode;
	public String getJmStoreCode() {
		return jmStoreCode;
	}
	public void setJmStoreCode(String jmStoreCode) {
		this.jmStoreCode = jmStoreCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	 
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getRegistYn() {
		return registYn;
	}
	public void setRegistYn(String registYn) {
		this.registYn = registYn;
	}
	public String getCreateDts() {
		return createDts;
	}
	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}
	public String getUpdateDts() {
		return updateDts;
	}
	public void setUpdateDts(String updateDts) {
		this.updateDts = updateDts;
	}
	public int getRgId() {
		return rgId;
	}
	public void setRgId(int rgId) {
		this.rgId = rgId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
}
