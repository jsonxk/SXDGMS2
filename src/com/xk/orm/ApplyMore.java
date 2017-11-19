package com.xk.orm;

import java.util.List;

/**
 * @author: xk
 * @date:2017年11月13日 下午10:42:10
 * @version :
 * 继承Apply日期格式为String 
 */
public class ApplyMore extends Apply{
	private String applystringtime;
	private String permitStringtime;
	private String unitname;
	private String username;
	private String hanglinename;
	private String statusname;
	private List<ApplyDoc> listDoc;
	public String getApplystringtime() {
		return applystringtime;
	}
	public void setApplystringtime(String applystringtime) {
		this.applystringtime = applystringtime;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHanglinename() {
		return hanglinename;
	}
	public void setHanglinename(String hanglinename) {
		this.hanglinename = hanglinename;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getPermitStringtime() {
		return permitStringtime;
	}
	public void setPermitStringtime(String permitStringtime) {
		this.permitStringtime = permitStringtime;
	}
	public List<ApplyDoc> getListDoc() {
		return listDoc;
	}
	public void setListDoc(List<ApplyDoc> listDoc) {
		this.listDoc = listDoc;
	}
}
