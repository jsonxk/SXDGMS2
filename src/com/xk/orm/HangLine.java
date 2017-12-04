package com.xk.orm;

import java.util.Date;

public class HangLine extends CommonEntity{
    private Integer hanglineid;

    private String hangname;

	public Integer getHanglineid() {
		return hanglineid;
	}


	public void setHanglineid(Integer hanglineid) {
		this.hanglineid = hanglineid;
	}


	public String getHangname() {
		return hangname;
	}


	public void setHangname(String hangname) {
		this.hangname = hangname;
	}

}