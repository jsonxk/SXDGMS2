package com.xk.orm;

public class Doctype  extends ApplyDoc{
    private Integer doctypeid;

    private String docname;

    private Integer must;

    private Integer status;

    public Integer getDoctypeid() {
        return doctypeid;
    }

    public void setDoctypeid(Integer doctypeid) {
        this.doctypeid = doctypeid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public Integer getMust() {
        return must;
    }

    public void setMust(Integer must) {
        this.must = must;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}