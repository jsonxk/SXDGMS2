package com.xk.orm;

import java.util.Date;

/**
 * @author: xk
 * @date:2017年12月8日 下午12:02:38
 * @version : 线路巡查，现场查勘，施工验收，整改验收进入线路线杆巡查的公共Entity
 */
public class CheckInfoCommon extends Photo{
	/**
	 * checkdetail
	 */
	private Integer checkdetailid;
	private Integer linecheckid;
	private Integer checkitemid;
	private Integer hangdetailid;
	private Integer poleid;
	private Date createtime;
	private Integer status;
	private String Chkdescription;
	/**
	 * photo
	 */
}
