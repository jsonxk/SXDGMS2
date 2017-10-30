package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.dictype;

/**
 * @author: xk
 * @date:2017年10月27日 下午11:41:24
 * @version :
 * 
 */
@Service
public class DicTypeBLL {
	@Autowired
	private AllDao alldao;
	//左边字典类型表分页查找信息
	public JSONArray selectAlltype(Integer offset,Integer pagesize,String typename){
		JSONArray data=new JSONArray();
		JSONArray datatotal=new JSONArray();
		JSONObject jobj=new JSONObject();
		JSONObject jobjtotal=new JSONObject();
		List<dictype> dicList=null;
		int total=0;
		if(typename.equals(""))
		{
			//初始化加载信息
			dicList=alldao.getdictypeMapperImpl().selectAlltype(offset, pagesize);
		}
		else{
			//查询信息
			dicList=alldao.getdictypeMapperImpl().selectTypeByInfo(typename);
		}
		for(dictype dic:dicList)
		{
			jobj.put("dictypeid", dic.getDictypeid());
			jobj.put("dicname", dic.getDicname());
			jobj.put("dicmemo", dic.getMemo());
			data.add(jobj);
		}
		total=alldao.getdictypeMapperImpl().selectTotalCount();
		jobjtotal.put("total", total);
		jobjtotal.put("rows", data);
		datatotal.add(jobjtotal);
		return datatotal;
	}
	//获取所有的dictype信息
	public List<dictype> selectAllTypeNoParam(){
		return alldao.getdictypeMapperImpl().selectAllTypeNoParam();
	}
	//删除dictype信息
	public boolean DelDictype(Integer dictypeid){
		int i=alldao.getdictypeMapperImpl().DelDictype(dictypeid);
		if(i>0)
		{
			return true;
		}
		else 
			return false;
	}
	public boolean InsertDictype(dictype dictype){
		int i=alldao.getdictypeMapperImpl().InsertDictype(dictype);
		if(i>0)
		{
			return true;
		}
		else{
			return false;
		}
	}
}
