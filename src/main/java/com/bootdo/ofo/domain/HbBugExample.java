package com.bootdo.ofo.domain;

import java.util.ArrayList;
import java.util.List;

public class HbBugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbBugExample() {
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

        public Criteria andBugIdIsNull() {
            addCriterion("bug_id is null");
            return (Criteria) this;
        }

        public Criteria andBugIdIsNotNull() {
            addCriterion("bug_id is not null");
            return (Criteria) this;
        }

        public Criteria andBugIdEqualTo(Integer value) {
            addCriterion("bug_id =", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdNotEqualTo(Integer value) {
            addCriterion("bug_id <>", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdGreaterThan(Integer value) {
            addCriterion("bug_id >", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bug_id >=", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdLessThan(Integer value) {
            addCriterion("bug_id <", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdLessThanOrEqualTo(Integer value) {
            addCriterion("bug_id <=", value, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdIn(List<Integer> values) {
            addCriterion("bug_id in", values, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdNotIn(List<Integer> values) {
            addCriterion("bug_id not in", values, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdBetween(Integer value1, Integer value2) {
            addCriterion("bug_id between", value1, value2, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bug_id not between", value1, value2, "bugId");
            return (Criteria) this;
        }

        public Criteria andBugParentidIsNull() {
            addCriterion("bug_parentid is null");
            return (Criteria) this;
        }

        public Criteria andBugParentidIsNotNull() {
            addCriterion("bug_parentid is not null");
            return (Criteria) this;
        }

        public Criteria andBugParentidEqualTo(Integer value) {
            addCriterion("bug_parentid =", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidNotEqualTo(Integer value) {
            addCriterion("bug_parentid <>", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidGreaterThan(Integer value) {
            addCriterion("bug_parentid >", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bug_parentid >=", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidLessThan(Integer value) {
            addCriterion("bug_parentid <", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidLessThanOrEqualTo(Integer value) {
            addCriterion("bug_parentid <=", value, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidIn(List<Integer> values) {
            addCriterion("bug_parentid in", values, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidNotIn(List<Integer> values) {
            addCriterion("bug_parentid not in", values, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidBetween(Integer value1, Integer value2) {
            addCriterion("bug_parentid between", value1, value2, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("bug_parentid not between", value1, value2, "bugParentid");
            return (Criteria) this;
        }

        public Criteria andBugNameIsNull() {
            addCriterion("bug_name is null");
            return (Criteria) this;
        }

        public Criteria andBugNameIsNotNull() {
            addCriterion("bug_name is not null");
            return (Criteria) this;
        }

        public Criteria andBugNameEqualTo(String value) {
            addCriterion("bug_name =", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameNotEqualTo(String value) {
            addCriterion("bug_name <>", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameGreaterThan(String value) {
            addCriterion("bug_name >", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameGreaterThanOrEqualTo(String value) {
            addCriterion("bug_name >=", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameLessThan(String value) {
            addCriterion("bug_name <", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameLessThanOrEqualTo(String value) {
            addCriterion("bug_name <=", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameLike(String value) {
            addCriterion("bug_name like", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameNotLike(String value) {
            addCriterion("bug_name not like", value, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameIn(List<String> values) {
            addCriterion("bug_name in", values, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameNotIn(List<String> values) {
            addCriterion("bug_name not in", values, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameBetween(String value1, String value2) {
            addCriterion("bug_name between", value1, value2, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugNameNotBetween(String value1, String value2) {
            addCriterion("bug_name not between", value1, value2, "bugName");
            return (Criteria) this;
        }

        public Criteria andBugAnswerIsNull() {
            addCriterion("bug_answer is null");
            return (Criteria) this;
        }

        public Criteria andBugAnswerIsNotNull() {
            addCriterion("bug_answer is not null");
            return (Criteria) this;
        }

        public Criteria andBugAnswerEqualTo(String value) {
            addCriterion("bug_answer =", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerNotEqualTo(String value) {
            addCriterion("bug_answer <>", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerGreaterThan(String value) {
            addCriterion("bug_answer >", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("bug_answer >=", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerLessThan(String value) {
            addCriterion("bug_answer <", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerLessThanOrEqualTo(String value) {
            addCriterion("bug_answer <=", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerLike(String value) {
            addCriterion("bug_answer like", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerNotLike(String value) {
            addCriterion("bug_answer not like", value, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerIn(List<String> values) {
            addCriterion("bug_answer in", values, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerNotIn(List<String> values) {
            addCriterion("bug_answer not in", values, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerBetween(String value1, String value2) {
            addCriterion("bug_answer between", value1, value2, "bugAnswer");
            return (Criteria) this;
        }

        public Criteria andBugAnswerNotBetween(String value1, String value2) {
            addCriterion("bug_answer not between", value1, value2, "bugAnswer");
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