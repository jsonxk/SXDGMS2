package com.xk.orm;
/**
 * @author: xk
 * @date:2017年11月21日 下午4:09:00
 * @version :
 * 
 */
public class CommonEntity{
	/**
	 * 状态名称
	 * 类型名称
	 * 单位名称
	 * 用户名称
	 */
	private String statusname;
	private String typename;
	private String unitname;
	private String username;
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
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
	
}
