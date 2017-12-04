package com.xk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.dictypeMapperImpl;
import com.xk.orm.dicitem;

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
	@Autowired
	private DicTypeBLL dicTypeBLL;
	@Autowired
	private DicitemBLL dicitemBLL;
	@Autowired
	private SysParamBLL sysparambll;
	@Autowired
	private HangLineBLL hangLineBLL;
	@Autowired
	private ApplyMapperBLL applyMapperBLL;
	@Autowired
	private SqxxglBLL sqxxglBLL;
	@Autowired
	private LinePoleBLL linePoleBLL;
	@Autowired
	private DgxlglBLL dgxlglBLL;
	@Autowired
	private FaultBLL faultBLL;
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
	public DicTypeBLL getdicTypeBLL(){
		return dicTypeBLL;
	}
	public DicitemBLL getdicitemBll(){
		return dicitemBLL;
	}
	public SysParamBLL getsysparambll(){
		return sysparambll;
	}
	public HangLineBLL gethangLineBLL(){
		return hangLineBLL;
	}
	public ApplyMapperBLL getApplyMapperBLL(){
		return applyMapperBLL;
	}
	public SqxxglBLL getSqxxglBll()
	{
		return sqxxglBLL;
	}
	public LinePoleBLL getLinePoleBLL(){
		return linePoleBLL;
	}
	public DgxlglBLL getDgxlglBLL(){
		return dgxlglBLL;
	}
	public FaultBLL getFaultBLL(){
		return faultBLL;
	}
}
