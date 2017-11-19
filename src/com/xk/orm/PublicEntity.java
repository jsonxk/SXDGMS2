package com.xk.orm;
/**
 * @author: xk
 * @date:2017年11月15日 下午10:44:57
 * @version :
 * 
 */
public class PublicEntity {
	private int userid;
	private int unitid;
	private int pageSize;
	private int offset;
	private int status;
	private int total;
	private int timestatus;
	private String starttime;
	private String finishtime;
	private String permittimestart;
	private String permitfinishtime;
	private String publicname;
	public int getTimestatus() {
		return timestatus;
	}
	public void setTimestatus(int timestatus) {
		this.timestatus = timestatus;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	public String getPublicname() {
		return publicname;
	}
	public void setPublicname(String publicname) {
		this.publicname = publicname;
	}
	public String getPermittimestart() {
		return permittimestart;
	}
	public void setPermittimestart(String permittimestart) {
		this.permittimestart = permittimestart;
	}
	public String getPermitfinishtime() {
		return permitfinishtime;
	}
	public void setPermitfinishtime(String permitfinishtime) {
		this.permitfinishtime = permitfinishtime;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	
}
