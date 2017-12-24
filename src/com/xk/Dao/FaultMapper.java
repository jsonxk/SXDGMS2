package com.xk.Dao;

import com.xk.orm.Fault;

public interface FaultMapper {
	/**
	 * 新建错误信息
	 * @param checkinfocommon
	 * @return
	 */
	int InsertFaultInfo(Fault fault);
	/**
	 * 删除已经整改完成或者不用整改的信息
	 * @param checkdetailid
	 * @return
	 */
	int DelCheckDtlFault(int checkdetailid);
}