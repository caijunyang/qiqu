package com.huabang.ofo.domain;

import java.util.ArrayList;
import java.util.List;

public class HbUserCashExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbUserCashExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserCashIsNull() {
            addCriterion("user_cash is null");
            return (Criteria) this;
        }

        public Criteria andUserCashIsNotNull() {
            addCriterion("user_cash is not null");
            return (Criteria) this;
        }

        public Criteria andUserCashEqualTo(Double value) {
            addCriterion("user_cash =", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashNotEqualTo(Double value) {
            addCriterion("user_cash <>", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashGreaterThan(Double value) {
            addCriterion("user_cash >", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashGreaterThanOrEqualTo(Double value) {
            addCriterion("user_cash >=", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashLessThan(Double value) {
            addCriterion("user_cash <", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashLessThanOrEqualTo(Double value) {
            addCriterion("user_cash <=", value, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashIn(List<Double> values) {
            addCriterion("user_cash in", values, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashNotIn(List<Double> values) {
            addCriterion("user_cash not in", values, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashBetween(Double value1, Double value2) {
            addCriterion("user_cash between", value1, value2, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashNotBetween(Double value1, Double value2) {
            addCriterion("user_cash not between", value1, value2, "userCash");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeIsNull() {
            addCriterion("user_cash_type is null");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeIsNotNull() {
            addCriterion("user_cash_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeEqualTo(Integer value) {
            addCriterion("user_cash_type =", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeNotEqualTo(Integer value) {
            addCriterion("user_cash_type <>", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeGreaterThan(Integer value) {
            addCriterion("user_cash_type >", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_cash_type >=", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeLessThan(Integer value) {
            addCriterion("user_cash_type <", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_cash_type <=", value, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeIn(List<Integer> values) {
            addCriterion("user_cash_type in", values, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeNotIn(List<Integer> values) {
            addCriterion("user_cash_type not in", values, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_cash_type between", value1, value2, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_cash_type not between", value1, value2, "userCashType");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusIsNull() {
            addCriterion("user_cash_status is null");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusIsNotNull() {
            addCriterion("user_cash_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusEqualTo(Integer value) {
            addCriterion("user_cash_status =", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusNotEqualTo(Integer value) {
            addCriterion("user_cash_status <>", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusGreaterThan(Integer value) {
            addCriterion("user_cash_status >", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_cash_status >=", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusLessThan(Integer value) {
            addCriterion("user_cash_status <", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_cash_status <=", value, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusIn(List<Integer> values) {
            addCriterion("user_cash_status in", values, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusNotIn(List<Integer> values) {
            addCriterion("user_cash_status not in", values, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_cash_status between", value1, value2, "userCashStatus");
            return (Criteria) this;
        }

        public Criteria andUserCashStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_cash_status not between", value1, value2, "userCashStatus");
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