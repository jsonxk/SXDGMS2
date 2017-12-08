package com.xk.orm;

import java.util.Date;

public class LineCheck {
    private Integer linecheckid;

    private Integer userid;

    private Integer applyid;

    private Integer hanglineid;

    private Integer checktypeid;

    private Date createtime;

    private Date checkdate;

    private Date comparetime;

    private Integer status;

    private String memo;

    public Integer getLinecheckid() {
        return linecheckid;
    }

    public void setLinecheckid(Integer linecheckid) {
        this.linecheckid = linecheckid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getHanglineid() {
        return hanglineid;
    }

    public void setHanglineid(Integer hanglineid) {
        this.hanglineid = hanglineid;
    }

    public Integer getChecktypeid() {
        return checktypeid;
    }

    public void setChecktypeid(Integer checktypeid) {
        this.checktypeid = checktypeid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Date getComparetime() {
        return comparetime;
    }

    public void setComparetime(Date comparetime) {
        this.comparetime = comparetime;
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