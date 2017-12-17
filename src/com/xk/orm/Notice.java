package com.xk.orm;

import java.util.Date;

public class Notice {
    private Integer noticeid;

    private Integer faultid1;

    private Integer unitid1;

    private Integer proccessid1;

    private Integer status1;

    private Date createtime1;

    private Integer correntchkdtlid;
    
    private String statusname;

	public Integer getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(Integer noticeid) {
		this.noticeid = noticeid;
	}

	public Integer getFaultid1() {
		return faultid1;
	}

	public void setFaultid1(Integer faultid1) {
		this.faultid1 = faultid1;
	}

	public Integer getUnitid1() {
		return unitid1;
	}

	public void setUnitid1(Integer unitid1) {
		this.unitid1 = unitid1;
	}

	public Integer getProccessid1() {
		return proccessid1;
	}

	public void setProccessid1(Integer proccessid1) {
		this.proccessid1 = proccessid1;
	}

	public Integer getStatus1() {
		return status1;
	}

	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}

	public Date getCreatetime1() {
		return createtime1;
	}

	public void setCreatetime1(Date createtime1) {
		this.createtime1 = createtime1;
	}

	public Integer getCorrentchkdtlid() {
		return correntchkdtlid;
	}

	public void setCorrentchkdtlid(Integer correntchkdtlid) {
		this.correntchkdtlid = correntchkdtlid;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
    
}