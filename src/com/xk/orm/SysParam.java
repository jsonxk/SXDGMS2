package com.xk.orm;

public class SysParam {
    private Integer sysparamid;

	private String name;

	private String value;

	private Integer type;

	private String memo;

	public Integer getSysparamid() {
		return sysparamid;
	}

	public void setSysparamid(Integer sysparamid) {
		this.sysparamid = sysparamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}