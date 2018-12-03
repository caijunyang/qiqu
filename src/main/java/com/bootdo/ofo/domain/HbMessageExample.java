package com.bootdo.ofo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HbMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbMessageExample() {
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

        public Criteria andMessIdIsNull() {
            addCriterion("mess_id is null");
            return (Criteria) this;
        }

        public Criteria andMessIdIsNotNull() {
            addCriterion("mess_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessIdEqualTo(Integer value) {
            addCriterion("mess_id =", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdNotEqualTo(Integer value) {
            addCriterion("mess_id <>", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdGreaterThan(Integer value) {
            addCriterion("mess_id >", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mess_id >=", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdLessThan(Integer value) {
            addCriterion("mess_id <", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdLessThanOrEqualTo(Integer value) {
            addCriterion("mess_id <=", value, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdIn(List<Integer> values) {
            addCriterion("mess_id in", values, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdNotIn(List<Integer> values) {
            addCriterion("mess_id not in", values, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdBetween(Integer value1, Integer value2) {
            addCriterion("mess_id between", value1, value2, "messId");
            return (Criteria) this;
        }

        public Criteria andMessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mess_id not between", value1, value2, "messId");
            return (Criteria) this;
        }

        public Criteria andMessNameIsNull() {
            addCriterion("mess_name is null");
            return (Criteria) this;
        }

        public Criteria andMessNameIsNotNull() {
            addCriterion("mess_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessNameEqualTo(String value) {
            addCriterion("mess_name =", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameNotEqualTo(String value) {
            addCriterion("mess_name <>", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameGreaterThan(String value) {
            addCriterion("mess_name >", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameGreaterThanOrEqualTo(String value) {
            addCriterion("mess_name >=", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameLessThan(String value) {
            addCriterion("mess_name <", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameLessThanOrEqualTo(String value) {
            addCriterion("mess_name <=", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameLike(String value) {
            addCriterion("mess_name like", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameNotLike(String value) {
            addCriterion("mess_name not like", value, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameIn(List<String> values) {
            addCriterion("mess_name in", values, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameNotIn(List<String> values) {
            addCriterion("mess_name not in", values, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameBetween(String value1, String value2) {
            addCriterion("mess_name between", value1, value2, "messName");
            return (Criteria) this;
        }

        public Criteria andMessNameNotBetween(String value1, String value2) {
            addCriterion("mess_name not between", value1, value2, "messName");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessIsNull() {
            addCriterion("mess_simpleness is null");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessIsNotNull() {
            addCriterion("mess_simpleness is not null");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessEqualTo(String value) {
            addCriterion("mess_simpleness =", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessNotEqualTo(String value) {
            addCriterion("mess_simpleness <>", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessGreaterThan(String value) {
            addCriterion("mess_simpleness >", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessGreaterThanOrEqualTo(String value) {
            addCriterion("mess_simpleness >=", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessLessThan(String value) {
            addCriterion("mess_simpleness <", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessLessThanOrEqualTo(String value) {
            addCriterion("mess_simpleness <=", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessLike(String value) {
            addCriterion("mess_simpleness like", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessNotLike(String value) {
            addCriterion("mess_simpleness not like", value, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessIn(List<String> values) {
            addCriterion("mess_simpleness in", values, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessNotIn(List<String> values) {
            addCriterion("mess_simpleness not in", values, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessBetween(String value1, String value2) {
            addCriterion("mess_simpleness between", value1, value2, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessSimplenessNotBetween(String value1, String value2) {
            addCriterion("mess_simpleness not between", value1, value2, "messSimpleness");
            return (Criteria) this;
        }

        public Criteria andMessMessageIsNull() {
            addCriterion("mess_message is null");
            return (Criteria) this;
        }

        public Criteria andMessMessageIsNotNull() {
            addCriterion("mess_message is not null");
            return (Criteria) this;
        }

        public Criteria andMessMessageEqualTo(String value) {
            addCriterion("mess_message =", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageNotEqualTo(String value) {
            addCriterion("mess_message <>", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageGreaterThan(String value) {
            addCriterion("mess_message >", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageGreaterThanOrEqualTo(String value) {
            addCriterion("mess_message >=", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageLessThan(String value) {
            addCriterion("mess_message <", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageLessThanOrEqualTo(String value) {
            addCriterion("mess_message <=", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageLike(String value) {
            addCriterion("mess_message like", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageNotLike(String value) {
            addCriterion("mess_message not like", value, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageIn(List<String> values) {
            addCriterion("mess_message in", values, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageNotIn(List<String> values) {
            addCriterion("mess_message not in", values, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageBetween(String value1, String value2) {
            addCriterion("mess_message between", value1, value2, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessMessageNotBetween(String value1, String value2) {
            addCriterion("mess_message not between", value1, value2, "messMessage");
            return (Criteria) this;
        }

        public Criteria andMessDetailsIsNull() {
            addCriterion("mess_details is null");
            return (Criteria) this;
        }

        public Criteria andMessDetailsIsNotNull() {
            addCriterion("mess_details is not null");
            return (Criteria) this;
        }

        public Criteria andMessDetailsEqualTo(String value) {
            addCriterion("mess_details =", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsNotEqualTo(String value) {
            addCriterion("mess_details <>", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsGreaterThan(String value) {
            addCriterion("mess_details >", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("mess_details >=", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsLessThan(String value) {
            addCriterion("mess_details <", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsLessThanOrEqualTo(String value) {
            addCriterion("mess_details <=", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsLike(String value) {
            addCriterion("mess_details like", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsNotLike(String value) {
            addCriterion("mess_details not like", value, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsIn(List<String> values) {
            addCriterion("mess_details in", values, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsNotIn(List<String> values) {
            addCriterion("mess_details not in", values, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsBetween(String value1, String value2) {
            addCriterion("mess_details between", value1, value2, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessDetailsNotBetween(String value1, String value2) {
            addCriterion("mess_details not between", value1, value2, "messDetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsIsNull() {
            addCriterion("mess_jbdetails is null");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsIsNotNull() {
            addCriterion("mess_jbdetails is not null");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsEqualTo(String value) {
            addCriterion("mess_jbdetails =", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsNotEqualTo(String value) {
            addCriterion("mess_jbdetails <>", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsGreaterThan(String value) {
            addCriterion("mess_jbdetails >", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsGreaterThanOrEqualTo(String value) {
            addCriterion("mess_jbdetails >=", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsLessThan(String value) {
            addCriterion("mess_jbdetails <", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsLessThanOrEqualTo(String value) {
            addCriterion("mess_jbdetails <=", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsLike(String value) {
            addCriterion("mess_jbdetails like", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsNotLike(String value) {
            addCriterion("mess_jbdetails not like", value, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsIn(List<String> values) {
            addCriterion("mess_jbdetails in", values, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsNotIn(List<String> values) {
            addCriterion("mess_jbdetails not in", values, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsBetween(String value1, String value2) {
            addCriterion("mess_jbdetails between", value1, value2, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessJbdetailsNotBetween(String value1, String value2) {
            addCriterion("mess_jbdetails not between", value1, value2, "messJbdetails");
            return (Criteria) this;
        }

        public Criteria andMessPoliceIsNull() {
            addCriterion("mess_police is null");
            return (Criteria) this;
        }

        public Criteria andMessPoliceIsNotNull() {
            addCriterion("mess_police is not null");
            return (Criteria) this;
        }

        public Criteria andMessPoliceEqualTo(String value) {
            addCriterion("mess_police =", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceNotEqualTo(String value) {
            addCriterion("mess_police <>", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceGreaterThan(String value) {
            addCriterion("mess_police >", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceGreaterThanOrEqualTo(String value) {
            addCriterion("mess_police >=", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceLessThan(String value) {
            addCriterion("mess_police <", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceLessThanOrEqualTo(String value) {
            addCriterion("mess_police <=", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceLike(String value) {
            addCriterion("mess_police like", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceNotLike(String value) {
            addCriterion("mess_police not like", value, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceIn(List<String> values) {
            addCriterion("mess_police in", values, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceNotIn(List<String> values) {
            addCriterion("mess_police not in", values, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceBetween(String value1, String value2) {
            addCriterion("mess_police between", value1, value2, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPoliceNotBetween(String value1, String value2) {
            addCriterion("mess_police not between", value1, value2, "messPolice");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneIsNull() {
            addCriterion("mess_police_phone is null");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneIsNotNull() {
            addCriterion("mess_police_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneEqualTo(Integer value) {
            addCriterion("mess_police_phone =", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneNotEqualTo(Integer value) {
            addCriterion("mess_police_phone <>", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneGreaterThan(Integer value) {
            addCriterion("mess_police_phone >", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("mess_police_phone >=", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneLessThan(Integer value) {
            addCriterion("mess_police_phone <", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneLessThanOrEqualTo(Integer value) {
            addCriterion("mess_police_phone <=", value, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneIn(List<Integer> values) {
            addCriterion("mess_police_phone in", values, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneNotIn(List<Integer> values) {
            addCriterion("mess_police_phone not in", values, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneBetween(Integer value1, Integer value2) {
            addCriterion("mess_police_phone between", value1, value2, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessPolicePhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("mess_police_phone not between", value1, value2, "messPolicePhone");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeIsNull() {
            addCriterion("mess_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeIsNotNull() {
            addCriterion("mess_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeEqualTo(Date value) {
            addCriterion("mess_createtime =", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeNotEqualTo(Date value) {
            addCriterion("mess_createtime <>", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeGreaterThan(Date value) {
            addCriterion("mess_createtime >", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mess_createtime >=", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeLessThan(Date value) {
            addCriterion("mess_createtime <", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("mess_createtime <=", value, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeIn(List<Date> values) {
            addCriterion("mess_createtime in", values, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeNotIn(List<Date> values) {
            addCriterion("mess_createtime not in", values, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeBetween(Date value1, Date value2) {
            addCriterion("mess_createtime between", value1, value2, "messCreatetime");
            return (Criteria) this;
        }

        public Criteria andMessCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("mess_createtime not between", value1, value2, "messCreatetime");
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