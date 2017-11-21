package com.xk.orm;

import java.util.Date;

public class HangLine {
    private Integer hanglineid;

    private Integer unitid;

    private String hangname;

    private Integer startpoleid;

    private Integer endpoleid;

    private String type;

    private Date applydate;

    private Short status;

    private String memo;

    public Integer getHanglineid() {
        return hanglineid;
    }

    public void setHanglineid(Integer hanglineid) {
        this.hanglineid = hanglineid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getHangname() {
        return hangname;
    }

    public void setHangname(String hangname) {
        this.hangname = hangname;
    }

    public Integer getStartpoleid() {
        return startpoleid;
    }

    public void setStartpoleid(Integer startpoleid) {
        this.startpoleid = startpoleid;
    }

    public Integer getEndpoleid() {
        return endpoleid;
    }

    public void setEndpoleid(Integer endpoleid) {
        this.endpoleid = endpoleid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}