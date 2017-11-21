package com.xk.orm;

public class HangDetail {
    private Integer handdetailid;

    private Integer poleid;

    private Integer index;

    private Integer hanglineid;

    private Integer prevpoleid;

    private Integer nextpoleid;

    private Short getmethod;

    private Short status;

    private String memo;

    public Integer getHanddetailid() {
        return handdetailid;
    }

    public void setHanddetailid(Integer handdetailid) {
        this.handdetailid = handdetailid;
    }

    public Integer getPoleid() {
        return poleid;
    }

    public void setPoleid(Integer poleid) {
        this.poleid = poleid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getHanglineid() {
        return hanglineid;
    }

    public void setHanglineid(Integer hanglineid) {
        this.hanglineid = hanglineid;
    }

    public Integer getPrevpoleid() {
        return prevpoleid;
    }

    public void setPrevpoleid(Integer prevpoleid) {
        this.prevpoleid = prevpoleid;
    }

    public Integer getNextpoleid() {
        return nextpoleid;
    }

    public void setNextpoleid(Integer nextpoleid) {
        this.nextpoleid = nextpoleid;
    }

    public Short getGetmethod() {
        return getmethod;
    }

    public void setGetmethod(Short getmethod) {
        this.getmethod = getmethod;
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