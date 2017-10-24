package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Unit;

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
}
