package com.xk.orm;

import java.util.Date;

public class PowerLine extends CommonEntity{
    private Integer lineid;

    private Integer unitid;

    private String code;

    private String name;

    private Date createtime;

    private Integer firstpoleid;

    private Integer finallypoleid;

    private Short status;

    private Double linelength;

    private String type;

    private String memo;
    
    private String time;
    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFirstpoleid() {
        return firstpoleid;
    }

    public void setFirstpoleid(Integer firstpoleid) {
        this.firstpoleid = firstpoleid;
    }

    public Integer getFinallypoleid() {
        return finallypoleid;
    }

    public void setFinallypoleid(Integer finallypoleid) {
        this.finallypoleid = finallypoleid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Double getLinelength() {
        return linelength;
    }

    public void setLinelength(Double linelength) {
        this.linelength = linelength;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}