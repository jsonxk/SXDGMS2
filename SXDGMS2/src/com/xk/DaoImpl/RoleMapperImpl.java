package com.xk.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.RoleMapper;
import com.xk.orm.Role;

@Repository
public class RoleMapperImpl {
	@Autowired
	private RoleMapper roleMapper;
	public Role selectRoleid(Integer userid)
	{
		return roleMapper.selectRoleid(userid);
	}
}
