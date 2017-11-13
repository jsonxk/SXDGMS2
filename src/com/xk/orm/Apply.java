package com.xk.orm;

import java.util.Date;


public class Apply {
    private Integer applyid;

    private Integer unitid;

    private Integer userid;

    private Integer hanglineid;

    private String processid;

    private double num;
    
    private Date applytime;

    private String contactperson;

    private String contactphone;

    private String buildunit;

    private String buildcontact;

    private String buildphone;

    private Integer buildtype;

    private String qualifications;

    private String description;

    private Integer status;

    private String memo;

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getHanglineid() {
        return hanglineid;
    }

    public void setHanglineid(Integer hanglineid) {
        this.hanglineid = hanglineid;
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
    //@JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getBuildunit() {
        return buildunit;
    }

    public void setBuildunit(String buildunit) {
        this.buildunit = buildunit;
    }

    public String getBuildcontact() {
        return buildcontact;
    }

    public void setBuildcontact(String buildcontact) {
        this.buildcontact = buildcontact;
    }

    public String getBuildphone() {
        return buildphone;
    }

    public void setBuildphone(String buildphone) {
        this.buildphone = buildphone;
    }

    public Integer getBuildtype() {
        return buildtype;
    }

    public void setBuildtype(Integer buildtype) {
        this.buildtype = buildtype;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}