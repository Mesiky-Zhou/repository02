package com.framework.bean;

import java.util.Date;

public class IndexConfig {
    private Integer id;

    private String code;

    private String indexTitle;

    private Integer pageSize;

    private String restUrl;

    private String gridConfig;

    private String addConfig;

    private String updateConfig;

    private String viewConfig;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIndexTitle() {
        return indexTitle;
    }

    public void setIndexTitle(String indexTitle) {
        this.indexTitle = indexTitle == null ? null : indexTitle.trim();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl == null ? null : restUrl.trim();
    }

    public String getGridConfig() {
        return gridConfig;
    }

    public void setGridConfig(String gridConfig) {
        this.gridConfig = gridConfig == null ? null : gridConfig.trim();
    }

    public String getAddConfig() {
        return addConfig;
    }

    public void setAddConfig(String addConfig) {
        this.addConfig = addConfig == null ? null : addConfig.trim();
    }

    public String getUpdateConfig() {
        return updateConfig;
    }

    public void setUpdateConfig(String updateConfig) {
        this.updateConfig = updateConfig == null ? null : updateConfig.trim();
    }

    public String getViewConfig() {
        return viewConfig;
    }

    public void setViewConfig(String viewConfig) {
        this.viewConfig = viewConfig == null ? null : viewConfig.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}