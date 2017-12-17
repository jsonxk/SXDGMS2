package com.xk.orm;

import java.util.Date;

public class Photo {
    private Integer photoid;

    private Integer checkdetailid;

    private Date createtime;
    
    private String Stringcreatetime;
    
    private String description;

    private String photopath;

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }
    
    public String getStringcreatetime() {
		return Stringcreatetime;
	}

	public void setStringcreatetime(String stringcreatetime) {
		Stringcreatetime = stringcreatetime;
	}

	public Integer getCheckdetailid() {
        return checkdetailid;
    }

    public void setCheckdetailid(Integer checkdetailid) {
        this.checkdetailid = checkdetailid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }
}