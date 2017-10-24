package com.xk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllService {
	@Autowired
	private UserMapperBLL userMapperBLL;
	@Autowired
	private UserRoleFunctionBLL userRoleFunctionBLL;
	@Autowired
	private FunctionBLL functionBLL;
	@Autowired
	private UnitBLL uniBll;
	@Autowired
	private RoleMapperBLL roleMapperBLL;
	public UserMapperBLL getuserMapperBLL(){
		return userMapperBLL;
	}
	public UserRoleFunctionBLL getuserRoleFunctionBLL(){
		return userRoleFunctionBLL;
	}
	public FunctionBLL getfunctionBLL(){
		return functionBLL;
	}
	public UnitBLL getuniBll(){
		return uniBll;
	}
	public RoleMapperBLL getroleMapperBLL(){
		return roleMapperBLL;
	}
}
