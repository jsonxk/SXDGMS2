package com.xk.orm;

import java.util.List;

public class FunctionList {
	private Integer functionid;

    private String name;

    private Integer index;

    private Integer parentid;

    private String url;

    private String memo;
    private List<Function> funList;
	public Integer getFunctionid() {
		return functionid;
	}
	public void setFunctionid(Integer functionid) {
		this.functionid = functionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public List<Function> getFunList() {
		return funList;
	}
	public void setFunList(List<Function> funList) {
		this.funList = funList;
	}
    
}
