package com.xk.Dao;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

	int insert(Role record);


	Role selectByPrimaryKey(Integer roleid);


	int updateByPrimaryKey(Role record);



    int insertSelective(Role record);

    Role selectRoleid(@Param("userid")Integer userid);


}