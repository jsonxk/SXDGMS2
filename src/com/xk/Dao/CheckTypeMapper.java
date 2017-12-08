package com.xk.Dao;

import java.util.List;

import com.xk.orm.CheckType;


public interface CheckTypeMapper {

	/**
	 * 查询缺陷状态
	 * @return
	 */
	List<CheckType> SelectFaultType();
	/**
	 * 查询线路检查类型
	 * @return
	 */
	List<CheckType> SelectLineChkType();
}