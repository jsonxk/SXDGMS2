package com.xk.orm;

import java.math.BigDecimal;
import java.util.Date;

public class Pole extends CommonEntity{
    private Integer poleid;

    private Integer unitid;

    private Integer lineid;

    private String code;

    private String name;

    private Date createtime;

    private BigDecimal longtitude;

    private BigDecimal latitude;

    private Short positionmethod;

    private BigDecimal height;

    private String type;

    private Short status;

    private String memo;

    public Integer getPoleid() {
        return poleid;
    }

    public void setPoleid(Integer poleid) {
        this.poleid = poleid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
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

    public BigDecimal getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(BigDecimal longtitude) {
        this.longtitude = longtitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Short getPositionmethod() {
        return positionmethod;
    }

    public void setPositionmethod(Short positionmethod) {
        this.positionmethod = positionmethod;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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