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
	for(Role r: role)
	{
		for(UserRole ur:userrole)
		{
			if(ur.getRoleid()==r.getRoleid())
			{
				jo.put("checked", true);
			}
			else{
				jo.put("checked", false);
			}
		}
		jo.put("rolename", r.getName());
		jo.put("rolememo", r.getMemo());
		ja.add(jo);
	}
	return ja;
}
}
