package com.bl.web.common.model;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.config.ExcelAnnotation;
import com.bl.web.common.utils.ContextUtil;
import com.bl.web.common.utils.DateUtils;

public class Customer {

	//用户ID
	private String userId;
	
	@ExcelAnnotation(name = "客户姓名", order = 1)
	private String userName;
	@ExcelAnnotation(name = "绑定时间", order = 4)
	private String bingdDts;
	@ExcelAnnotation(name = "注册时间", order = 2)
	private String registDts;
	@ExcelAnnotation(name = "投资时间", order = 3)
	private String inviteDts;
	private String mobileNo;
	@ExcelAnnotation(name = "绑定服务码", order = 5)
	private String inviteCode;
	private String oldCode;
	private String inviteEmpId;
	@ExcelAnnotation(name = "员工姓名", order = 6)
	private String empNm;
	private String empMobileNo;
	//门店信息
	private String storeCode;
	private String parentCode;
	private String areaCode;
	private String cityCode;
	private String cityAreaCode;
	private String storeNm;
	private String area;
	private String city;
	private String cityArea;
	//投资
	private BigDecimal finalAmt;
	private BigDecimal inviteAmt;
	private BigDecimal totalRevenue;
	private BigDecimal lastRevenue;
	private String bankName;
	private String bankCardNo;
	private String creditId;
	@ExcelAnnotation(name = "是否调整", order = 7)
	private String isTzStr;
	private int isTz;
	private String startDt;
	private String endDt;
	
	public int getIsTz() {
		return isTz;
	}

	public void setIsTz(int isTz) {
		this.isTz = isTz;
	}

	public String getIsTzStr() {
		return isTzStr;
	}

	public void setIsTzStr(String isTzStr) {
		this.isTzStr = isTzStr;
	}

	public String getCreditId() {
		return creditId;
	}

	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getInviteEmpId() {
		return inviteEmpId;
	}

	public void setInviteEmpId(String inviteEmpId) {
		this.inviteEmpId = inviteEmpId;
	}
	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getBingdDts() {
		return bingdDts;
	}

	public void setBingdDts(String bingdDts) {
		this.bingdDts = bingdDts;
	}

	public String getRegistDts() {
		return registDts;
	}

	public void setRegistDts(String registDts) {
		this.registDts = registDts;
	}

	public String getInviteDts() {
		return inviteDts;
	}

	public void setInviteDts(String inviteDts) {
		this.inviteDts = inviteDts;
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

	public String getAreaCode() {
		if(StringUtils.isNotBlank(getParentCode())&&getParentCode().length()>=2){
			areaCode=getParentCode().substring(0, 2);
		}
		return areaCode;
	}


	public String getCityCode() {
		if(StringUtils.isNotBlank(getParentCode())&&getParentCode().length()>=4){
			cityCode=getParentCode().substring(0, 4);
		}
		return cityCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	public String getCityAreaCode() {
		if(StringUtils.isNotBlank(getParentCode())&&getParentCode().length()>4){
			cityAreaCode=getParentCode().substring(0, 6);
		}
		return cityAreaCode;
	}

	public String getStoreNm() {
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


	public String getCity() {
		if(StringUtils.isNotBlank(getCityCode())){
			city=ContextUtil.getXmphStoreCodeList().get(getCityCode()).getStoreNm();
		}
		return city;
	}

	public String getCityArea() {
		if(StringUtils.isNotBlank(getCityAreaCode())){
			cityArea=ContextUtil.getXmphStoreCodeList().get(getCityAreaCode()).getStoreNm();
		}
		return cityArea;
	}

	public BigDecimal getFinalAmt() {
		return finalAmt;
	}

	public void setFinalAmt(BigDecimal finalAmt) {
		this.finalAmt = finalAmt;
	}

	public BigDecimal getInviteAmt() {
		return inviteAmt;
	}

	public void setInviteAmt(BigDecimal inviteAmt) {
		this.inviteAmt = inviteAmt;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public BigDecimal getLastRevenue() {
		return lastRevenue;
	}

	public void setLastRevenue(BigDecimal lastRevenue) {
		this.lastRevenue = lastRevenue;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
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
