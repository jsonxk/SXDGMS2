package com.xk.orm;

import java.util.Date;

/**
 * @author: xk
 * @date:2017年12月18日 下午6:03:19
 * @version :
 * 
 */
public class EasyPole {
	private int poleid;
	private int unitid;
	private String code;
	private String name;
	private Date createtime;
	private String timeString;
	private double longtitude;
	private double latitude;
	private double positionmethod;
	private double height;
	private int type;
	private int status;
	private String memo;
	public int getPoleid() {
		return poleid;
	}
	public void setPoleid(int poleid) {
		this.poleid = poleid;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getPositionmethod() {
		return positionmethod;
	}
	public void setPositionmethod(double positionmethod) {
		this.positionmethod = positionmethod;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
