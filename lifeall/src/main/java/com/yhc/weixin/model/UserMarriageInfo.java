package com.yhc.weixin.model;

import org.apache.commons.lang.StringUtils;

public class UserMarriageInfo extends UserInfo {
	//婚姻状态  'MERGST01：已婚，MERGST02:未婚，MERGST03:离异，MERGST04:丧偶',
	private String marriageStatus;
	//是否有子女 N/Y
	private String babyYn;
	//直系名称
	private String linealNm;
	//直系关系
	private String linealRelation;
	private String linealMobile;
	
	private String urgentNm;
	private String urgentRelation;
	private String urgentMobile;
	
	
	//工作证明人
	private String otherNm;
	private String otherRelation;
	private String otherMobile;
	
	private boolean umiEnough;

	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}


	public String getBabyYn() {
		return babyYn;
	}

	public void setBabyYn(String babyYn) {
		this.babyYn = babyYn;
	}

	public String getLinealNm() {
		return linealNm;
	}

	public void setLinealNm(String linealNm) {
		this.linealNm = linealNm;
	}

	public String getLinealRelation() {
		return linealRelation;
	}

	public void setLinealRelation(String linealRelation) {
		this.linealRelation = linealRelation;
	}

	public String getLinealMobile() {
		return linealMobile;
	}

	public void setLinealMobile(String linealMobile) {
		this.linealMobile = linealMobile;
	}

	public String getUrgentNm() {
		return urgentNm;
	}

	public void setUrgentNm(String urgentNm) {
		this.urgentNm = urgentNm;
	}

	public String getUrgentRelation() {
		return urgentRelation;
	}

	public void setUrgentRelation(String urgentRelation) {
		this.urgentRelation = urgentRelation;
	}

	public String getUrgentMobile() {
		return urgentMobile;
	}

	public void setUrgentMobile(String urgentMobile) {
		this.urgentMobile = urgentMobile;
	}

	public String getOtherNm() {
		return otherNm;
	}

	public void setOtherNm(String otherNm) {
		this.otherNm = otherNm;
	}

	public String getOtherRelation() {
		return otherRelation;
	}

	public void setOtherRelation(String otherRelation) {
		this.otherRelation = otherRelation;
	}

	public String getOtherMobile() {
		return otherMobile;
	}

	public void setOtherMobile(String otherMobile) {
		this.otherMobile = otherMobile;
	}

	public boolean isUmiEnough() {
		umiEnough = true;
		if(StringUtils.isEmpty(getMarriageStatus())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getBabyYn())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getLinealNm())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getLinealRelation())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getLinealMobile())){
			umiEnough = false;
			return umiEnough;
		}
		
		if(StringUtils.isEmpty(getUrgentNm())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getUrgentRelation())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getUrgentMobile())){
			umiEnough = false;
			return umiEnough;
		}
		
		
		if(StringUtils.isEmpty(getOtherNm())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getOtherRelation())){
			umiEnough = false;
			return umiEnough;
		}
		if(StringUtils.isEmpty(getOtherMobile())){
			umiEnough = false;
			return umiEnough;
		}
		return umiEnough;
	}

}
