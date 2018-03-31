package com.yhc.lifeall.model.sysdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBasicInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserBasicInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserRealNmIsNull() {
            addCriterion("user_real_nm is null");
            return (Criteria) this;
        }

        public Criteria andUserRealNmIsNotNull() {
            addCriterion("user_real_nm is not null");
            return (Criteria) this;
        }

        public Criteria andUserRealNmEqualTo(String value) {
            addCriterion("user_real_nm =", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmNotEqualTo(String value) {
            addCriterion("user_real_nm <>", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmGreaterThan(String value) {
            addCriterion("user_real_nm >", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmGreaterThanOrEqualTo(String value) {
            addCriterion("user_real_nm >=", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmLessThan(String value) {
            addCriterion("user_real_nm <", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmLessThanOrEqualTo(String value) {
            addCriterion("user_real_nm <=", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmLike(String value) {
            addCriterion("user_real_nm like", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmNotLike(String value) {
            addCriterion("user_real_nm not like", value, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmIn(List<String> values) {
            addCriterion("user_real_nm in", values, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmNotIn(List<String> values) {
            addCriterion("user_real_nm not in", values, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmBetween(String value1, String value2) {
            addCriterion("user_real_nm between", value1, value2, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserRealNmNotBetween(String value1, String value2) {
            addCriterion("user_real_nm not between", value1, value2, "userRealNm");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoIsNull() {
            addCriterion("user_idcard_no is null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoIsNotNull() {
            addCriterion("user_idcard_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoEqualTo(String value) {
            addCriterion("user_idcard_no =", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoNotEqualTo(String value) {
            addCriterion("user_idcard_no <>", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoGreaterThan(String value) {
            addCriterion("user_idcard_no >", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_idcard_no >=", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoLessThan(String value) {
            addCriterion("user_idcard_no <", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoLessThanOrEqualTo(String value) {
            addCriterion("user_idcard_no <=", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoLike(String value) {
            addCriterion("user_idcard_no like", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoNotLike(String value) {
            addCriterion("user_idcard_no not like", value, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoIn(List<String> values) {
            addCriterion("user_idcard_no in", values, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoNotIn(List<String> values) {
            addCriterion("user_idcard_no not in", values, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoBetween(String value1, String value2) {
            addCriterion("user_idcard_no between", value1, value2, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNoNotBetween(String value1, String value2) {
            addCriterion("user_idcard_no not between", value1, value2, "userIdcardNo");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Byte value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Byte value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Byte value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Byte value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Byte value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Byte> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Byte> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Byte value1, Byte value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Byte value1, Byte value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirIsNull() {
            addCriterion("user_head_file_dir is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirIsNotNull() {
            addCriterion("user_head_file_dir is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirEqualTo(String value) {
            addCriterion("user_head_file_dir =", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirNotEqualTo(String value) {
            addCriterion("user_head_file_dir <>", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirGreaterThan(String value) {
            addCriterion("user_head_file_dir >", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirGreaterThanOrEqualTo(String value) {
            addCriterion("user_head_file_dir >=", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirLessThan(String value) {
            addCriterion("user_head_file_dir <", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirLessThanOrEqualTo(String value) {
            addCriterion("user_head_file_dir <=", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirLike(String value) {
            addCriterion("user_head_file_dir like", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirNotLike(String value) {
            addCriterion("user_head_file_dir not like", value, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirIn(List<String> values) {
            addCriterion("user_head_file_dir in", values, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirNotIn(List<String> values) {
            addCriterion("user_head_file_dir not in", values, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirBetween(String value1, String value2) {
            addCriterion("user_head_file_dir between", value1, value2, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andUserHeadFileDirNotBetween(String value1, String value2) {
            addCriterion("user_head_file_dir not between", value1, value2, "userHeadFileDir");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andEducateBgIsNull() {
            addCriterion("educate_bg is null");
            return (Criteria) this;
        }

        public Criteria andEducateBgIsNotNull() {
            addCriterion("educate_bg is not null");
            return (Criteria) this;
        }

        public Criteria andEducateBgEqualTo(String value) {
            addCriterion("educate_bg =", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgNotEqualTo(String value) {
            addCriterion("educate_bg <>", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgGreaterThan(String value) {
            addCriterion("educate_bg >", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgGreaterThanOrEqualTo(String value) {
            addCriterion("educate_bg >=", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgLessThan(String value) {
            addCriterion("educate_bg <", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgLessThanOrEqualTo(String value) {
            addCriterion("educate_bg <=", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgLike(String value) {
            addCriterion("educate_bg like", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgNotLike(String value) {
            addCriterion("educate_bg not like", value, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgIn(List<String> values) {
            addCriterion("educate_bg in", values, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgNotIn(List<String> values) {
            addCriterion("educate_bg not in", values, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgBetween(String value1, String value2) {
            addCriterion("educate_bg between", value1, value2, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEducateBgNotBetween(String value1, String value2) {
            addCriterion("educate_bg not between", value1, value2, "educateBg");
            return (Criteria) this;
        }

        public Criteria andEduStartYearIsNull() {
            addCriterion("edu_start_year is null");
            return (Criteria) this;
        }

        public Criteria andEduStartYearIsNotNull() {
            addCriterion("edu_start_year is not null");
            return (Criteria) this;
        }

        public Criteria andEduStartYearEqualTo(String value) {
            addCriterion("edu_start_year =", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearNotEqualTo(String value) {
            addCriterion("edu_start_year <>", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearGreaterThan(String value) {
            addCriterion("edu_start_year >", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearGreaterThanOrEqualTo(String value) {
            addCriterion("edu_start_year >=", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearLessThan(String value) {
            addCriterion("edu_start_year <", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearLessThanOrEqualTo(String value) {
            addCriterion("edu_start_year <=", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearLike(String value) {
            addCriterion("edu_start_year like", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearNotLike(String value) {
            addCriterion("edu_start_year not like", value, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearIn(List<String> values) {
            addCriterion("edu_start_year in", values, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearNotIn(List<String> values) {
            addCriterion("edu_start_year not in", values, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearBetween(String value1, String value2) {
            addCriterion("edu_start_year between", value1, value2, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andEduStartYearNotBetween(String value1, String value2) {
            addCriterion("edu_start_year not between", value1, value2, "eduStartYear");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolIsNull() {
            addCriterion("finish_school is null");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolIsNotNull() {
            addCriterion("finish_school is not null");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolEqualTo(String value) {
            addCriterion("finish_school =", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolNotEqualTo(String value) {
            addCriterion("finish_school <>", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolGreaterThan(String value) {
            addCriterion("finish_school >", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("finish_school >=", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolLessThan(String value) {
            addCriterion("finish_school <", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolLessThanOrEqualTo(String value) {
            addCriterion("finish_school <=", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolLike(String value) {
            addCriterion("finish_school like", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolNotLike(String value) {
            addCriterion("finish_school not like", value, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolIn(List<String> values) {
            addCriterion("finish_school in", values, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolNotIn(List<String> values) {
            addCriterion("finish_school not in", values, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolBetween(String value1, String value2) {
            addCriterion("finish_school between", value1, value2, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andFinishSchoolNotBetween(String value1, String value2) {
            addCriterion("finish_school not between", value1, value2, "finishSchool");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceIsNull() {
            addCriterion("birth_province is null");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceIsNotNull() {
            addCriterion("birth_province is not null");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceEqualTo(String value) {
            addCriterion("birth_province =", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceNotEqualTo(String value) {
            addCriterion("birth_province <>", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceGreaterThan(String value) {
            addCriterion("birth_province >", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("birth_province >=", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceLessThan(String value) {
            addCriterion("birth_province <", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceLessThanOrEqualTo(String value) {
            addCriterion("birth_province <=", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceLike(String value) {
            addCriterion("birth_province like", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceNotLike(String value) {
            addCriterion("birth_province not like", value, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceIn(List<String> values) {
            addCriterion("birth_province in", values, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceNotIn(List<String> values) {
            addCriterion("birth_province not in", values, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceBetween(String value1, String value2) {
            addCriterion("birth_province between", value1, value2, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthProvinceNotBetween(String value1, String value2) {
            addCriterion("birth_province not between", value1, value2, "birthProvince");
            return (Criteria) this;
        }

        public Criteria andBirthCityIsNull() {
            addCriterion("birth_city is null");
            return (Criteria) this;
        }

        public Criteria andBirthCityIsNotNull() {
            addCriterion("birth_city is not null");
            return (Criteria) this;
        }

        public Criteria andBirthCityEqualTo(String value) {
            addCriterion("birth_city =", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityNotEqualTo(String value) {
            addCriterion("birth_city <>", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityGreaterThan(String value) {
            addCriterion("birth_city >", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityGreaterThanOrEqualTo(String value) {
            addCriterion("birth_city >=", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityLessThan(String value) {
            addCriterion("birth_city <", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityLessThanOrEqualTo(String value) {
            addCriterion("birth_city <=", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityLike(String value) {
            addCriterion("birth_city like", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityNotLike(String value) {
            addCriterion("birth_city not like", value, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityIn(List<String> values) {
            addCriterion("birth_city in", values, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityNotIn(List<String> values) {
            addCriterion("birth_city not in", values, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityBetween(String value1, String value2) {
            addCriterion("birth_city between", value1, value2, "birthCity");
            return (Criteria) this;
        }

        public Criteria andBirthCityNotBetween(String value1, String value2) {
            addCriterion("birth_city not between", value1, value2, "birthCity");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceIsNull() {
            addCriterion("hukou_province is null");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceIsNotNull() {
            addCriterion("hukou_province is not null");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceEqualTo(String value) {
            addCriterion("hukou_province =", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceNotEqualTo(String value) {
            addCriterion("hukou_province <>", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceGreaterThan(String value) {
            addCriterion("hukou_province >", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("hukou_province >=", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceLessThan(String value) {
            addCriterion("hukou_province <", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceLessThanOrEqualTo(String value) {
            addCriterion("hukou_province <=", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceLike(String value) {
            addCriterion("hukou_province like", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceNotLike(String value) {
            addCriterion("hukou_province not like", value, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceIn(List<String> values) {
            addCriterion("hukou_province in", values, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceNotIn(List<String> values) {
            addCriterion("hukou_province not in", values, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceBetween(String value1, String value2) {
            addCriterion("hukou_province between", value1, value2, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouProvinceNotBetween(String value1, String value2) {
            addCriterion("hukou_province not between", value1, value2, "hukouProvince");
            return (Criteria) this;
        }

        public Criteria andHukouCityIsNull() {
            addCriterion("hukou_city is null");
            return (Criteria) this;
        }

        public Criteria andHukouCityIsNotNull() {
            addCriterion("hukou_city is not null");
            return (Criteria) this;
        }

        public Criteria andHukouCityEqualTo(String value) {
            addCriterion("hukou_city =", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityNotEqualTo(String value) {
            addCriterion("hukou_city <>", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityGreaterThan(String value) {
            addCriterion("hukou_city >", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityGreaterThanOrEqualTo(String value) {
            addCriterion("hukou_city >=", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityLessThan(String value) {
            addCriterion("hukou_city <", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityLessThanOrEqualTo(String value) {
            addCriterion("hukou_city <=", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityLike(String value) {
            addCriterion("hukou_city like", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityNotLike(String value) {
            addCriterion("hukou_city not like", value, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityIn(List<String> values) {
            addCriterion("hukou_city in", values, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityNotIn(List<String> values) {
            addCriterion("hukou_city not in", values, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityBetween(String value1, String value2) {
            addCriterion("hukou_city between", value1, value2, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHukouCityNotBetween(String value1, String value2) {
            addCriterion("hukou_city not between", value1, value2, "hukouCity");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeContactsIsNull() {
            addCriterion("home_contacts is null");
            return (Criteria) this;
        }

        public Criteria andHomeContactsIsNotNull() {
            addCriterion("home_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andHomeContactsEqualTo(String value) {
            addCriterion("home_contacts =", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsNotEqualTo(String value) {
            addCriterion("home_contacts <>", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsGreaterThan(String value) {
            addCriterion("home_contacts >", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsGreaterThanOrEqualTo(String value) {
            addCriterion("home_contacts >=", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsLessThan(String value) {
            addCriterion("home_contacts <", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsLessThanOrEqualTo(String value) {
            addCriterion("home_contacts <=", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsLike(String value) {
            addCriterion("home_contacts like", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsNotLike(String value) {
            addCriterion("home_contacts not like", value, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsIn(List<String> values) {
            addCriterion("home_contacts in", values, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsNotIn(List<String> values) {
            addCriterion("home_contacts not in", values, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsBetween(String value1, String value2) {
            addCriterion("home_contacts between", value1, value2, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeContactsNotBetween(String value1, String value2) {
            addCriterion("home_contacts not between", value1, value2, "homeContacts");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoIsNull() {
            addCriterion("home_mobile_no is null");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoIsNotNull() {
            addCriterion("home_mobile_no is not null");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoEqualTo(String value) {
            addCriterion("home_mobile_no =", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoNotEqualTo(String value) {
            addCriterion("home_mobile_no <>", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoGreaterThan(String value) {
            addCriterion("home_mobile_no >", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("home_mobile_no >=", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoLessThan(String value) {
            addCriterion("home_mobile_no <", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoLessThanOrEqualTo(String value) {
            addCriterion("home_mobile_no <=", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoLike(String value) {
            addCriterion("home_mobile_no like", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoNotLike(String value) {
            addCriterion("home_mobile_no not like", value, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoIn(List<String> values) {
            addCriterion("home_mobile_no in", values, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoNotIn(List<String> values) {
            addCriterion("home_mobile_no not in", values, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoBetween(String value1, String value2) {
            addCriterion("home_mobile_no between", value1, value2, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andHomeMobileNoNotBetween(String value1, String value2) {
            addCriterion("home_mobile_no not between", value1, value2, "homeMobileNo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}