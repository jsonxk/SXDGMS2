package com.xk.orm;

import java.util.Date;
import java.util.List;

/**
 * @author: xk
 * @date:2017年11月21日 下午4:09:00
 * @version :
 * 
 */
public class CommonEntity {
	/**
	 * 状态名称 类型名称 单位名称 用户名称
	 */
	private String statusname;
	private String typename;
	private String unitname;
	private String username;
	/**
	 * 时间 首杆经纬度 尾杆经纬度 线杆数量
	 */
	private String timeString;
	private double lineFirstPolelon;
	private double lineFirstPolelat;
	private double lineLastPolelon;
	private double lineLastPolelat;
	private String lineNum;

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

	public Integer getLineid() {
		return lineid;
	}

	public void setLineid(Integer lineid) {
		this.lineid = lineid;
	}

	public Integer getUnitid() {
		return unitid;
	}

	public void setUnitid(Integer unitid) {
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

	private int type;
	private int status;
	private String memo;
	private Integer lineid;
	private Integer unitid;
	private String code;
	private String name;
	private Date createtime;
	private Integer poleid;
	private Integer processid;
	private Integer taskid;
	private Integer faultid;
	private List<Pole> poleList;
	
	public List<Pole> getPoleList() {
		return poleList;
	}

	public void setPoleList(List<Pole> poleList) {
		this.poleList = poleList;
	}

	public Integer getPoleid() {
		return poleid;
	}

	public void setPoleid(Integer poleid) {
		this.poleid = poleid;
	}
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

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public double getLineFirstPolelon() {
		return lineFirstPolelon;
	}

	public void setLineFirstPolelon(double lineFirstPolelon) {
		this.lineFirstPolelon = lineFirstPolelon;
	}

	public double getLineFirstPolelat() {
		return lineFirstPolelat;
	}

	public void setLineFirstPolelat(double lineFirstPolelat) {
		this.lineFirstPolelat = lineFirstPolelat;
	}

	public double getLineLastPolelon() {
		return lineLastPolelon;
	}

	public void setLineLastPolelon(double lineLastPolelon) {
		this.lineLastPolelon = lineLastPolelon;
	}

	public double getLineLastPolelat() {
		return lineLastPolelat;
	}

	public void setLineLastPolelat(double lineLastPolelat) {
		this.lineLastPolelat = lineLastPolelat;
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
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

	public Integer getFaultid() {
		return faultid;
	}

	public void setFaultid(Integer faultid) {
		this.faultid = faultid;
	}

}
