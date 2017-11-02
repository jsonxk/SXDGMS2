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
	@Autowired
	private UserRoleMapperLmpl userRoleMapperLmpl;
	@Autowired
	private RoleFunctionMapperImpl roleFunctionMapperImpl;
	@Autowired
	private dictypeMapperImpl dictypeMapperImpl;
	@Autowired
	private DicitemMapperImpl dicitemMapperImpl; 
	@Autowired
	private SysParamMapperImpl sysParamMapperImpl;
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
	public UserRoleMapperLmpl getuserRoleMapperLmpl(){
		return userRoleMapperLmpl;
	}
	public RoleFunctionMapperImpl getRolefunctionMapeerImpl(){
		return roleFunctionMapperImpl;
	}
	public dictypeMapperImpl getdictypeMapperImpl(){
		return dictypeMapperImpl;
	}
	public DicitemMapperImpl getdicitemMapperImpl(){
		return dicitemMapperImpl;
	}
	public SysParamMapperImpl getsysParamMapperImpl(){
		return sysParamMapperImpl;
	}
}
