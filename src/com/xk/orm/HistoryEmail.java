package com.xk.orm;

public class HistoryEmail {
    private Integer emailid;

    private Integer unitid;

    private String sendaddress;

    private String toaddress;

    private String senddocpath;

    private String subject;

    private Integer userid;

    private String context;
    /**
     * 1.发送邮件的类型{是否整改}
     * 2.流程任务Id
     */
    private Integer type;
    private Integer taskid;
    private Integer processid;
    private Integer faultid;
    private Integer status;
    

	public Integer getFaultid() {
		return faultid;
	}

	public void setFaultid(Integer faultid) {
		this.faultid = faultid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getProcessid() {
		return processid;
	}

	public void setProcessid(Integer processid) {
		this.processid = processid;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public Integer getEmailid() {
        return emailid;
    }

    public void setEmailid(Integer emailid) {
        this.emailid = emailid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress;
    }

    public String getToaddress() {
        return toaddress;
    }

    public void setToaddress(String toaddress) {
        this.toaddress = toaddress;
    }

    public String getSenddocpath() {
        return senddocpath;
    }

    public void setSenddocpath(String senddocpath) {
        this.senddocpath = senddocpath;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}