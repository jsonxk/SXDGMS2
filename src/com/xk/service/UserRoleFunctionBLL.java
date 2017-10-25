package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.UserRole;

@Service
public class UserRoleFunctionBLL {
	@Autowired
	private AllDao alldao;
	//修改角色
	public boolean modifyrole(UserRole userr,int flag)
	{
		int ren=0;
		//选中
		if(flag==1)
		{
			ren=alldao.getuserRoleMapperLmpl().insertRoleByUserid(userr);
		}
		else if(flag==0)
		{
			//取消选中
			ren=alldao.getuserRoleMapperLmpl().deleteByuseridRoleid(userr);
		}
		if(ren>0)
			return true;
		else
			return false;
	}
}
