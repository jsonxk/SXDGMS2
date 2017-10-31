package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Unit;
import com.xk.orm.dicitem;

@Service
public class UnitBLL {
	@Autowired
	private AllDao allDao;
	/*
	 * 获取所有的单位信息
	 */
	public JSONArray selectAllUnitName(){
		JSONArray ja=new JSONArray();
		List<Unit> data=allDao.getunitMapperImpl().selectAllUnitName();
		ja=JSONArray.fromObject(data);
		return ja;
	}
	/*
	 * 查找单位信息
	 */
	public JSONArray selectUnitByname(String unitname,int pagesize,int offset)
	{
		//单位总数
		int count=allDao.getunitMapperImpl().selectCount();
		List<Unit> dataunit=null;
		List<dicitem> dataItem=null;
		//单位状态类型
		dataItem=allDao.getdicitemMapperImpl().selectAllItem();
		JSONArray data=new JSONArray();
		JSONObject jo=new JSONObject();
		JSONArray datatotal=new JSONArray();
		JSONObject jototal=new JSONObject();
		if(unitname.equals(""))
		{
			dataunit=allDao.getunitMapperImpl().selectAllUnitPage(pagesize, offset);
		}
		else{
			dataunit=allDao.getunitMapperImpl().selectUnitByname(unitname);
		}
		for(Unit u:dataunit)
		{	
			jo.put("status","");
			jo.put("dicitem","");
			for(dicitem item:dataItem)
			{
				if(u.getStatus()==item.getDicitemid())
				{
					jo.put("status", item.getItem());
				}
				else{
					
				}
				if(u.getDicitemid()==item.getDicitemid())
				{
					jo.put("dicitem", item.getItem());
				}
			}
			jo.put("unitname",u.getUnitname());
			jo.put("unitaddress",u.getAddress());
			jo.put("MSpeople", u.getMspeople());
			jo.put("MSphone", u.getMspeople());
			jo.put("unitmemo", u.getMemo());
			data.add(jo);
		}
		//服务福安分页需要返回total 和rows
		jototal.put("total", count);
		jototal.put("rows", data);
		datatotal.add(jototal);
		return datatotal;
	}
}
