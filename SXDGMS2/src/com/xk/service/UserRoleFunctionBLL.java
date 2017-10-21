package com.xk.service;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Role;

@Service
public class UserRoleFunctionBLL {
	@Autowired
	private AllDao alldao;
	public JSONArray SelectFunByUserid(Integer userid)
	{
		Role role=alldao.getRoleMapperImpl().selectRoleid(userid);
		System.out.println(role.getName());
		return null;
	}
}
