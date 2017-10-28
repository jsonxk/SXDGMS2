package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Function;
import com.xk.orm.FunctionList;
/*
 * 功能
 */
public interface FunctionMapper {

	/*
	 * @param userid
	 * @param parentid
	 */
	List<FunctionList> selectOnUserid(@Param("userid") Integer userid,
			@Param("parentid") Integer parentid);

	/*
	 * 获取某个人角色所有功能
	 */
	List<Function> selectFuncByRoleid(@Param("roleid")Integer roleid);
	/*
	 * 获取所有功能
	 */
	List<FunctionList> selectallFunction();
}