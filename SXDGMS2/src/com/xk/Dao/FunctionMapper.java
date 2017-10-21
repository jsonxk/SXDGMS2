package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Function;
import com.xk.orm.FunctionList;

public interface FunctionMapper {

	int insert(Function record);

	int insertSelective(Function record);

	Function selectByPrimaryKey(Integer functionid);

	int updateByPrimaryKey(Function record);

	int deleteByPrimaryKey(Integer functionid);

	/*
	 * @param userid
	 * 
	 * @param parentid
	 */
	List<FunctionList> selectOnUserid(@Param("userid") Integer userid,
			@Param("parentid") Integer parentid);

	int updateByPrimaryKeySelective(Function record);

}