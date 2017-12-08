package com.xk.orm;
/**
 * @author: xk
 * @date:2017年12月7日 下午6:14:54
 * @version :
 * 
 */
public class CheckItem {
	private Integer checkitemid;
	private Integer checktypeid;
	private String name;
	private Integer ismust;
	private String memo;
	public Integer getCheckitemid() {
		return checkitemid;
	}
	public void setCheckitemid(Integer checkitemid) {
		this.checkitemid = checkitemid;
	}
	public Integer getChecktypeid() {
		return checktypeid;
	}
	public void setChecktypeid(Integer checktypeid) {
		this.checktypeid = checktypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsmust() {
		return ismust;
	}
	public void setIsmust(Integer ismust) {
		this.ismust = ismust;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
