package com.xk.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.UserRoleMapper;
import com.xk.orm.UserRole;

@Repository
public class UserRoleMapperLmpl {
	@Autowired
	private UserRoleMapper userRoleMapper;
	public int insertRoleByUserid(UserRole userrole)	
	{
		//System.out.println(userRoleMapper.insertRoleByUserid(userrole));
		return userRoleMapper.insertRoleByUserid(userrole);
	}
	public int deleteByuseridRoleid(UserRole userrole)
	{
		return userRoleMapper.deleteByuseridRoleid(userrole);
	}
}
