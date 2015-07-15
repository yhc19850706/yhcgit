package com.bl.web.common.model;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.ContextUtil;

public class UserBaseInfo extends User {

	private String userSex;
	private String birthDt;
	//'最高学历 EDUBG01:高中或以下, EDUBG02:大专, EDUBG03:本科, EDUBG04:研究生或以上',
	private String educateBg;
	private String educateBgStr;
	private String eduStartYear;
	private String finishSchool;
	private String birthProvince;
	private String birthCity;
	private String homeAddress;
	private String homeZip;
	private String homePhoneNo;
	private String p2pLoanYn;
	private String infoFullYn;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateDts;
	//婚姻状态  'MERGST01：已婚，MERGST02:未婚，MERGST03:离异，MERGST04:丧偶',
	private String marriageStatus;
	private String marriageStatusStr;
	//公司规模
	private String corpScale;
	//职位
	private String jobTitle;
	//月收入 'MI01:1000以下， MI02:1000－2000， MI03:2000-5000， MI04:5000-10000， MI05:10000-20000， MI06:20000-50000， MI06:50000以上',
	private String monthIncome;
	//汇付天下账号
	protected String channelUserNm;
	//公司行业
	private String corpCategory;
	
	// '现单位工作年限 CWP01:1年（含）以下，CWP02:1-3年（含），CWP03:3-5年（含）CWP04:5年以上'
	private String corpWorkPeriod;
	
	private String corpProvince;
	
	private String corpCity;
	
	private boolean ubiEnough;

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getBirthDt() {
		return birthDt;
	}

	public void setBirthDt(String birthDt) {
		if(StringUtils.isNotBlank(birthDt) && birthDt.contains("-")) {
			this.birthDt = birthDt.replaceAll("-", "");
		} else {
			this.birthDt = birthDt;
		}
		
	}

	public String getEducateBg() {
		return educateBg;
	}

	public void setEducateBg(String educateBg) {
		this.educateBg = educateBg;
	}

	public String getEducateBgStr() {
		if (StringUtils.isNotEmpty(educateBg) && ContextUtil.getCommonCodeMap().get(educateBg) != null) {
			educateBgStr = ContextUtil.getCommonCodeMap().get(educateBg);
		}
		return educateBgStr;
	}

	public String getEduStartYear() {
		return eduStartYear;
	}

	public void setEduStartYear(String eduStartYear) {
		this.eduStartYear = eduStartYear;
	}

	public String getFinishSchool() {
		return finishSchool;
	}

	public void setFinishSchool(String finishSchool) {
		this.finishSchool = finishSchool;
	}

	public String getBirthProvince() {
		return birthProvince;
	}

	public void setBirthProvince(String birthProvince) {
		this.birthProvince = birthProvince;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeZip() {
		return homeZip;
	}

	public void setHomeZip(String homeZip) {
		this.homeZip = homeZip;
	}

	public String getHomePhoneNo() {
		return homePhoneNo;
	}

	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}

	public String getP2pLoanYn() {
		return p2pLoanYn;
	}

	public void setP2pLoanYn(String p2pLoanYn) {
		this.p2pLoanYn = p2pLoanYn;
	}

	public String getInfoFullYn() {
		infoFullYn = "N";
		if (StringUtils.isNotEmpty(super.getMobileNo()) && StringUtils.isNotEmpty(super.getEmail())
			&& StringUtils.isNotEmpty(getChannelUserNm()) && StringUtils.isNotEmpty(super.getUserRealNm())
			&& StringUtils.isNotEmpty(super.getUserIdcardNo())) {
			infoFullYn = "Y";
		}
		return infoFullYn;
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

	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getMarriageStatusStr() {
		marriageStatusStr = "";
		if (StringUtils.isNotEmpty(marriageStatus)) {
			if (StringUtils.isNotEmpty(ContextUtil.getCommonCodeMap().get(marriageStatus))) {
				marriageStatusStr = ContextUtil.getCommonCodeMap().get(marriageStatus);
			}
		}
		return marriageStatusStr;
	}

	public String getCorpScale() {
		return corpScale;
	}

	public void setCorpScale(String corpScale) {
		this.corpScale = corpScale;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getMonthIncome() {
		return monthIncome;
	}

	public void setMonthIncome(String monthIncome) {
		this.monthIncome = monthIncome;
	}

	public String getChannelUserNm() {
		return channelUserNm;
	}

	public void setChannelUserNm(String channelUserNm) {
		this.channelUserNm = channelUserNm;
	}

	public String getCorpCategory() {
		return corpCategory;
	}

	public void setCorpCategory(String corpCategory) {
		this.corpCategory = corpCategory;
	}
	
	public String getCorpWorkPeriod() {
		return corpWorkPeriod;
	}

	public void setCorpWorkPeriod(String corpWorkPeriod) {
		this.corpWorkPeriod = corpWorkPeriod;
	}

	public String getCorpProvince() {
		return corpProvince;
	}

	public void setCorpProvince(String corpProvince) {
		this.corpProvince = corpProvince;
	}
	
	

	public String getCorpCity() {
		return corpCity;
	}

	public void setCorpCity(String corpCity) {
		this.corpCity = corpCity;
	}

	public boolean isUbiEnough() {
		ubiEnough = true;
		if(StringUtils.isEmpty(getUserRealNm())){
			ubiEnough = false;
			return ubiEnough;
		}
		if(StringUtils.isEmpty(getUserIdcardNo())){
			ubiEnough = false;
			return ubiEnough;
		}
		if(StringUtils.isEmpty(getMobileNo())){
			ubiEnough = false;
			return ubiEnough;
		}

		if(StringUtils.isEmpty(getUserSex())){
			ubiEnough = false;
			return ubiEnough;
		}
		if(StringUtils.isEmpty(getHomeAddress())){
			ubiEnough = false;
			return ubiEnough;
		}
		if(StringUtils.isEmpty(getHomePhoneNo())){
			ubiEnough = false;
			return ubiEnough;
		}
		return ubiEnough;
	}


}
