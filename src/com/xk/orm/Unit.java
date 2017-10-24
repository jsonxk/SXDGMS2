package com.xk.orm;

public class Unit {
    private Integer unitid;

    private String unitname;

    private String address;

    private String mspeople;

    private String msphone;

    private Short status;

    private Integer dicitemid;

    private String memo;

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMspeople() {
        return mspeople;
    }

    public void setMspeople(String mspeople) {
        this.mspeople = mspeople;
    }

    public String getMsphone() {
        return msphone;
    }

    public void setMsphone(String msphone) {
        this.msphone = msphone;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getDicitemid() {
        return dicitemid;
    }

    public void setDicitemid(Integer dicitemid) {
        this.dicitemid = dicitemid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}