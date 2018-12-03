package com.huabang.ofo.domain;

import java.util.ArrayList;
import java.util.List;

public class HbImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbImageExample() {
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

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Integer value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Integer value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Integer value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Integer value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Integer> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Integer> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Integer value1, Integer value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImagePicIsNull() {
            addCriterion("image_pic is null");
            return (Criteria) this;
        }

        public Criteria andImagePicIsNotNull() {
            addCriterion("image_pic is not null");
            return (Criteria) this;
        }

        public Criteria andImagePicEqualTo(String value) {
            addCriterion("image_pic =", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicNotEqualTo(String value) {
            addCriterion("image_pic <>", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicGreaterThan(String value) {
            addCriterion("image_pic >", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicGreaterThanOrEqualTo(String value) {
            addCriterion("image_pic >=", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicLessThan(String value) {
            addCriterion("image_pic <", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicLessThanOrEqualTo(String value) {
            addCriterion("image_pic <=", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicLike(String value) {
            addCriterion("image_pic like", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicNotLike(String value) {
            addCriterion("image_pic not like", value, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicIn(List<String> values) {
            addCriterion("image_pic in", values, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicNotIn(List<String> values) {
            addCriterion("image_pic not in", values, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicBetween(String value1, String value2) {
            addCriterion("image_pic between", value1, value2, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImagePicNotBetween(String value1, String value2) {
            addCriterion("image_pic not between", value1, value2, "imagePic");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNull() {
            addCriterion("image_type is null");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNotNull() {
            addCriterion("image_type is not null");
            return (Criteria) this;
        }

        public Criteria andImageTypeEqualTo(String value) {
            addCriterion("image_type =", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotEqualTo(String value) {
            addCriterion("image_type <>", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThan(String value) {
            addCriterion("image_type >", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("image_type >=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThan(String value) {
            addCriterion("image_type <", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThanOrEqualTo(String value) {
            addCriterion("image_type <=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLike(String value) {
            addCriterion("image_type like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotLike(String value) {
            addCriterion("image_type not like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeIn(List<String> values) {
            addCriterion("image_type in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotIn(List<String> values) {
            addCriterion("image_type not in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeBetween(String value1, String value2) {
            addCriterion("image_type between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotBetween(String value1, String value2) {
            addCriterion("image_type not between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageUserIdIsNull() {
            addCriterion("image_user_id is null");
            return (Criteria) this;
        }

        public Criteria andImageUserIdIsNotNull() {
            addCriterion("image_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageUserIdEqualTo(String value) {
            addCriterion("image_user_id =", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdNotEqualTo(String value) {
            addCriterion("image_user_id <>", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdGreaterThan(String value) {
            addCriterion("image_user_id >", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_user_id >=", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdLessThan(String value) {
            addCriterion("image_user_id <", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdLessThanOrEqualTo(String value) {
            addCriterion("image_user_id <=", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdLike(String value) {
            addCriterion("image_user_id like", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdNotLike(String value) {
            addCriterion("image_user_id not like", value, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdIn(List<String> values) {
            addCriterion("image_user_id in", values, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdNotIn(List<String> values) {
            addCriterion("image_user_id not in", values, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdBetween(String value1, String value2) {
            addCriterion("image_user_id between", value1, value2, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageUserIdNotBetween(String value1, String value2) {
            addCriterion("image_user_id not between", value1, value2, "imageUserId");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNull() {
            addCriterion("image_status is null");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNotNull() {
            addCriterion("image_status is not null");
            return (Criteria) this;
        }

        public Criteria andImageStatusEqualTo(Integer value) {
            addCriterion("image_status =", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotEqualTo(Integer value) {
            addCriterion("image_status <>", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThan(Integer value) {
            addCriterion("image_status >", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_status >=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThan(Integer value) {
            addCriterion("image_status <", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("image_status <=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusIn(List<Integer> values) {
            addCriterion("image_status in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotIn(List<Integer> values) {
            addCriterion("image_status not in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusBetween(Integer value1, Integer value2) {
            addCriterion("image_status between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("image_status not between", value1, value2, "imageStatus");
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