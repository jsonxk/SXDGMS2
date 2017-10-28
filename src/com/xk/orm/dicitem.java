package com.xk.orm;

public class dicitem {
    private Integer dicitemid;

    private String item;

    private String code;

    private Integer dictypeid;

    private String memo;

    public Integer getDicitemid() {
        return dicitemid;
    }

    public void setDicitemid(Integer dicitemid) {
        this.dicitemid = dicitemid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDictypeid() {
        return dictypeid;
    }

    public void setDictypeid(Integer dictypeid) {
        this.dictypeid = dictypeid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}