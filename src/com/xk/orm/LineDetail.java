package com.xk.orm;

public class LineDetail {
    private Integer linedetailid;

    private Integer lineid;

    private Integer poleid;

    private Integer prepoleid;

    private String code;

    private String name;

    private String memo;

    public Integer getLinedetailid() {
        return linedetailid;
    }

    public void setLinedetailid(Integer linedetailid) {
        this.linedetailid = linedetailid;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public Integer getPoleid() {
        return poleid;
    }

    public void setPoleid(Integer poleid) {
        this.poleid = poleid;
    }

    public Integer getPrepoleid() {
        return prepoleid;
    }

    public void setPrepoleid(Integer prepoleid) {
        this.prepoleid = prepoleid;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}