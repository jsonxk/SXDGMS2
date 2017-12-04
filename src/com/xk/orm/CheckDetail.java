package com.xk.orm;


public class CheckDetail extends CommonEntity{
    private Integer checkdetailid;

    private Integer linecheckid;

    private Integer checkitemid;

    private Integer hangdetailid;

    private String description;

    public Integer getCheckdetailid() {
        return checkdetailid;
    }

    public void setCheckdetailid(Integer checkdetailid) {
        this.checkdetailid = checkdetailid;
    }

    public Integer getLinecheckid() {
        return linecheckid;
    }

    public void setLinecheckid(Integer linecheckid) {
        this.linecheckid = linecheckid;
    }

    public Integer getCheckitemid() {
        return checkitemid;
    }

    public void setCheckitemid(Integer checkitemid) {
        this.checkitemid = checkitemid;
    }

    public Integer getHangdetailid() {
        return hangdetailid;
    }

    public void setHangdetailid(Integer hangdetailid) {
        this.hangdetailid = hangdetailid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}