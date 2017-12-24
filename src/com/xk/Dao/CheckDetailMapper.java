package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.CheckDetail;
import com.xk.orm.CheckDtlNotice;
import com.xk.orm.CheckInfoCommon;
import com.xk.orm.PublicEntity;

public interface CheckDetailMapper {
	/**
	 * 查询线路检查中缺陷的信息{time，type，status}
	 * @param publicEntity
	 * @return{checkdetailid,checkitemid,faultid,faulttime,linecheckid,memo,poleid,processid,statusname{错误状态},taskid,unitid,unitname}
	 */
	List<CheckDtlNotice> SelectAllFaultInfo(PublicEntity publicEntity);
	/**
	 * 新建一次线杆检查细节
	 * @param checkinfocommon
	 * @return
	 */
	int InsertPoleChkDtl(CheckInfoCommon checkinfocommon);
	/**
	 * 修改checkdtl中processid
	 * @param checkdetailid
	 * @param faultid
	 * @param processid 
	 * @return
	 */
	int ModifyCheckDtlProcess(@Param("checkdetailid")int checkdetailid,@Param("faultid") int faultid,@Param("processid") int processid);
	/**
	 * 查询状态为整改验收的错误检查信息
	 * @return
	 */
	List<CheckDetail> SelectFaultTask();
}