package com.xk.Dao;

import java.util.List;

import com.xk.orm.CheckDetail;
import com.xk.orm.PublicEntity;

public interface CheckDetailMapper {
	/**
	 * 查询线路检查中缺陷的信息{time，type，status}
	 * @param publicEntity
	 * @return{checkdetailid,checkitemid,faultid,faulttime,linecheckid,memo,poleid,processid,statusname{错误状态},taskid,unitid,unitname}
	 */
	List<CheckDetail> SelectAllFaultInfo(PublicEntity publicEntity);
}