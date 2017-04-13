package com.lxinet.jeesns.modules.sys.entity;

import com.lxinet.jeesns.core.entity.BaseEntity;

import java.util.Date;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public class Action extends BaseEntity {
    private Integer id;
    private Date createTime;
    private String name;
    private String log;
    private Integer status;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
