package com.huabang.ofo.domain;

import java.util.ArrayList;
import java.util.List;

public class HbAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbAccountExample() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdIsNull() {
            addCriterion("account_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdIsNotNull() {
            addCriterion("account_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdEqualTo(String value) {
            addCriterion("account_user_id =", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdNotEqualTo(String value) {
            addCriterion("account_user_id <>", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdGreaterThan(String value) {
            addCriterion("account_user_id >", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_user_id >=", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdLessThan(String value) {
            addCriterion("account_user_id <", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdLessThanOrEqualTo(String value) {
            addCriterion("account_user_id <=", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdLike(String value) {
            addCriterion("account_user_id like", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdNotLike(String value) {
            addCriterion("account_user_id not like", value, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdIn(List<String> values) {
            addCriterion("account_user_id in", values, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdNotIn(List<String> values) {
            addCriterion("account_user_id not in", values, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdBetween(String value1, String value2) {
            addCriterion("account_user_id between", value1, value2, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountUserIdNotBetween(String value1, String value2) {
            addCriterion("account_user_id not between", value1, value2, "accountUserId");
            return (Criteria) this;
        }

        public Criteria andAccountTotelIsNull() {
            addCriterion("account_totel is null");
            return (Criteria) this;
        }

        public Criteria andAccountTotelIsNotNull() {
            addCriterion("account_totel is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTotelEqualTo(String value) {
            addCriterion("account_totel =", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelNotEqualTo(String value) {
            addCriterion("account_totel <>", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelGreaterThan(String value) {
            addCriterion("account_totel >", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelGreaterThanOrEqualTo(String value) {
            addCriterion("account_totel >=", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelLessThan(String value) {
            addCriterion("account_totel <", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelLessThanOrEqualTo(String value) {
            addCriterion("account_totel <=", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelLike(String value) {
            addCriterion("account_totel like", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelNotLike(String value) {
            addCriterion("account_totel not like", value, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelIn(List<String> values) {
            addCriterion("account_totel in", values, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelNotIn(List<String> values) {
            addCriterion("account_totel not in", values, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelBetween(String value1, String value2) {
            addCriterion("account_totel between", value1, value2, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountTotelNotBetween(String value1, String value2) {
            addCriterion("account_totel not between", value1, value2, "accountTotel");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(Integer value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(Integer value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(Integer value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(Integer value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<Integer> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<Integer> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(Integer value1, Integer value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountPayIsNull() {
            addCriterion("account_pay is null");
            return (Criteria) this;
        }

        public Criteria andAccountPayIsNotNull() {
            addCriterion("account_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPayEqualTo(Double value) {
            addCriterion("account_pay =", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotEqualTo(Double value) {
            addCriterion("account_pay <>", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayGreaterThan(Double value) {
            addCriterion("account_pay >", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayGreaterThanOrEqualTo(Double value) {
            addCriterion("account_pay >=", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayLessThan(Double value) {
            addCriterion("account_pay <", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayLessThanOrEqualTo(Double value) {
            addCriterion("account_pay <=", value, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayIn(List<Double> values) {
            addCriterion("account_pay in", values, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotIn(List<Double> values) {
            addCriterion("account_pay not in", values, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayBetween(Double value1, Double value2) {
            addCriterion("account_pay between", value1, value2, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPayNotBetween(Double value1, Double value2) {
            addCriterion("account_pay not between", value1, value2, "accountPay");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedIsNull() {
            addCriterion("\" account_presented\" is null");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedIsNotNull() {
            addCriterion("\" account_presented\" is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedEqualTo(Double value) {
            addCriterion("\" account_presented\" =", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedNotEqualTo(Double value) {
            addCriterion("\" account_presented\" <>", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedGreaterThan(Double value) {
            addCriterion("\" account_presented\" >", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedGreaterThanOrEqualTo(Double value) {
            addCriterion("\" account_presented\" >=", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedLessThan(Double value) {
            addCriterion("\" account_presented\" <", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedLessThanOrEqualTo(Double value) {
            addCriterion("\" account_presented\" <=", value, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedIn(List<Double> values) {
            addCriterion("\" account_presented\" in", values, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedNotIn(List<Double> values) {
            addCriterion("\" account_presented\" not in", values, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedBetween(Double value1, Double value2) {
            addCriterion("\" account_presented\" between", value1, value2, "accountPresented");
            return (Criteria) this;
        }

        public Criteria andAccountPresentedNotBetween(Double value1, Double value2) {
            addCriterion("\" account_presented\" not between", value1, value2, "accountPresented");
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