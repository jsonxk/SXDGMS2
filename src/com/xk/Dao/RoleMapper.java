package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Role;
/*
 * 角色
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

	int insert(Role record);


	Role selectByPrimaryKey(Integer roleid);


	int updateByPrimaryKey(Role record);

    int insertSelective(Role record);

    Role selectRoleid(@Param("userid")Integer userid);
    List<Role> selectAllRole();

}