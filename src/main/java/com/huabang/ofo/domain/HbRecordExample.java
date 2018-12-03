package com.huabang.ofo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HbRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbRecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordUseridIsNull() {
            addCriterion("record_userid is null");
            return (Criteria) this;
        }

        public Criteria andRecordUseridIsNotNull() {
            addCriterion("record_userid is not null");
            return (Criteria) this;
        }

        public Criteria andRecordUseridEqualTo(Integer value) {
            addCriterion("record_userid =", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridNotEqualTo(Integer value) {
            addCriterion("record_userid <>", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridGreaterThan(Integer value) {
            addCriterion("record_userid >", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_userid >=", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridLessThan(Integer value) {
            addCriterion("record_userid <", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridLessThanOrEqualTo(Integer value) {
            addCriterion("record_userid <=", value, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridIn(List<Integer> values) {
            addCriterion("record_userid in", values, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridNotIn(List<Integer> values) {
            addCriterion("record_userid not in", values, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridBetween(Integer value1, Integer value2) {
            addCriterion("record_userid between", value1, value2, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("record_userid not between", value1, value2, "recordUserid");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNull() {
            addCriterion("record_type is null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNotNull() {
            addCriterion("record_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeEqualTo(Integer value) {
            addCriterion("record_type =", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotEqualTo(Integer value) {
            addCriterion("record_type <>", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThan(Integer value) {
            addCriterion("record_type >", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_type >=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThan(Integer value) {
            addCriterion("record_type <", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThanOrEqualTo(Integer value) {
            addCriterion("record_type <=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIn(List<Integer> values) {
            addCriterion("record_type in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotIn(List<Integer> values) {
            addCriterion("record_type not in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeBetween(Integer value1, Integer value2) {
            addCriterion("record_type between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_type not between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordMessageIsNull() {
            addCriterion("record_message is null");
            return (Criteria) this;
        }

        public Criteria andRecordMessageIsNotNull() {
            addCriterion("record_message is not null");
            return (Criteria) this;
        }

        public Criteria andRecordMessageEqualTo(String value) {
            addCriterion("record_message =", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageNotEqualTo(String value) {
            addCriterion("record_message <>", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageGreaterThan(String value) {
            addCriterion("record_message >", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageGreaterThanOrEqualTo(String value) {
            addCriterion("record_message >=", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageLessThan(String value) {
            addCriterion("record_message <", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageLessThanOrEqualTo(String value) {
            addCriterion("record_message <=", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageLike(String value) {
            addCriterion("record_message like", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageNotLike(String value) {
            addCriterion("record_message not like", value, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageIn(List<String> values) {
            addCriterion("record_message in", values, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageNotIn(List<String> values) {
            addCriterion("record_message not in", values, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageBetween(String value1, String value2) {
            addCriterion("record_message between", value1, value2, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordMessageNotBetween(String value1, String value2) {
            addCriterion("record_message not between", value1, value2, "recordMessage");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeIsNull() {
            addCriterion("record_createtime is null");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeIsNotNull() {
            addCriterion("record_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeEqualTo(Date value) {
            addCriterion("record_createtime =", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeNotEqualTo(Date value) {
            addCriterion("record_createtime <>", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeGreaterThan(Date value) {
            addCriterion("record_createtime >", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_createtime >=", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeLessThan(Date value) {
            addCriterion("record_createtime <", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("record_createtime <=", value, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeIn(List<Date> values) {
            addCriterion("record_createtime in", values, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeNotIn(List<Date> values) {
            addCriterion("record_createtime not in", values, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeBetween(Date value1, Date value2) {
            addCriterion("record_createtime between", value1, value2, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("record_createtime not between", value1, value2, "recordCreatetime");
            return (Criteria) this;
        }

        public Criteria andRecordImageIsNull() {
            addCriterion("record_image is null");
            return (Criteria) this;
        }

        public Criteria andRecordImageIsNotNull() {
            addCriterion("record_image is not null");
            return (Criteria) this;
        }

        public Criteria andRecordImageEqualTo(String value) {
            addCriterion("record_image =", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageNotEqualTo(String value) {
            addCriterion("record_image <>", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageGreaterThan(String value) {
            addCriterion("record_image >", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageGreaterThanOrEqualTo(String value) {
            addCriterion("record_image >=", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageLessThan(String value) {
            addCriterion("record_image <", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageLessThanOrEqualTo(String value) {
            addCriterion("record_image <=", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageLike(String value) {
            addCriterion("record_image like", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageNotLike(String value) {
            addCriterion("record_image not like", value, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageIn(List<String> values) {
            addCriterion("record_image in", values, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageNotIn(List<String> values) {
            addCriterion("record_image not in", values, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageBetween(String value1, String value2) {
            addCriterion("record_image between", value1, value2, "recordImage");
            return (Criteria) this;
        }

        public Criteria andRecordImageNotBetween(String value1, String value2) {
            addCriterion("record_image not between", value1, value2, "recordImage");
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