package com.yhc.weixin.model;
import org.apache.commons.lang.StringUtils;

public class UserCareerInfo extends UserInfo{

	//企业性质 'CARS01:工薪阶层，CARS02:私营企业主，CARS03:网商'
	private String careerStatus;
	//企业名称
	private String corpNm;
	private String corpEmail;
	private String corpProvince;
	private String corpCity;
	private String corpAddress;
	private String corpProperty;
	private String corpCategory;
	private String corpBusiLine;
	// '现单位工作年限 CWP01:1年（含）以下，CWP02:1-3年（含），CWP03:3-5年（含）CWP04:5年以上'
	private String corpWorkPeriod;
	private String corpPhone;
	private String onlineShopUrl;
	//'ONLSHP01:1年（含）以下， OSP02:1-3年（含）'
	private String onlineShopPeriod;
	//公司规模
	private String corpScale;
	//职位
	private String jobTitle;
	//月收入 'MI01:1000以下， MI02:1000－2000， MI03:2000-5000， MI04:5000-10000， MI05:10000-20000， MI06:20000-50000， MI06:50000以上',
	private String monthIncome;
	
	private boolean ujiEnough;
	private boolean uciEnough;
	private boolean uosiEnough;

	
	public String getCareerStatus() {
		return careerStatus;
	}
	public void setCareerStatus(String careerStatus) {
		this.careerStatus = careerStatus;
	}
	public String getCorpNm() {
		return corpNm;
	}
	public void setCorpNm(String corpNm) {
		this.corpNm = corpNm;
	}
	public String getCorpEmail() {
		return corpEmail;
	}
	public void setCorpEmail(String corpEmail) {
		this.corpEmail = corpEmail;
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
	public String getCorpAddress() {
		return corpAddress;
	}
	public void setCorpAddress(String corpAddress) {
		this.corpAddress = corpAddress;
	}
	public String getCorpCategory() {
		return corpCategory;
	}
	public void setCorpCategory(String corpCategory) {
		this.corpCategory = corpCategory;
	}
	public String getCorpProperty() {
		return corpProperty;
	}
	public void setCorpProperty(String corpProperty) {
		this.corpProperty = corpProperty;
	}
	public String getCorpBusiLine() {
		return corpBusiLine;
	}
	public void setCorpBusiLine(String corpBusiLine) {
		this.corpBusiLine = corpBusiLine;
	}
	public String getCorpWorkPeriod() {
		return corpWorkPeriod;
	}
	public void setCorpWorkPeriod(String corpWorkPeriod) {
		this.corpWorkPeriod = corpWorkPeriod;
	}
	public String getCorpPhone() {
		return corpPhone;
	}
	public void setCorpPhone(String corpPhone) {
		this.corpPhone = corpPhone;
	}
	public String getOnlineShopUrl() {
		return onlineShopUrl;
	}
	public void setOnlineShopUrl(String onlineShopUrl) {
		this.onlineShopUrl = onlineShopUrl;
	}
	public String getOnlineShopPeriod() {
		return onlineShopPeriod;
	}
	public void setOnlineShopPeriod(String onlineShopPeriod) {
		this.onlineShopPeriod = onlineShopPeriod;
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
	public boolean isUjiEnough() {
		ujiEnough = true;
		if(StringUtils.isEmpty(getCorpNm())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getJobTitle())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpProvince())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpCity())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpAddress())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpProperty())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpCategory())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpScale())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpWorkPeriod())){
			ujiEnough = false;
			return ujiEnough;
		}
		if(StringUtils.isEmpty(getCorpPhone())){
			ujiEnough = false;
			return ujiEnough;
		}
		return ujiEnough;
	}
	public boolean isUciEnough() {
		uciEnough = true;
		if(StringUtils.isEmpty(getCorpNm())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getJobTitle())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpProvince())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpCity())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpAddress())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpProperty())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpCategory())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpScale())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpWorkPeriod())){
			uciEnough = false;
			return uciEnough;
		}
		if(StringUtils.isEmpty(getCorpPhone())){
			uciEnough = false;
			return uciEnough;
		}
		return uciEnough;
	}
	public boolean isUosiEnough() {
		uosiEnough = true;
		if(StringUtils.isEmpty(getCorpNm())){
			uosiEnough = false;
			return uosiEnough;
		}
		if(StringUtils.isEmpty(getCorpProvince())){
			uosiEnough = false;
			return uosiEnough;
		}
		if(StringUtils.isEmpty(getCorpCity())){
			uosiEnough = false;
			return uosiEnough;
		}
		if(StringUtils.isEmpty(getOnlineShopUrl())){
			uosiEnough = false;
			return uosiEnough;
		}
		if(StringUtils.isEmpty(getOnlineShopPeriod())){
			uosiEnough = false;
			return uosiEnough;
		}
		return uosiEnough;
	}

}
