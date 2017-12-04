package com.xk.orm;

import java.util.List;

import com.xk.orm.LineDetail;

/**
 * @author: xk
 * @date:2017年12月3日 下午5:08:28
 * @version :
 * 
 */
public class LineDetailList extends LineDetail{
	private List<LineDetail> lineList;
	private String linename;
	public List<LineDetail> getLineList() {
		return lineList;
	}

	public void setLineList(List<LineDetail> lineList) {
		this.lineList = lineList;
	}

	public String getLinename() {
		return linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}
	
}
