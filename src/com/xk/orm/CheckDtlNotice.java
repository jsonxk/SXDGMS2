package com.xk.orm;

import java.util.Date;

/**
 * @author: xk
 * @date:2017年12月8日 下午8:57:07
 * @version :
 * 
 */
public class CheckDtlNotice extends Notice{
	  private Integer checkdetailid;

	  private Integer linecheckid;

	  private Integer checkitemid;

	  private Integer hangdetailid;
	  private Integer poleid;
	  private Date createtime;
	  private Integer status;
	  private Integer faultid;
	  private Integer taskid;
	  private Integer processid;
	  private String description;
	  private String Stringtime;
	  private String polename;
	  
	  
	public String getPolename() {
		return polename;
	}
	public void setPolename(String polename) {
		this.polename = polename;
	}
	public String getStringtime() {
		return Stringtime;
	}
	public void setStringtime(String stringtime) {
		Stringtime = stringtime;
	}
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
	public Integer getPoleid() {
		return poleid;
	}
	public void setPoleid(Integer poleid) {
		this.poleid = poleid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getFaultid() {
		return faultid;
	}
	public void setFaultid(Integer faultid) {
		this.faultid = faultid;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public Integer getProcessid() {
		return processid;
	}
	public void setProcessid(Integer processid) {
		this.processid = processid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	  
}
