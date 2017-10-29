package com.xk.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.User;
import com.xk.orm.UserInfo;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;
@Service
public class UserMapperBLL {
@Autowired 
private AllDao allDao;
	/*
	 * 用户登录判断	
	 */
	public User LoginJudgy(String username,String password)
	{
		return allDao.getuserMapperImpl().LoginJudgy(username, password);
	}
	/*
	 * 获取用户信息
	 * 1 所有信息
	 * 2 指定参数
	 */
	public JSONArray selectallUser(UserInfo info){
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		String status=null;
		List<UserInfo> user=new ArrayList<UserInfo>();
		//所有项目信息
		List<dicitem> dic=new ArrayList<dicitem>();
		dic=allDao.getdicitemMapperImpl().selectAllItem();
		if(info.getName().equals(""))
		{
			user=allDao.getuserMapperImpl().selectallUser();
		}
		else{
			user=allDao.getuserMapperImpl().selectUserByInfo(info);
		}
		int i=0;
		for(UserInfo u:user)
		{
			if(u.getStatus()==39)
			{
				status="在岗";
			}
			else{
				status="离职";
			}
			jo.put("type","");
			for(dicitem item:dic)
			{
				if(u.getUsertype()==item.getDicitemid())
				{
					jo.put("type",item.getItem());
				}
			}
			jo.put("userid", u.getUserid());
			jo.put("index", ++i);
			jo.put("name",u.getName());
			jo.put("unit", u.getUnitname());
			jo.put("phone", u.getPhone());
			jo.put("status", status);
			jo.put("memo", u.getMemo());
			ja.add(jo);
		}
		return ja;
	}
	public Boolean deleteByUserid(Integer userid)
	{
		int i=allDao.getuserMapperImpl().deleteByUserid(userid);
		if(i>0)
		{
			return true;
		}
		else 
			return false;
	}
}
