package com.bl.web.common.model;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;
import com.bl.web.common.utils.DateUtils;
import com.google.common.base.Strings;

public class Emp {

	private String empId;
	private String empNm;
	private String empPw;
	private String empEmail;
	private String empMobileNo;
	private String inviteCode;
	private String delYn;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	
	//store
	private String storeNm;
	private String area;
	private String city;
	private String qrcode;
	private String storeQrcode;
	private int authId;
	private String authType;
	private String storeCode;
	private String areaCode;
	private String cityCode;
	
	//password
	private String oriEmpPw;//原密码
	private String empConfirmPw;//确认密码
	
	//起始时间
	private String startDt;
	private String endDt;
	private String authNm;
	public String getAuthNm() {
		return authNm;
	}
	public void setAuthNm(String authNm) {
		this.authNm = authNm;
	}
	public String getOriEmpPw() {
		return oriEmpPw;
	}
	public void setOriEmpPw(String oriEmpPw) {
		this.oriEmpPw = oriEmpPw;
	}
	public String getEmpConfirmPw() {
		return empConfirmPw;
	}
	public void setEmpConfirmPw(String empConfirmPw) {
		this.empConfirmPw = empConfirmPw;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getAreaCode() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>=2){
			areaCode=getStoreCode().substring(0, 2);
		}
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getCityCode() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>=4){
			cityCode=getStoreCode().substring(0, 4);
		}
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
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
	public String getStoreNm() {
		if(StringUtils.isNotBlank(getStoreCode())&&getStoreCode().length()>4){
			storeNm=ContextUtil.getXmphStoreCodeList().get(getStoreCode()).getStoreNm();
		}
		return storeNm;
	}
	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
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
	public String getCity() {
		if(StringUtils.isNotBlank(getCityCode())){
			city=ContextUtil.getXmphStoreCodeList().get(getCityCode()).getStoreNm();	
		}
		
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getStoreQrcode() {
		return storeQrcode;
	}
	public void setStoreQrcode(String storeQrcode) {
		this.storeQrcode = storeQrcode;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		if(StringUtils.isNotBlank(startDt)&&startDt.length()>8){
			startDt=DateUtils.dateFormat(DateUtils.dateFormat(startDt),null).substring(0, 8);
		}
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		if(StringUtils.isNotBlank(endDt)&&endDt.length()>8){
			endDt=DateUtils.dateFormat(DateUtils.dateFormat(endDt),null).substring(0, 8);
		}
		this.endDt = endDt;
	}
	
}
