package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Role;
import com.xk.orm.UserRole;

@Service
public class RoleMapperBLL {
@Autowired
private AllDao alldao;
/*
 * 根据userid找到roleid
 * 根据roleid匹配加上checked：true；
 */
public JSONArray selectByUserid(Integer userid)
{
	JSONArray ja=new JSONArray();
	JSONObject jo=new JSONObject();
	//userrole信息
	List<UserRole> userrole=alldao.getRoleMapperImpl().selectroleidByUserid(userid);
	List<Role> role=alldao.getRoleMapperImpl().selectAllRole();
	for(UserRole ur:userrole)
	{
		System.out.println(ur.getUserid()+"ff"+ur.getRoleid());
	}
	for(Role r: role)
	{
		jo.put("check", false);
		for(UserRole ur:userrole)
		{
			if(ur.getRoleid()==r.getRoleid())
			{
				jo.put("check", true);
			}
		}
		jo.put("userid", userid);
		jo.put("roleid", r.getRoleid());
		jo.put("rolename", r.getName());
		jo.put("rolememo", r.getMemo());
		ja.add(jo);
	}
	System.out.println(ja);
	return ja;
}
/*
 * 获取所有的角色信息
 * 通过rolename
 */
	public List<Role> SelectAllRole(String rolename){
		//所有角色信息
		if(rolename.equals(""))
		{
			//无参
			return alldao.getRoleMapperImpl().selectAllRole();
		}
		else
			//带参
			return alldao.getRoleMapperImpl().selectAllRoleByRolename(rolename);
	}
}
