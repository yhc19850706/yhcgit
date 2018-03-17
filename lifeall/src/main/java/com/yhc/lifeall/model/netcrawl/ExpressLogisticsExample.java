package com.yhc.lifeall.model.netcrawl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpressLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpressLogisticsExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNull() {
            addCriterion("EXPRESS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNotNull() {
            addCriterion("EXPRESS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeEqualTo(String value) {
            addCriterion("EXPRESS_CODE =", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            addCriterion("EXPRESS_CODE <>", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            addCriterion("EXPRESS_CODE >", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_CODE >=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThan(String value) {
            addCriterion("EXPRESS_CODE <", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_CODE <=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLike(String value) {
            addCriterion("EXPRESS_CODE like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotLike(String value) {
            addCriterion("EXPRESS_CODE not like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIn(List<String> values) {
            addCriterion("EXPRESS_CODE in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            addCriterion("EXPRESS_CODE not in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            addCriterion("EXPRESS_CODE between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_CODE not between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNull() {
            addCriterion("EXPRESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNotNull() {
            addCriterion("EXPRESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeEqualTo(String value) {
            addCriterion("EXPRESS_TYPE =", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotEqualTo(String value) {
            addCriterion("EXPRESS_TYPE <>", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThan(String value) {
            addCriterion("EXPRESS_TYPE >", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_TYPE >=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThan(String value) {
            addCriterion("EXPRESS_TYPE <", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_TYPE <=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLike(String value) {
            addCriterion("EXPRESS_TYPE like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotLike(String value) {
            addCriterion("EXPRESS_TYPE not like", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIn(List<String> values) {
            addCriterion("EXPRESS_TYPE in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotIn(List<String> values) {
            addCriterion("EXPRESS_TYPE not in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeBetween(String value1, String value2) {
            addCriterion("EXPRESS_TYPE between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_TYPE not between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIsNull() {
            addCriterion("NODE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIsNotNull() {
            addCriterion("NODE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTimeEqualTo(Date value) {
            addCriterion("NODE_TIME =", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotEqualTo(Date value) {
            addCriterion("NODE_TIME <>", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeGreaterThan(Date value) {
            addCriterion("NODE_TIME >", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_TIME >=", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeLessThan(Date value) {
            addCriterion("NODE_TIME <", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeLessThanOrEqualTo(Date value) {
            addCriterion("NODE_TIME <=", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIn(List<Date> values) {
            addCriterion("NODE_TIME in", values, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotIn(List<Date> values) {
            addCriterion("NODE_TIME not in", values, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeBetween(Date value1, Date value2) {
            addCriterion("NODE_TIME between", value1, value2, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotBetween(Date value1, Date value2) {
            addCriterion("NODE_TIME not between", value1, value2, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("CONTEXT =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("CONTEXT <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("CONTEXT >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("CONTEXT >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("CONTEXT <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("CONTEXT <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("CONTEXT like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("CONTEXT not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("CONTEXT in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("CONTEXT not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("CONTEXT between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("CONTEXT not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andSignFlagIsNull() {
            addCriterion("sign_flag is null");
            return (Criteria) this;
        }

        public Criteria andSignFlagIsNotNull() {
            addCriterion("sign_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSignFlagEqualTo(Boolean value) {
            addCriterion("sign_flag =", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagNotEqualTo(Boolean value) {
            addCriterion("sign_flag <>", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagGreaterThan(Boolean value) {
            addCriterion("sign_flag >", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sign_flag >=", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagLessThan(Boolean value) {
            addCriterion("sign_flag <", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("sign_flag <=", value, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagIn(List<Boolean> values) {
            addCriterion("sign_flag in", values, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagNotIn(List<Boolean> values) {
            addCriterion("sign_flag not in", values, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("sign_flag between", value1, value2, "signFlag");
            return (Criteria) this;
        }

        public Criteria andSignFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sign_flag not between", value1, value2, "signFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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