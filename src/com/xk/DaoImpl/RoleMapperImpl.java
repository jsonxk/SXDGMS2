package com.xk.DaoImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.RoleMapper;
import com.xk.Dao.UserRoleMapper;
import com.xk.orm.Role;
import com.xk.orm.UserRole;

@Repository
public class RoleMapperImpl {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired 
	private UserRoleMapper userRoleMapper;
	public Role selectRoleid(Integer userid)
	{
		return roleMapper.selectRoleid(userid);
	}
	public List<UserRole> selectroleidByUserid(@Param("userid")Integer userid){
		return userRoleMapper.selectroleidByUserid(userid);
	}
	public List<Role> selectAllRole(){
		return roleMapper.selectAllRole();
	}
}
