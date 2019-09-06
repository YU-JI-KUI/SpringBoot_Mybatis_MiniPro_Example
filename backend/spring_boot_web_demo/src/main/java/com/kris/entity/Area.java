package com.kris.entity;

import java.util.Date;

/**
 * @ClassName Area
 * @Description 区域表
 * @Author Kris
 * @Date 2019/9/5 21:11
 * @Version 1.0
 **/
public class Area {

    private Integer areaId;
    //名称
    private String areaName;
    //权重，越大越排前显示
    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
