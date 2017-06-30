package com.framework.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IndexConfigWhere {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexConfigWhere() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andIndexTitleIsNull() {
            addCriterion("index_title is null");
            return (Criteria) this;
        }

        public Criteria andIndexTitleIsNotNull() {
            addCriterion("index_title is not null");
            return (Criteria) this;
        }

        public Criteria andIndexTitleEqualTo(String value) {
            addCriterion("index_title =", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleNotEqualTo(String value) {
            addCriterion("index_title <>", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleGreaterThan(String value) {
            addCriterion("index_title >", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleGreaterThanOrEqualTo(String value) {
            addCriterion("index_title >=", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleLessThan(String value) {
            addCriterion("index_title <", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleLessThanOrEqualTo(String value) {
            addCriterion("index_title <=", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleLike(String value) {
            addCriterion("index_title like", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleNotLike(String value) {
            addCriterion("index_title not like", value, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleIn(List<String> values) {
            addCriterion("index_title in", values, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleNotIn(List<String> values) {
            addCriterion("index_title not in", values, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleBetween(String value1, String value2) {
            addCriterion("index_title between", value1, value2, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andIndexTitleNotBetween(String value1, String value2) {
            addCriterion("index_title not between", value1, value2, "indexTitle");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNull() {
            addCriterion("page_size is null");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNotNull() {
            addCriterion("page_size is not null");
            return (Criteria) this;
        }

        public Criteria andPageSizeEqualTo(Integer value) {
            addCriterion("page_size =", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotEqualTo(Integer value) {
            addCriterion("page_size <>", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThan(Integer value) {
            addCriterion("page_size >", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_size >=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThan(Integer value) {
            addCriterion("page_size <", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThanOrEqualTo(Integer value) {
            addCriterion("page_size <=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeIn(List<Integer> values) {
            addCriterion("page_size in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotIn(List<Integer> values) {
            addCriterion("page_size not in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeBetween(Integer value1, Integer value2) {
            addCriterion("page_size between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("page_size not between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andRestUrlIsNull() {
            addCriterion("rest_url is null");
            return (Criteria) this;
        }

        public Criteria andRestUrlIsNotNull() {
            addCriterion("rest_url is not null");
            return (Criteria) this;
        }

        public Criteria andRestUrlEqualTo(String value) {
            addCriterion("rest_url =", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotEqualTo(String value) {
            addCriterion("rest_url <>", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlGreaterThan(String value) {
            addCriterion("rest_url >", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rest_url >=", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLessThan(String value) {
            addCriterion("rest_url <", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLessThanOrEqualTo(String value) {
            addCriterion("rest_url <=", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlLike(String value) {
            addCriterion("rest_url like", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotLike(String value) {
            addCriterion("rest_url not like", value, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlIn(List<String> values) {
            addCriterion("rest_url in", values, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotIn(List<String> values) {
            addCriterion("rest_url not in", values, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlBetween(String value1, String value2) {
            addCriterion("rest_url between", value1, value2, "restUrl");
            return (Criteria) this;
        }

        public Criteria andRestUrlNotBetween(String value1, String value2) {
            addCriterion("rest_url not between", value1, value2, "restUrl");
            return (Criteria) this;
        }

        public Criteria andGridConfigIsNull() {
            addCriterion("grid_config is null");
            return (Criteria) this;
        }

        public Criteria andGridConfigIsNotNull() {
            addCriterion("grid_config is not null");
            return (Criteria) this;
        }

        public Criteria andGridConfigEqualTo(String value) {
            addCriterion("grid_config =", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotEqualTo(String value) {
            addCriterion("grid_config <>", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigGreaterThan(String value) {
            addCriterion("grid_config >", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigGreaterThanOrEqualTo(String value) {
            addCriterion("grid_config >=", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLessThan(String value) {
            addCriterion("grid_config <", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLessThanOrEqualTo(String value) {
            addCriterion("grid_config <=", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLike(String value) {
            addCriterion("grid_config like", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotLike(String value) {
            addCriterion("grid_config not like", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigIn(List<String> values) {
            addCriterion("grid_config in", values, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotIn(List<String> values) {
            addCriterion("grid_config not in", values, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigBetween(String value1, String value2) {
            addCriterion("grid_config between", value1, value2, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotBetween(String value1, String value2) {
            addCriterion("grid_config not between", value1, value2, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigIsNull() {
            addCriterion("add_config is null");
            return (Criteria) this;
        }

        public Criteria andAddConfigIsNotNull() {
            addCriterion("add_config is not null");
            return (Criteria) this;
        }

        public Criteria andAddConfigEqualTo(String value) {
            addCriterion("add_config =", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigNotEqualTo(String value) {
            addCriterion("add_config <>", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigGreaterThan(String value) {
            addCriterion("add_config >", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigGreaterThanOrEqualTo(String value) {
            addCriterion("add_config >=", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigLessThan(String value) {
            addCriterion("add_config <", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigLessThanOrEqualTo(String value) {
            addCriterion("add_config <=", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigLike(String value) {
            addCriterion("add_config like", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigNotLike(String value) {
            addCriterion("add_config not like", value, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigIn(List<String> values) {
            addCriterion("add_config in", values, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigNotIn(List<String> values) {
            addCriterion("add_config not in", values, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigBetween(String value1, String value2) {
            addCriterion("add_config between", value1, value2, "addConfig");
            return (Criteria) this;
        }

        public Criteria andAddConfigNotBetween(String value1, String value2) {
            addCriterion("add_config not between", value1, value2, "addConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigIsNull() {
            addCriterion("update_config is null");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigIsNotNull() {
            addCriterion("update_config is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigEqualTo(String value) {
            addCriterion("update_config =", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigNotEqualTo(String value) {
            addCriterion("update_config <>", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigGreaterThan(String value) {
            addCriterion("update_config >", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigGreaterThanOrEqualTo(String value) {
            addCriterion("update_config >=", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigLessThan(String value) {
            addCriterion("update_config <", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigLessThanOrEqualTo(String value) {
            addCriterion("update_config <=", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigLike(String value) {
            addCriterion("update_config like", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigNotLike(String value) {
            addCriterion("update_config not like", value, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigIn(List<String> values) {
            addCriterion("update_config in", values, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigNotIn(List<String> values) {
            addCriterion("update_config not in", values, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigBetween(String value1, String value2) {
            addCriterion("update_config between", value1, value2, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andUpdateConfigNotBetween(String value1, String value2) {
            addCriterion("update_config not between", value1, value2, "updateConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigIsNull() {
            addCriterion("view_config is null");
            return (Criteria) this;
        }

        public Criteria andViewConfigIsNotNull() {
            addCriterion("view_config is not null");
            return (Criteria) this;
        }

        public Criteria andViewConfigEqualTo(String value) {
            addCriterion("view_config =", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigNotEqualTo(String value) {
            addCriterion("view_config <>", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigGreaterThan(String value) {
            addCriterion("view_config >", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigGreaterThanOrEqualTo(String value) {
            addCriterion("view_config >=", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigLessThan(String value) {
            addCriterion("view_config <", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigLessThanOrEqualTo(String value) {
            addCriterion("view_config <=", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigLike(String value) {
            addCriterion("view_config like", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigNotLike(String value) {
            addCriterion("view_config not like", value, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigIn(List<String> values) {
            addCriterion("view_config in", values, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigNotIn(List<String> values) {
            addCriterion("view_config not in", values, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigBetween(String value1, String value2) {
            addCriterion("view_config between", value1, value2, "viewConfig");
            return (Criteria) this;
        }

        public Criteria andViewConfigNotBetween(String value1, String value2) {
            addCriterion("view_config not between", value1, value2, "viewConfig");
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
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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