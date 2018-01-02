package com.xk.orm;

import java.util.Date;

public class ApplyDoc{
    private Integer applydocid;

    private Integer doctypeid;

    private Integer applyid;

    private Date createtime;

    private String docname;

    private String docpath;
    private String docnameInfo;
    
    public String getDocnameInfo() {
		return docnameInfo;
	}

	public void setDocnameInfo(String docnameInfo) {
		this.docnameInfo = docnameInfo;
	}

	public Integer getApplydocid() {
        return applydocid;
    }

    public void setApplydocid(Integer applydocid) {
        this.applydocid = applydocid;
    }

    public Integer getDoctypeid() {
        return doctypeid;
    }

    public void setDoctypeid(Integer doctypeid) {
        this.doctypeid = doctypeid;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocpath() {
        return docpath;
    }

    public void setDocpath(String docpath) {
        this.docpath = docpath;
    }
}