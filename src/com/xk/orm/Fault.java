package com.xk.orm;

import java.util.Date;

public class Fault {
    private Integer faultid;

    private Integer unitid;

    private String processid;

    private String taskid;
    
    private Integer correctcheckdelid;

    private Short status;

    private Date createtime;

    private String memo;

    public Integer getFaultid() {
        return faultid;
    }

    public void setFaultid(Integer faultid) {
        this.faultid = faultid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
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
}