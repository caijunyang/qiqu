package com.bootdo.ofo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HbJourneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbJourneyExample() {
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

        public Criteria andJourneyIdIsNull() {
            addCriterion("journey_id is null");
            return (Criteria) this;
        }

        public Criteria andJourneyIdIsNotNull() {
            addCriterion("journey_id is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyIdEqualTo(String value) {
            addCriterion("journey_id =", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdNotEqualTo(String value) {
            addCriterion("journey_id <>", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdGreaterThan(String value) {
            addCriterion("journey_id >", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdGreaterThanOrEqualTo(String value) {
            addCriterion("journey_id >=", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdLessThan(String value) {
            addCriterion("journey_id <", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdLessThanOrEqualTo(String value) {
            addCriterion("journey_id <=", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdLike(String value) {
            addCriterion("journey_id like", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdNotLike(String value) {
            addCriterion("journey_id not like", value, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdIn(List<String> values) {
            addCriterion("journey_id in", values, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdNotIn(List<String> values) {
            addCriterion("journey_id not in", values, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdBetween(String value1, String value2) {
            addCriterion("journey_id between", value1, value2, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyIdNotBetween(String value1, String value2) {
            addCriterion("journey_id not between", value1, value2, "journeyId");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridIsNull() {
            addCriterion("journey_userid is null");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridIsNotNull() {
            addCriterion("journey_userid is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridEqualTo(String value) {
            addCriterion("journey_userid =", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridNotEqualTo(String value) {
            addCriterion("journey_userid <>", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridGreaterThan(String value) {
            addCriterion("journey_userid >", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridGreaterThanOrEqualTo(String value) {
            addCriterion("journey_userid >=", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridLessThan(String value) {
            addCriterion("journey_userid <", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridLessThanOrEqualTo(String value) {
            addCriterion("journey_userid <=", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridLike(String value) {
            addCriterion("journey_userid like", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridNotLike(String value) {
            addCriterion("journey_userid not like", value, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridIn(List<String> values) {
            addCriterion("journey_userid in", values, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridNotIn(List<String> values) {
            addCriterion("journey_userid not in", values, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridBetween(String value1, String value2) {
            addCriterion("journey_userid between", value1, value2, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyUseridNotBetween(String value1, String value2) {
            addCriterion("journey_userid not between", value1, value2, "journeyUserid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidIsNull() {
            addCriterion("journey_shareid is null");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidIsNotNull() {
            addCriterion("journey_shareid is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidEqualTo(String value) {
            addCriterion("journey_shareid =", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidNotEqualTo(String value) {
            addCriterion("journey_shareid <>", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidGreaterThan(String value) {
            addCriterion("journey_shareid >", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidGreaterThanOrEqualTo(String value) {
            addCriterion("journey_shareid >=", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidLessThan(String value) {
            addCriterion("journey_shareid <", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidLessThanOrEqualTo(String value) {
            addCriterion("journey_shareid <=", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidLike(String value) {
            addCriterion("journey_shareid like", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidNotLike(String value) {
            addCriterion("journey_shareid not like", value, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidIn(List<String> values) {
            addCriterion("journey_shareid in", values, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidNotIn(List<String> values) {
            addCriterion("journey_shareid not in", values, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidBetween(String value1, String value2) {
            addCriterion("journey_shareid between", value1, value2, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyShareidNotBetween(String value1, String value2) {
            addCriterion("journey_shareid not between", value1, value2, "journeyShareid");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeIsNull() {
            addCriterion("journey_time is null");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeIsNotNull() {
            addCriterion("journey_time is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeEqualTo(Integer value) {
            addCriterion("journey_time =", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeNotEqualTo(Integer value) {
            addCriterion("journey_time <>", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeGreaterThan(Integer value) {
            addCriterion("journey_time >", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("journey_time >=", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeLessThan(Integer value) {
            addCriterion("journey_time <", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeLessThanOrEqualTo(Integer value) {
            addCriterion("journey_time <=", value, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeIn(List<Integer> values) {
            addCriterion("journey_time in", values, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeNotIn(List<Integer> values) {
            addCriterion("journey_time not in", values, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeBetween(Integer value1, Integer value2) {
            addCriterion("journey_time between", value1, value2, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("journey_time not between", value1, value2, "journeyTime");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyIsNull() {
            addCriterion("journey_money is null");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyIsNotNull() {
            addCriterion("journey_money is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyEqualTo(Double value) {
            addCriterion("journey_money =", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyNotEqualTo(Double value) {
            addCriterion("journey_money <>", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyGreaterThan(Double value) {
            addCriterion("journey_money >", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("journey_money >=", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyLessThan(Double value) {
            addCriterion("journey_money <", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyLessThanOrEqualTo(Double value) {
            addCriterion("journey_money <=", value, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyIn(List<Double> values) {
            addCriterion("journey_money in", values, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyNotIn(List<Double> values) {
            addCriterion("journey_money not in", values, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyBetween(Double value1, Double value2) {
            addCriterion("journey_money between", value1, value2, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyMoneyNotBetween(Double value1, Double value2) {
            addCriterion("journey_money not between", value1, value2, "journeyMoney");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceIsNull() {
            addCriterion("journey_distance is null");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceIsNotNull() {
            addCriterion("journey_distance is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceEqualTo(Double value) {
            addCriterion("journey_distance =", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceNotEqualTo(Double value) {
            addCriterion("journey_distance <>", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceGreaterThan(Double value) {
            addCriterion("journey_distance >", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceGreaterThanOrEqualTo(Double value) {
            addCriterion("journey_distance >=", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceLessThan(Double value) {
            addCriterion("journey_distance <", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceLessThanOrEqualTo(Double value) {
            addCriterion("journey_distance <=", value, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceIn(List<Double> values) {
            addCriterion("journey_distance in", values, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceNotIn(List<Double> values) {
            addCriterion("journey_distance not in", values, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceBetween(Double value1, Double value2) {
            addCriterion("journey_distance between", value1, value2, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyDistanceNotBetween(Double value1, Double value2) {
            addCriterion("journey_distance not between", value1, value2, "journeyDistance");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotIsNull() {
            addCriterion("journey_startpot is null");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotIsNotNull() {
            addCriterion("journey_startpot is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotEqualTo(String value) {
            addCriterion("journey_startpot =", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotNotEqualTo(String value) {
            addCriterion("journey_startpot <>", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotGreaterThan(String value) {
            addCriterion("journey_startpot >", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotGreaterThanOrEqualTo(String value) {
            addCriterion("journey_startpot >=", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotLessThan(String value) {
            addCriterion("journey_startpot <", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotLessThanOrEqualTo(String value) {
            addCriterion("journey_startpot <=", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotLike(String value) {
            addCriterion("journey_startpot like", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotNotLike(String value) {
            addCriterion("journey_startpot not like", value, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotIn(List<String> values) {
            addCriterion("journey_startpot in", values, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotNotIn(List<String> values) {
            addCriterion("journey_startpot not in", values, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotBetween(String value1, String value2) {
            addCriterion("journey_startpot between", value1, value2, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyStartpotNotBetween(String value1, String value2) {
            addCriterion("journey_startpot not between", value1, value2, "journeyStartpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotIsNull() {
            addCriterion("journey_endpot is null");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotIsNotNull() {
            addCriterion("journey_endpot is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotEqualTo(String value) {
            addCriterion("journey_endpot =", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotNotEqualTo(String value) {
            addCriterion("journey_endpot <>", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotGreaterThan(String value) {
            addCriterion("journey_endpot >", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotGreaterThanOrEqualTo(String value) {
            addCriterion("journey_endpot >=", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotLessThan(String value) {
            addCriterion("journey_endpot <", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotLessThanOrEqualTo(String value) {
            addCriterion("journey_endpot <=", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotLike(String value) {
            addCriterion("journey_endpot like", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotNotLike(String value) {
            addCriterion("journey_endpot not like", value, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotIn(List<String> values) {
            addCriterion("journey_endpot in", values, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotNotIn(List<String> values) {
            addCriterion("journey_endpot not in", values, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotBetween(String value1, String value2) {
            addCriterion("journey_endpot between", value1, value2, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyEndpotNotBetween(String value1, String value2) {
            addCriterion("journey_endpot not between", value1, value2, "journeyEndpot");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeIsNull() {
            addCriterion("journey_createtime is null");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeIsNotNull() {
            addCriterion("journey_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeEqualTo(Date value) {
            addCriterion("journey_createtime =", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeNotEqualTo(Date value) {
            addCriterion("journey_createtime <>", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeGreaterThan(Date value) {
            addCriterion("journey_createtime >", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("journey_createtime >=", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeLessThan(Date value) {
            addCriterion("journey_createtime <", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("journey_createtime <=", value, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeIn(List<Date> values) {
            addCriterion("journey_createtime in", values, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeNotIn(List<Date> values) {
            addCriterion("journey_createtime not in", values, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeBetween(Date value1, Date value2) {
            addCriterion("journey_createtime between", value1, value2, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("journey_createtime not between", value1, value2, "journeyCreatetime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeIsNull() {
            addCriterion("journey_endtime is null");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeIsNotNull() {
            addCriterion("journey_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeEqualTo(Date value) {
            addCriterion("journey_endtime =", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeNotEqualTo(Date value) {
            addCriterion("journey_endtime <>", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeGreaterThan(Date value) {
            addCriterion("journey_endtime >", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("journey_endtime >=", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeLessThan(Date value) {
            addCriterion("journey_endtime <", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("journey_endtime <=", value, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeIn(List<Date> values) {
            addCriterion("journey_endtime in", values, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeNotIn(List<Date> values) {
            addCriterion("journey_endtime not in", values, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeBetween(Date value1, Date value2) {
            addCriterion("journey_endtime between", value1, value2, "journeyEndtime");
            return (Criteria) this;
        }

        public Criteria andJourneyEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("journey_endtime not between", value1, value2, "journeyEndtime");
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