package com.xk.orm;

import java.util.Date;

public class PowerLine extends CommonEntity{
   

    private Integer firstpoleid;

    private Integer finallypoleid;

    private Double linelength;

    private String memo;
    
    private String time;

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

	public Double getLinelength() {
		return linelength;
	}

	public void setLinelength(Double linelength) {
		this.linelength = linelength;
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