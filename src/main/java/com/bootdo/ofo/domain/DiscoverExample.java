package com.bootdo.ofo.domain;

import java.util.ArrayList;
import java.util.List;

public class DiscoverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiscoverExample() {
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

        public Criteria andDiscoverIdIsNull() {
            addCriterion("discover_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdIsNotNull() {
            addCriterion("discover_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdEqualTo(String value) {
            addCriterion("discover_id =", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdNotEqualTo(String value) {
            addCriterion("discover_id <>", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdGreaterThan(String value) {
            addCriterion("discover_id >", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("discover_id >=", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdLessThan(String value) {
            addCriterion("discover_id <", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdLessThanOrEqualTo(String value) {
            addCriterion("discover_id <=", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdLike(String value) {
            addCriterion("discover_id like", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdNotLike(String value) {
            addCriterion("discover_id not like", value, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdIn(List<String> values) {
            addCriterion("discover_id in", values, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdNotIn(List<String> values) {
            addCriterion("discover_id not in", values, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdBetween(String value1, String value2) {
            addCriterion("discover_id between", value1, value2, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverIdNotBetween(String value1, String value2) {
            addCriterion("discover_id not between", value1, value2, "discoverId");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleIsNull() {
            addCriterion("discover_title is null");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleIsNotNull() {
            addCriterion("discover_title is not null");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleEqualTo(String value) {
            addCriterion("discover_title =", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleNotEqualTo(String value) {
            addCriterion("discover_title <>", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleGreaterThan(String value) {
            addCriterion("discover_title >", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleGreaterThanOrEqualTo(String value) {
            addCriterion("discover_title >=", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleLessThan(String value) {
            addCriterion("discover_title <", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleLessThanOrEqualTo(String value) {
            addCriterion("discover_title <=", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleLike(String value) {
            addCriterion("discover_title like", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleNotLike(String value) {
            addCriterion("discover_title not like", value, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleIn(List<String> values) {
            addCriterion("discover_title in", values, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleNotIn(List<String> values) {
            addCriterion("discover_title not in", values, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleBetween(String value1, String value2) {
            addCriterion("discover_title between", value1, value2, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverTitleNotBetween(String value1, String value2) {
            addCriterion("discover_title not between", value1, value2, "discoverTitle");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlIsNull() {
            addCriterion("discover_image_url is null");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlIsNotNull() {
            addCriterion("discover_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlEqualTo(String value) {
            addCriterion("discover_image_url =", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlNotEqualTo(String value) {
            addCriterion("discover_image_url <>", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlGreaterThan(String value) {
            addCriterion("discover_image_url >", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("discover_image_url >=", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlLessThan(String value) {
            addCriterion("discover_image_url <", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlLessThanOrEqualTo(String value) {
            addCriterion("discover_image_url <=", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlLike(String value) {
            addCriterion("discover_image_url like", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlNotLike(String value) {
            addCriterion("discover_image_url not like", value, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlIn(List<String> values) {
            addCriterion("discover_image_url in", values, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlNotIn(List<String> values) {
            addCriterion("discover_image_url not in", values, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlBetween(String value1, String value2) {
            addCriterion("discover_image_url between", value1, value2, "discoverImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiscoverImageUrlNotBetween(String value1, String value2) {
            addCriterion("discover_image_url not between", value1, value2, "discoverImageUrl");
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