package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Unit;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

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
	public JSONArray selectUnitByname(String unitname,String unitstatus,int pagesize,int offset)
	{
		//单位总数
		int count=0;
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
			count=dataunit.size();
		}
		for(Unit u:dataunit)
		{	
			jo.put("status","");
			jo.put("dicitem","");
			for(dicitem item:dataItem)
			{
				//状态
				if(u.getStatus()==item.getDicitemid())
				{
					jo.put("status", item.getItem());
				}
				//单位类型
				if(u.getDicitemid()==item.getDicitemid())
				{
					jo.put("dicitem", item.getItem());
				}
			}
			jo.put("unitid", u.getUnitid());
			jo.put("unitname",u.getUnitname());
			jo.put("unitaddress",u.getAddress());
			jo.put("MSpeople", u.getMspeople());
			jo.put("MSphone", u.getMsphone());
			jo.put("unitmemo", u.getMemo());
			if(jo.get("status").equals(unitstatus))
			{
				count++;
				data.add(jo);
			}
		}
		//服务端分页需要返回total 和rows
		jototal.put("total", count);
		jototal.put("rows", data);
		datatotal.add(jototal);
		return datatotal;
	}
	/*
	 * 查找单位类型
	 */
	public List<dicitem> SelectUnitType(String unittype){
		List<dictype> datatype=allDao.getdictypeMapperImpl().selectAllTypeNoParam();
		List<dicitem> dataitem=null;
		for(dictype dic:datatype)
		{
			if(dic.getDicname().equals(unittype))
			{
				dataitem=allDao.getdicitemMapperImpl().selectItemByTypeid(dic.getDictypeid());
			}
		}
		return dataitem;
	}
	//添加单位信息
	public boolean InsertUnit(List<Unit> dataunit)
	{
		List<dicitem> dic=allDao.getdicitemMapperImpl().selectAllItem();
		for(dicitem item:dic)
		{
			if(item.getItem().equals("正常"))
			{
				dataunit.get(0).setStatus(item.getDicitemid());
			}
		}
		int i=allDao.getunitMapperImpl().InsertUnit(dataunit);
		if(i>0)
		{
			return true;
		}
		else 
			return false;
	}
	//删除单位
	public boolean DelUnit(int unitid) {
		List<dicitem> dataitem=allDao.getdicitemMapperImpl().selectAllItem();
		int status=0;
		for(dicitem dic:dataitem)
		{
			if(dic.getItem().equals("已删除"))
			{
				status=dic.getDicitemid();
			}
		}
		int i=allDao.getunitMapperImpl().DelUnit(unitid,status);
		if(i>0)
			return true;
		else
			return false;
	}
	public boolean unittypeModify(List<Unit> unitlist) {
		int i=allDao.getunitMapperImpl().unittypeModify(unitlist);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
}
