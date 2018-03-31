package com.yhc.lifeall.model.sysdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLocationExample() {
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

        public Criteria andToUserNameIsNull() {
            addCriterion("to_user_name is null");
            return (Criteria) this;
        }

        public Criteria andToUserNameIsNotNull() {
            addCriterion("to_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andToUserNameEqualTo(String value) {
            addCriterion("to_user_name =", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameNotEqualTo(String value) {
            addCriterion("to_user_name <>", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameGreaterThan(String value) {
            addCriterion("to_user_name >", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("to_user_name >=", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameLessThan(String value) {
            addCriterion("to_user_name <", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameLessThanOrEqualTo(String value) {
            addCriterion("to_user_name <=", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameLike(String value) {
            addCriterion("to_user_name like", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameNotLike(String value) {
            addCriterion("to_user_name not like", value, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameIn(List<String> values) {
            addCriterion("to_user_name in", values, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameNotIn(List<String> values) {
            addCriterion("to_user_name not in", values, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameBetween(String value1, String value2) {
            addCriterion("to_user_name between", value1, value2, "toUserName");
            return (Criteria) this;
        }

        public Criteria andToUserNameNotBetween(String value1, String value2) {
            addCriterion("to_user_name not between", value1, value2, "toUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIsNull() {
            addCriterion("from_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIsNotNull() {
            addCriterion("from_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserNameEqualTo(String value) {
            addCriterion("from_user_name =", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotEqualTo(String value) {
            addCriterion("from_user_name <>", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameGreaterThan(String value) {
            addCriterion("from_user_name >", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_name >=", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLessThan(String value) {
            addCriterion("from_user_name <", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLessThanOrEqualTo(String value) {
            addCriterion("from_user_name <=", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLike(String value) {
            addCriterion("from_user_name like", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotLike(String value) {
            addCriterion("from_user_name not like", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIn(List<String> values) {
            addCriterion("from_user_name in", values, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotIn(List<String> values) {
            addCriterion("from_user_name not in", values, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameBetween(String value1, String value2) {
            addCriterion("from_user_name between", value1, value2, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotBetween(String value1, String value2) {
            addCriterion("from_user_name not between", value1, value2, "fromUserName");
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

        public Criteria andMsgTypeIsNull() {
            addCriterion("msg_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(String value) {
            addCriterion("msg_type =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(String value) {
            addCriterion("msg_type <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(String value) {
            addCriterion("msg_type >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("msg_type >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(String value) {
            addCriterion("msg_type <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(String value) {
            addCriterion("msg_type <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLike(String value) {
            addCriterion("msg_type like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotLike(String value) {
            addCriterion("msg_type not like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<String> values) {
            addCriterion("msg_type in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<String> values) {
            addCriterion("msg_type not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(String value1, String value2) {
            addCriterion("msg_type between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(String value1, String value2) {
            addCriterion("msg_type not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(String value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(String value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(String value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(String value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(String value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLike(String value) {
            addCriterion("event_type like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotLike(String value) {
            addCriterion("event_type not like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<String> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<String> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(String value1, String value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(String value1, String value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andPrecisonIsNull() {
            addCriterion("precison is null");
            return (Criteria) this;
        }

        public Criteria andPrecisonIsNotNull() {
            addCriterion("precison is not null");
            return (Criteria) this;
        }

        public Criteria andPrecisonEqualTo(String value) {
            addCriterion("precison =", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonNotEqualTo(String value) {
            addCriterion("precison <>", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonGreaterThan(String value) {
            addCriterion("precison >", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonGreaterThanOrEqualTo(String value) {
            addCriterion("precison >=", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonLessThan(String value) {
            addCriterion("precison <", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonLessThanOrEqualTo(String value) {
            addCriterion("precison <=", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonLike(String value) {
            addCriterion("precison like", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonNotLike(String value) {
            addCriterion("precison not like", value, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonIn(List<String> values) {
            addCriterion("precison in", values, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonNotIn(List<String> values) {
            addCriterion("precison not in", values, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonBetween(String value1, String value2) {
            addCriterion("precison between", value1, value2, "precison");
            return (Criteria) this;
        }

        public Criteria andPrecisonNotBetween(String value1, String value2) {
            addCriterion("precison not between", value1, value2, "precison");
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