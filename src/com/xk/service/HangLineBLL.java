package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

/**
 * @author: xk
 * @date:2017年11月9日 下午6:09:31
 * @version :
 * 
 */
@Service
public class HangLineBLL {
	@Autowired
	private AllDao alldao;
	/*
	 * 所有申请线路的状态
	 */
	public JSONArray SelectHangLineStatus(String typename)
	{
		List<dictype> typelist=alldao.getdictypeMapperImpl().selectTypeByInfo(typename);
		List<dicitem> typeitem=null;
		JSONArray data=new JSONArray();
		JSONObject jodata=new JSONObject();
		for(dictype type:typelist)
		{
			typeitem=alldao.getdicitemMapperImpl().selectItemByTypeid(type.getDictypeid());
			for(dicitem item:typeitem)
			{
				jodata.put("dicitemid", item.getDicitemid());
				jodata.put("item", item.getItem());
				jodata.put("Code", item.getCode());
				jodata.put("memo", item.getMemo());
				data.add(jodata);
			}
		}
		return data;
	}
}
