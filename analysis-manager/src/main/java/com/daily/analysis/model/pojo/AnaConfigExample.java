package com.daily.analysis.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnaConfigExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public AnaConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
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

        public Criteria andConfIdIsNull() {
            addCriterion("conf_id is null");
            return (Criteria) this;
        }

        public Criteria andConfIdIsNotNull() {
            addCriterion("conf_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfIdEqualTo(Integer value) {
            addCriterion("conf_id =", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdNotEqualTo(Integer value) {
            addCriterion("conf_id <>", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdGreaterThan(Integer value) {
            addCriterion("conf_id >", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("conf_id >=", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdLessThan(Integer value) {
            addCriterion("conf_id <", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdLessThanOrEqualTo(Integer value) {
            addCriterion("conf_id <=", value, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdIn(List<Integer> values) {
            addCriterion("conf_id in", values, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdNotIn(List<Integer> values) {
            addCriterion("conf_id not in", values, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdBetween(Integer value1, Integer value2) {
            addCriterion("conf_id between", value1, value2, "confId");
            return (Criteria) this;
        }

        public Criteria andConfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("conf_id not between", value1, value2, "confId");
            return (Criteria) this;
        }

        public Criteria andServerIpIsNull() {
            addCriterion("server_ip is null");
            return (Criteria) this;
        }

        public Criteria andServerIpIsNotNull() {
            addCriterion("server_ip is not null");
            return (Criteria) this;
        }

        public Criteria andServerIpEqualTo(String value) {
            addCriterion("server_ip =", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotEqualTo(String value) {
            addCriterion("server_ip <>", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpGreaterThan(String value) {
            addCriterion("server_ip >", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("server_ip >=", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLessThan(String value) {
            addCriterion("server_ip <", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLessThanOrEqualTo(String value) {
            addCriterion("server_ip <=", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLike(String value) {
            addCriterion("server_ip like", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotLike(String value) {
            addCriterion("server_ip not like", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpIn(List<String> values) {
            addCriterion("server_ip in", values, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotIn(List<String> values) {
            addCriterion("server_ip not in", values, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpBetween(String value1, String value2) {
            addCriterion("server_ip between", value1, value2, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotBetween(String value1, String value2) {
            addCriterion("server_ip not between", value1, value2, "serverIp");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlIsNull() {
            addCriterion("snort_conf_url is null");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlIsNotNull() {
            addCriterion("snort_conf_url is not null");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlEqualTo(String value) {
            addCriterion("snort_conf_url =", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlNotEqualTo(String value) {
            addCriterion("snort_conf_url <>", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlGreaterThan(String value) {
            addCriterion("snort_conf_url >", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlGreaterThanOrEqualTo(String value) {
            addCriterion("snort_conf_url >=", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlLessThan(String value) {
            addCriterion("snort_conf_url <", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlLessThanOrEqualTo(String value) {
            addCriterion("snort_conf_url <=", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlLike(String value) {
            addCriterion("snort_conf_url like", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlNotLike(String value) {
            addCriterion("snort_conf_url not like", value, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlIn(List<String> values) {
            addCriterion("snort_conf_url in", values, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlNotIn(List<String> values) {
            addCriterion("snort_conf_url not in", values, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlBetween(String value1, String value2) {
            addCriterion("snort_conf_url between", value1, value2, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andSnortConfUrlNotBetween(String value1, String value2) {
            addCriterion("snort_conf_url not between", value1, value2, "snortConfUrl");
            return (Criteria) this;
        }

        public Criteria andServerUsernameIsNull() {
            addCriterion("server_username is null");
            return (Criteria) this;
        }

        public Criteria andServerUsernameIsNotNull() {
            addCriterion("server_username is not null");
            return (Criteria) this;
        }

        public Criteria andServerUsernameEqualTo(String value) {
            addCriterion("server_username =", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameNotEqualTo(String value) {
            addCriterion("server_username <>", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameGreaterThan(String value) {
            addCriterion("server_username >", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("server_username >=", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameLessThan(String value) {
            addCriterion("server_username <", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameLessThanOrEqualTo(String value) {
            addCriterion("server_username <=", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameLike(String value) {
            addCriterion("server_username like", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameNotLike(String value) {
            addCriterion("server_username not like", value, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameIn(List<String> values) {
            addCriterion("server_username in", values, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameNotIn(List<String> values) {
            addCriterion("server_username not in", values, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameBetween(String value1, String value2) {
            addCriterion("server_username between", value1, value2, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerUsernameNotBetween(String value1, String value2) {
            addCriterion("server_username not between", value1, value2, "serverUsername");
            return (Criteria) this;
        }

        public Criteria andServerPasswordIsNull() {
            addCriterion("server_password is null");
            return (Criteria) this;
        }

        public Criteria andServerPasswordIsNotNull() {
            addCriterion("server_password is not null");
            return (Criteria) this;
        }

        public Criteria andServerPasswordEqualTo(String value) {
            addCriterion("server_password =", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordNotEqualTo(String value) {
            addCriterion("server_password <>", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordGreaterThan(String value) {
            addCriterion("server_password >", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("server_password >=", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordLessThan(String value) {
            addCriterion("server_password <", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordLessThanOrEqualTo(String value) {
            addCriterion("server_password <=", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordLike(String value) {
            addCriterion("server_password like", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordNotLike(String value) {
            addCriterion("server_password not like", value, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordIn(List<String> values) {
            addCriterion("server_password in", values, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordNotIn(List<String> values) {
            addCriterion("server_password not in", values, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordBetween(String value1, String value2) {
            addCriterion("server_password between", value1, value2, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerPasswordNotBetween(String value1, String value2) {
            addCriterion("server_password not between", value1, value2, "serverPassword");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNull() {
            addCriterion("server_name is null");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNotNull() {
            addCriterion("server_name is not null");
            return (Criteria) this;
        }

        public Criteria andServerNameEqualTo(String value) {
            addCriterion("server_name =", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("server_name <>", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("server_name >", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("server_name >=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThan(String value) {
            addCriterion("server_name <", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("server_name <=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLike(String value) {
            addCriterion("server_name like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotLike(String value) {
            addCriterion("server_name not like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameIn(List<String> values) {
            addCriterion("server_name in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("server_name not in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("server_name between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("server_name not between", value1, value2, "serverName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ana_config
     *
     * @mbggenerated do_not_delete_during_merge Sat May 23 02:04:57 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ana_config
     *
     * @mbggenerated Sat May 23 02:04:57 CST 2015
     */
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