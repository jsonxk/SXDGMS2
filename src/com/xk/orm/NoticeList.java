package com.xk.orm;

import java.util.Date;
import java.util.List;

/**
 * @author: xk
 * @date:2017年12月23日 下午3:59:56
 * @version :
 * 
 */
public class NoticeList {
	 	private Integer noticeid;

	    private Integer faultid;

	    private Integer unitid;

	    private Integer proccessid;

	    private Integer status;

	    private Date createtime;

	    private Integer correntchkdtlid;
	    
	    private String statusname;
	    List<LineDetail> linedetailList;
		public Integer getNoticeid() {
			return noticeid;
		}
		public void setNoticeid(Integer noticeid) {
			this.noticeid = noticeid;
		}
		public Integer getFaultid() {
			return faultid;
		}
		public void setFaultid(Integer faultid) {
			this.faultid = faultid;
		}
		public Integer getUnitid() {
			return unitid;
		}
		public void setUnitid(Integer unitid) {
			this.unitid = unitid;
		}
		public Integer getProccessid() {
			return proccessid;
		}
		public void setProccessid(Integer proccessid) {
			this.proccessid = proccessid;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		public Integer getCorrentchkdtlid() {
			return correntchkdtlid;
		}
		public void setCorrentchkdtlid(Integer correntchkdtlid) {
			this.correntchkdtlid = correntchkdtlid;
		}
		public String getStatusname() {
			return statusname;
		}
		public void setStatusname(String statusname) {
			this.statusname = statusname;
		}
		public List<LineDetail> getLinedetailList() {
			return linedetailList;
		}
		public void setLinedetailList(List<LineDetail> linedetailList) {
			this.linedetailList = linedetailList;
		}
	    
}
