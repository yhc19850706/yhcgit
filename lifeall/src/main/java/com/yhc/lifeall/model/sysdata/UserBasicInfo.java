package com.yhc.lifeall.model.sysdata;

import java.util.Date;

public class UserBasicInfo {
    private Long id;

    private Long userId;

    private String userRealNm;

    private String userIdcardNo;

    private Byte userSex;

    private String userHeadFileDir;

    private Date birthDate;

    private String educateBg;

    private String eduStartYear;

    private String finishSchool;

    private String birthProvince;

    private String birthCity;

    private String hukouProvince;

    private String hukouCity;

    private String homeAddress;

    private String homeContacts;

    private String homeMobileNo;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserRealNm() {
        return userRealNm;
    }

    public void setUserRealNm(String userRealNm) {
        this.userRealNm = userRealNm == null ? null : userRealNm.trim();
    }

    public String getUserIdcardNo() {
        return userIdcardNo;
    }

    public void setUserIdcardNo(String userIdcardNo) {
        this.userIdcardNo = userIdcardNo == null ? null : userIdcardNo.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getUserHeadFileDir() {
        return userHeadFileDir;
    }

    public void setUserHeadFileDir(String userHeadFileDir) {
        this.userHeadFileDir = userHeadFileDir == null ? null : userHeadFileDir.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEducateBg() {
        return educateBg;
    }

    public void setEducateBg(String educateBg) {
        this.educateBg = educateBg == null ? null : educateBg.trim();
    }

    public String getEduStartYear() {
        return eduStartYear;
    }

    public void setEduStartYear(String eduStartYear) {
        this.eduStartYear = eduStartYear == null ? null : eduStartYear.trim();
    }

    public String getFinishSchool() {
        return finishSchool;
    }

    public void setFinishSchool(String finishSchool) {
        this.finishSchool = finishSchool == null ? null : finishSchool.trim();
    }

    public String getBirthProvince() {
        return birthProvince;
    }

    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince == null ? null : birthProvince.trim();
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity == null ? null : birthCity.trim();
    }

    public String getHukouProvince() {
        return hukouProvince;
    }

    public void setHukouProvince(String hukouProvince) {
        this.hukouProvince = hukouProvince == null ? null : hukouProvince.trim();
    }

    public String getHukouCity() {
        return hukouCity;
    }

    public void setHukouCity(String hukouCity) {
        this.hukouCity = hukouCity == null ? null : hukouCity.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getHomeContacts() {
        return homeContacts;
    }

    public void setHomeContacts(String homeContacts) {
        this.homeContacts = homeContacts == null ? null : homeContacts.trim();
    }

    public String getHomeMobileNo() {
        return homeMobileNo;
    }

    public void setHomeMobileNo(String homeMobileNo) {
        this.homeMobileNo = homeMobileNo == null ? null : homeMobileNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}