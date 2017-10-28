package com.xk.Dao;

import com.xk.orm.RoleFunction;

/*
 * 角色
 */
public interface RoleFunctionMapper {
    int deleteByPrimaryKey(Integer rolefunctionid);
	int insert(RoleFunction record);
	int insertSelective(RoleFunction record);
	RoleFunction selectByPrimaryKey(Integer rolefunctionid);
	int updateByPrimaryKeySelective(RoleFunction record);
	int updateByPrimaryKey(RoleFunction record);
	//删除功能
	int deleteFunc(RoleFunction rf);
	//添加功能
	int insertFunc(RoleFunction rf);
}