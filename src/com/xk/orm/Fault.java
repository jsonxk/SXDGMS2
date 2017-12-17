package com.xk.orm;

import java.util.Date;

public class Fault {
    private Integer faultid;

	private String processid;

	private String taskid;

	private Integer correctcheckdelid;

	private Integer status;

	private Date createtime;
	private String Stringtime;
	private String memo;

	private Integer faultchkdtlid;
	
	public String getStringtime() {
		return Stringtime;
	}

	public void setStringtime(String stringtime) {
		Stringtime = stringtime;
	}

	public Integer getFaultid() {
		return faultid;
	}

	public void setFaultid(Integer faultid) {
		this.faultid = faultid;
	}

	public String getProcessid() {
		return processid;
	}

	public void setProcessid(String processid) {
		this.processid = processid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public Integer getCorrectcheckdelid() {
		return correctcheckdelid;
	}

	public void setCorrectcheckdelid(Integer correctcheckdelid) {
		this.correctcheckdelid = correctcheckdelid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getFaultchkdtlid() {
		return faultchkdtlid;
	}

	public void setFaultchkdtlid(Integer faultchkdtlid) {
		this.faultchkdtlid = faultchkdtlid;
	}
}