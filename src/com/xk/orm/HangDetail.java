package com.xk.orm;

public class HangDetail {
    private Integer handdetailid;

    private Integer poleid;
    
    private String code;

    private Integer hanglineid;

    private Integer prevpoleid;

    private Integer nextpoleid;

    private Integer getmethod;

    private Integer status;

    private String memo;
    private String polename;
    
    public String getPolename() {
		return polename;
	}

	public void setPolename(String polename) {
		this.polename = polename;
	}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getGetmethod() {
        return getmethod;
    }

    public void setGetmethod(Integer getmethod) {
        this.getmethod = getmethod;
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