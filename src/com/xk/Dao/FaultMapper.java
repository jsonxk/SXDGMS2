package com.xk.Dao;

import com.xk.orm.Fault;

public interface FaultMapper {
	/**
	 * 新建错误信息
	 * @param checkinfocommon
	 * @return
	 */
	int InsertFaultInfo(Fault fault);
}