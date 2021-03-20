package com.fsy.controlstrategy.entity;

import java.util.Date;

public class ControlQuartz {
    private Long id;

    private String quartzName;

    private String quartzTable;

    private String quartzClass;

    private String quartzTime;

    private String lastUpdateTime;

    private Integer valid;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuartzName() {
        return quartzName;
    }

    public void setQuartzName(String quartzName) {
        this.quartzName = quartzName == null ? null : quartzName.trim();
    }

    public String getQuartzTable() {
        return quartzTable;
    }

    public void setQuartzTable(String quartzTable) {
        this.quartzTable = quartzTable == null ? null : quartzTable.trim();
    }

    public String getQuartzClass() {
        return quartzClass;
    }

    public void setQuartzClass(String quartzClass) {
        this.quartzClass = quartzClass == null ? null : quartzClass.trim();
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getQuartzTime() {
        return quartzTime;
    }

    public void setQuartzTime(String quartzTime) {
        this.quartzTime = quartzTime;
    }
}