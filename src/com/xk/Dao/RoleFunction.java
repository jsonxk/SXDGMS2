package com.xk.Dao;
/**
 * @author: xk
 * @date:2017年10月26日 下午11:18:56
 * @version :
 * 
 */
public class RoleFunction {
	private int rolefunctionid;
	private int roleid;
	private int functionid;
	private int parentid;
	public int getRolefunctionid() {
		return rolefunctionid;
	}
	public void setRolefunctionid(int rolefunctionid) {
		this.rolefunctionid = rolefunctionid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getFunctionid() {
		return functionid;
	}
	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
}
