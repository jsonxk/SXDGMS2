package com.xk.orm;

import java.util.List;

public class CheckType {
    private Integer checktypeid;

    private String name;

    private String memo;
    
    private List<CheckItem> itemlist;
    
    public List<CheckItem> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<CheckItem> itemlist) {
		this.itemlist = itemlist;
	}

	public Integer getChecktypeid() {
        return checktypeid;
    }

    public void setChecktypeid(Integer checktypeid) {
        this.checktypeid = checktypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}