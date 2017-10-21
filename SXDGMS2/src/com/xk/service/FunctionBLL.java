package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Function;
import com.xk.orm.FunctionList;

@Service
public class FunctionBLL {
	@Autowired
	private AllDao allDao;
	public JSONArray selectOnUserid(Integer userid,Integer parentid)
	{
		List<FunctionList> funlist=allDao.getfunctionmapperimpl().selectOnUserid(userid, parentid);
		JSONArray fun1=new JSONArray();
		JSONArray fun2=new JSONArray();
		JSONObject jo1=new JSONObject();
		JSONObject jo2=new JSONObject();
		List<Function> list;
		for(int i=0;i<funlist.size();i++)
		{
			list=funlist.get(i).getFunList();
			for(Function f:list)
			{
				jo2.put("functionid", f.getFunctionid());
				jo2.put("name", f.getName());
				jo2.put("url", f.getUrl());
				fun2.add(jo2);
			}
			jo1.put("fid", funlist.get(i).getFunctionid());
			jo1.put("fname", funlist.get(i).getName());
			jo1.put("flist", fun2);
			fun1.add(jo1);
			//清楚子jsonarray中数据否则会累加数据
			fun2.clear();
		}
		return fun1;
	}
}
