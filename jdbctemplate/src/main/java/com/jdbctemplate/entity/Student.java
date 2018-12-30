package com.jdbctemplate.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer lineId;
    private String name;
    private Integer qq;
    private String type;
    private Long estimatedTime;
    private String graduateFrom;
    private String logUrl;
    private String will;
    private String senior;
    private String knowFrom;
    private Integer id;
    private Long createdAt;
    private Long updatedAt;

    //set、get方法
    public Integer getLineId() {
        return lineId;
    }
    public void setLineId(Integer lineId){
        this.lineId = lineId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getQq(){
        return qq;
    }

    public void setQQ(Integer qq) {
        this.qq = qq;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public Long getEstimatedTime(){
        return estimatedTime;
    }
    public void setEstimatedTtime(Long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getGraduateFrom() {
        return graduateFrom;
    }
    public void setGraduate_from(String graduateFrom) {
        this.graduateFrom= graduateFrom;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogURL(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getWill() {
        return will;
    }

    public void setWill(String will) {
        this.will = will;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "{"+"线上学号："+lineId+"/姓名："+name+"/qq："+qq+"/修真类型："+type
                +"/预计入学时间："+estimatedTime+"/毕业院校："+graduateFrom+"/日报链接："+logUrl
                +"/师兄："+senior+"/入学宣言："+will+"/从哪里知道修真院："+knowFrom+"/创建时间："+knowFrom
                +"/更新时间："+updatedAt+"}";
    }
}
