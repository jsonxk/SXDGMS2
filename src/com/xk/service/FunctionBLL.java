package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Function;
import com.xk.orm.FunctionList;
import com.xk.orm.RoleFunction;

@Service
public class FunctionBLL {
	@Autowired
	private AllDao allDao;
	/*
	 * @param userid
	 * @param parentid=0;(父节点)
	 * 返回list<FunctionList>
	 */
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
	/*
	 * 返回树节点所有功能
	 */
	public JSONArray selectFuncByRoleid(Integer roleid)
	{
		JSONArray ja=new JSONArray();
		//所有功能信息
		List<FunctionList> funclist;
		funclist=allDao.getfunctionmapperimpl().selectallFunction();
		//某个角色功能信息
		List<Function> list=null;
		if(roleid>0)
		{
			list=allDao.getfunctionmapperimpl().selectFuncByRoleid(roleid);
			ja=FuncChange(funclist,list);
		}
		else{
			ja=FuncChange(funclist,list);
		}
		return ja;
	}
	public JSONArray FuncChange(List<FunctionList> funclist,List<Function> list)
	{
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject(); 
		JSONArray finaldata=new JSONArray();
		JSONObject finalobj=new JSONObject(); 
		//所有父功能节点
		for(FunctionList funcl:funclist)
		{
			int count=0;
			//子功能节点
			for(Function func:funcl.getFunList())
			{
				//子功能加入父功能
				if(func.getParentid()==funcl.getFunctionid())
				{
					jo.put("id",func.getFunctionid());
					jo.put("text", func.getName());
					jo.put("level", 0);
					jo.put("tag", 0);
					jo.put("state", "{checked:false}");
					//判断roleid的功能是不是为空
					if(list!=null)
					{
						for(Function f:list)
						{
							if(f.getFunctionid()==func.getFunctionid())
							{
								jo.put("state", "{checked:true}");
								//某个父功能下的子功能有几个
								count++;
							}
						}
					}
					else{
						//待定
					}
				}
				ja.add(jo);
				
			}
			if(count==funcl.getFunList().size())
			{
				finalobj.put("state", "{checked:true}");
			}
			else{
				finalobj.put("state", "{checked:false}");
			}
			finalobj.put("id", funcl.getFunctionid());
			finalobj.put("text", funcl.getName());
			finalobj.put("level",0);
			finalobj.put("tag", 0);
			finalobj.put("nodes", ja);
			finaldata.add(finalobj);
			ja.clear();
		}
		return finaldata;
	}
	//修改功能
	public boolean modifyFunc(List<Object> list)
	{
		JSONArray ja=JSONArray.fromObject(list);
		RoleFunction rf=new RoleFunction();
		int roleid=0;
		int functionid=0;
		int parentid=0;
		int flag=0;
		//数据执行结果
		int rel=0;
		JSONObject job=new JSONObject();
		for(int i=0;i<ja.size();i++)
		{
			  job= ja.getJSONObject(i);
			  roleid=(Integer) job.get("roleid");
			  functionid=(Integer) job.get("functionid");
			  parentid=(Integer) job.get("parentid");
			  flag=(Integer) job.get("flag");
			  rf.setRoleid(roleid);
			  rf.setFunctionid(functionid);
			  rf.setParentid(parentid);
			  if(flag==1)
			  {
				  //添加功能
				  rel=allDao.getRolefunctionMapeerImpl().insertFunc(rf);
			  }
			  else if(flag==0)
			  {
				  //删除功能
				  rel=allDao.getRolefunctionMapeerImpl().deleteFunc(rf);
			  }
		}
		if(rel>0)
		{
			return true;
		}
		else 
			return false;
	}
}
