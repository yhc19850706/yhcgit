package com.yhc.weixin.model;

/**
 * @author xjiang
 *
 */
public class UserPhone {

	private int phoneId;
	
	private String phoneNo; //手机号
	
	/**
	 * PHONETP	电话号码类型	
	   PHONETP01	手机号	PHONETP
	   PHONETP02	手机号-电核	PHONETP
	   PHONETP03	居住电话	PHONETP
	   PHONETP04	居住电话－电核	PHONETP
	   PHONETP05	直系亲属	PHONETP
	   PHONETP06	直系亲属－电核	PHONETP
	   PHONETP07	紧急联系人	PHONETP
	   PHONETP08	紧急联系人－电核	PHONETP
	   PHONETP09	工作证明人	PHONETP
	   PHONETP10	工作证明人－电核	PHONETP
	   PHONETP11	公司电话	PHONETP
	   PHONETP12	公司电话－电核	PHONETP

	 */
	private String phoneType; 
	
	private String phoneOwnerNm; //手机主人姓名
	
	private String relation; //关系
	
    private String userId;
    
    private String delYn;
    
    //创建者id
  	private String createId;
  	//创建时间(14位 :20130102152031)
  	private String createDts;
  	//更新者id
  	private String updateId;
  	//更新时间(14位 :20130102152031)
  	private String updateDts;
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPhoneOwnerNm() {
		return phoneOwnerNm;
	}
	public void setPhoneOwnerNm(String phoneOwnerNm) {
		this.phoneOwnerNm = phoneOwnerNm;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
}
