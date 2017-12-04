package com.xk.orm;

import java.util.List;

/**
 * @author: xk
 * @date:2017年12月3日 下午9:49:55
 * @version :
 * 
 */
public class HangDetailList extends HangDetail{
	private String hangname;
	private List<HangDetail> hangList;

	public List<HangDetail> getHangList() {
		return hangList;
	}

	public void setHangList(List<HangDetail> hangList) {
		this.hangList = hangList;
	}

	public String getHangname() {
		return hangname;
	}

	public void setHangname(String hangname) {
		this.hangname = hangname;
	}
	
}
