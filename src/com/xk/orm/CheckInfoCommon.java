package com.xk.orm;

import java.util.Date;

/**
 * @author: xk
 * @date:2017年12月8日 下午12:02:38
 * @version : 线路巡查，现场查勘，施工验收，整改验收进入线路线杆巡查的公共Entity
 */
public class CheckInfoCommon extends Photo{
	/**
	 * checkdetail
	 */
	private Integer linechkid;
	private Integer checkdetailid;
	private Integer checkitemid;
	private Integer hangdetailid;
	private Integer poleid;
	private Date chkDtlCreatetime;
	private String StringchkDtlCreatetime;
	private Integer chkDtlstatus;
	private Integer faultid;
	private String chkDtlDescription;
	private String taskid;
	private Integer checktypeid;
	/**
	 * fault
	 */
	
	private Integer processid;
	
	public Integer getLinechkid() {
		return linechkid;
	}
	public void setLinechkid(Integer linechkid) {
		this.linechkid = linechkid;
	}
	public String getStringchkDtlCreatetime() {
		return StringchkDtlCreatetime;
	}
	public void setStringchkDtlCreatetime(String stringchkDtlCreatetime) {
		StringchkDtlCreatetime = stringchkDtlCreatetime;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public Integer getFaultid() {
		return faultid;
	}
	public void setFaultid(Integer faultid) {
		this.faultid = faultid;
	}
	public Integer getProcessid() {
		return processid;
	}
	public void setProcessid(Integer processid) {
		this.processid = processid;
	}
	public Integer getCheckdetailid() {
		return checkdetailid;
	}
	public void setCheckdetailid(Integer checkdetailid) {
		this.checkdetailid = checkdetailid;
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
	public Date getChkDtlCreatetime() {
		return chkDtlCreatetime;
	}
	public void setChkDtlCreatetime(Date chkDtlCreatetime) {
		this.chkDtlCreatetime = chkDtlCreatetime;
	}
	public Integer getChkDtlstatus() {
		return chkDtlstatus;
	}
	public void setChkDtlstatus(Integer chkDtlstatus) {
		this.chkDtlstatus = chkDtlstatus;
	}
	public String getChkDtlDescription() {
		return chkDtlDescription;
	}
	public void setChkDtlDescription(String chkDtlDescription) {
		this.chkDtlDescription = chkDtlDescription;
	}
	public Integer getChecktypeid() {
		return checktypeid;
	}
	public void setChecktypeid(Integer checktypeid) {
		this.checktypeid = checktypeid;
	}
	
	
}
