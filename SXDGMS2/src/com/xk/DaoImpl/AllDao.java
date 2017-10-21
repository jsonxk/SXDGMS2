package com.xk.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AllDao {
	@Autowired
	private FunctionMapperImpl functionmapperimpl;
	@Autowired
	private UserMapperImpl userMapperImpl;
	@Autowired
	private RoleMapperImpl roleMapperImpl;
	public UserMapperImpl getuserMapperImpl()
	{
		return userMapperImpl;
	}
	public RoleMapperImpl getRoleMapperImpl(){
		return roleMapperImpl;
	}
	public FunctionMapperImpl getfunctionmapperimpl(){
		return functionmapperimpl;
	}
}
