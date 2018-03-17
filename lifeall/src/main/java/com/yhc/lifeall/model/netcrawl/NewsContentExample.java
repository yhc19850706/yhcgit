package com.yhc.lifeall.model.netcrawl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsContentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdIsNull() {
            addCriterion("WEBSITE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdIsNotNull() {
            addCriterion("WEBSITE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdEqualTo(Long value) {
            addCriterion("WEBSITE_ID =", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotEqualTo(Long value) {
            addCriterion("WEBSITE_ID <>", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdGreaterThan(Long value) {
            addCriterion("WEBSITE_ID >", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WEBSITE_ID >=", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdLessThan(Long value) {
            addCriterion("WEBSITE_ID <", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdLessThanOrEqualTo(Long value) {
            addCriterion("WEBSITE_ID <=", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdIn(List<Long> values) {
            addCriterion("WEBSITE_ID in", values, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotIn(List<Long> values) {
            addCriterion("WEBSITE_ID not in", values, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdBetween(Long value1, Long value2) {
            addCriterion("WEBSITE_ID between", value1, value2, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotBetween(Long value1, Long value2) {
            addCriterion("WEBSITE_ID not between", value1, value2, "websiteId");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlIsNull() {
            addCriterion("CRAWL_URL is null");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlIsNotNull() {
            addCriterion("CRAWL_URL is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlEqualTo(String value) {
            addCriterion("CRAWL_URL =", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlNotEqualTo(String value) {
            addCriterion("CRAWL_URL <>", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlGreaterThan(String value) {
            addCriterion("CRAWL_URL >", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("CRAWL_URL >=", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlLessThan(String value) {
            addCriterion("CRAWL_URL <", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlLessThanOrEqualTo(String value) {
            addCriterion("CRAWL_URL <=", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlLike(String value) {
            addCriterion("CRAWL_URL like", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlNotLike(String value) {
            addCriterion("CRAWL_URL not like", value, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlIn(List<String> values) {
            addCriterion("CRAWL_URL in", values, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlNotIn(List<String> values) {
            addCriterion("CRAWL_URL not in", values, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlBetween(String value1, String value2) {
            addCriterion("CRAWL_URL between", value1, value2, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlUrlNotBetween(String value1, String value2) {
            addCriterion("CRAWL_URL not between", value1, value2, "crawlUrl");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNull() {
            addCriterion("NEWS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNotNull() {
            addCriterion("NEWS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNewsNameEqualTo(String value) {
            addCriterion("NEWS_NAME =", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotEqualTo(String value) {
            addCriterion("NEWS_NAME <>", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThan(String value) {
            addCriterion("NEWS_NAME >", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_NAME >=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThan(String value) {
            addCriterion("NEWS_NAME <", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThanOrEqualTo(String value) {
            addCriterion("NEWS_NAME <=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLike(String value) {
            addCriterion("NEWS_NAME like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotLike(String value) {
            addCriterion("NEWS_NAME not like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameIn(List<String> values) {
            addCriterion("NEWS_NAME in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotIn(List<String> values) {
            addCriterion("NEWS_NAME not in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameBetween(String value1, String value2) {
            addCriterion("NEWS_NAME between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotBetween(String value1, String value2) {
            addCriterion("NEWS_NAME not between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIsNull() {
            addCriterion("NEWS_URL is null");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIsNotNull() {
            addCriterion("NEWS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNewsUrlEqualTo(String value) {
            addCriterion("NEWS_URL =", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotEqualTo(String value) {
            addCriterion("NEWS_URL <>", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlGreaterThan(String value) {
            addCriterion("NEWS_URL >", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_URL >=", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLessThan(String value) {
            addCriterion("NEWS_URL <", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLessThanOrEqualTo(String value) {
            addCriterion("NEWS_URL <=", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLike(String value) {
            addCriterion("NEWS_URL like", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotLike(String value) {
            addCriterion("NEWS_URL not like", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIn(List<String> values) {
            addCriterion("NEWS_URL in", values, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotIn(List<String> values) {
            addCriterion("NEWS_URL not in", values, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlBetween(String value1, String value2) {
            addCriterion("NEWS_URL between", value1, value2, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotBetween(String value1, String value2) {
            addCriterion("NEWS_URL not between", value1, value2, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsImageIsNull() {
            addCriterion("NEWS_IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andNewsImageIsNotNull() {
            addCriterion("NEWS_IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andNewsImageEqualTo(String value) {
            addCriterion("NEWS_IMAGE =", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageNotEqualTo(String value) {
            addCriterion("NEWS_IMAGE <>", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageGreaterThan(String value) {
            addCriterion("NEWS_IMAGE >", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_IMAGE >=", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageLessThan(String value) {
            addCriterion("NEWS_IMAGE <", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageLessThanOrEqualTo(String value) {
            addCriterion("NEWS_IMAGE <=", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageLike(String value) {
            addCriterion("NEWS_IMAGE like", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageNotLike(String value) {
            addCriterion("NEWS_IMAGE not like", value, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageIn(List<String> values) {
            addCriterion("NEWS_IMAGE in", values, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageNotIn(List<String> values) {
            addCriterion("NEWS_IMAGE not in", values, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageBetween(String value1, String value2) {
            addCriterion("NEWS_IMAGE between", value1, value2, "newsImage");
            return (Criteria) this;
        }

        public Criteria andNewsImageNotBetween(String value1, String value2) {
            addCriterion("NEWS_IMAGE not between", value1, value2, "newsImage");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("KEYWORDS is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("KEYWORDS is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("KEYWORDS =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("KEYWORDS <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("KEYWORDS >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("KEYWORDS >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("KEYWORDS <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("KEYWORDS <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("KEYWORDS like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("KEYWORDS not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("KEYWORDS in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("KEYWORDS not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("KEYWORDS between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("KEYWORDS not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("PUBLISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("PUBLISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("PUBLISH_TIME =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("PUBLISH_TIME <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("PUBLISH_TIME >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_TIME >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("PUBLISH_TIME <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_TIME <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("PUBLISH_TIME in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("PUBLISH_TIME not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_TIME between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_TIME not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIsNull() {
            addCriterion("NEWS_RESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIsNotNull() {
            addCriterion("NEWS_RESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andNewsResourceEqualTo(String value) {
            addCriterion("NEWS_RESOURCE =", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotEqualTo(String value) {
            addCriterion("NEWS_RESOURCE <>", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceGreaterThan(String value) {
            addCriterion("NEWS_RESOURCE >", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_RESOURCE >=", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLessThan(String value) {
            addCriterion("NEWS_RESOURCE <", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLessThanOrEqualTo(String value) {
            addCriterion("NEWS_RESOURCE <=", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLike(String value) {
            addCriterion("NEWS_RESOURCE like", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotLike(String value) {
            addCriterion("NEWS_RESOURCE not like", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIn(List<String> values) {
            addCriterion("NEWS_RESOURCE in", values, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotIn(List<String> values) {
            addCriterion("NEWS_RESOURCE not in", values, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceBetween(String value1, String value2) {
            addCriterion("NEWS_RESOURCE between", value1, value2, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotBetween(String value1, String value2) {
            addCriterion("NEWS_RESOURCE not between", value1, value2, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNull() {
            addCriterion("NEWS_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNotNull() {
            addCriterion("NEWS_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorEqualTo(String value) {
            addCriterion("NEWS_AUTHOR =", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotEqualTo(String value) {
            addCriterion("NEWS_AUTHOR <>", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThan(String value) {
            addCriterion("NEWS_AUTHOR >", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_AUTHOR >=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThan(String value) {
            addCriterion("NEWS_AUTHOR <", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThanOrEqualTo(String value) {
            addCriterion("NEWS_AUTHOR <=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLike(String value) {
            addCriterion("NEWS_AUTHOR like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotLike(String value) {
            addCriterion("NEWS_AUTHOR not like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIn(List<String> values) {
            addCriterion("NEWS_AUTHOR in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotIn(List<String> values) {
            addCriterion("NEWS_AUTHOR not in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorBetween(String value1, String value2) {
            addCriterion("NEWS_AUTHOR between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotBetween(String value1, String value2) {
            addCriterion("NEWS_AUTHOR not between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("COMMENT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("COMMENT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Integer value) {
            addCriterion("COMMENT_NUM =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Integer value) {
            addCriterion("COMMENT_NUM <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Integer value) {
            addCriterion("COMMENT_NUM >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_NUM >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Integer value) {
            addCriterion("COMMENT_NUM <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_NUM <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Integer> values) {
            addCriterion("COMMENT_NUM in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Integer> values) {
            addCriterion("COMMENT_NUM not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_NUM between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_NUM not between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("READ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("READ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Integer value) {
            addCriterion("READ_NUM =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Integer value) {
            addCriterion("READ_NUM <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Integer value) {
            addCriterion("READ_NUM >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("READ_NUM >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Integer value) {
            addCriterion("READ_NUM <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("READ_NUM <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Integer> values) {
            addCriterion("READ_NUM in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Integer> values) {
            addCriterion("READ_NUM not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Integer value1, Integer value2) {
            addCriterion("READ_NUM between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("READ_NUM not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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