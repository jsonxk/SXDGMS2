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
	@Autowired
	private UnitMapperImpl unitMapperImpl;
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
	public UnitMapperImpl getunitMapperImpl(){
		return unitMapperImpl;
	}
}
