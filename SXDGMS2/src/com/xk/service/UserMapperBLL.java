package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.User;
@Service
public class UserMapperBLL {
@Autowired 
private AllDao allDao;
	public User LoginJudgy(String username,String password)
	{
		return allDao.getuserMapperImpl().LoginJudgy(username, password);
	}
	public JSONArray selectallUser(){
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		List<User> user=allDao.getuserMapperImpl().selectallUser();
		for(User u:user)
		{
			jo.put("userid", u.getUnitid());
			jo.put("usertype", u.getType());
			ja.add(jo);
		}
		return ja;
	}
}
