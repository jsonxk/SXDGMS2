package com.xk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.SysParam;

/**
 * @author: xk
 * @date:2017年11月2日 下午8:54:16
 * @version :
 * 参数管理
 */
@Service
public class SysParamBLL {
	@Autowired
	private AllDao alldao;
	/*
	 * 获取参数信息
	 */
	public JSONArray SearchSysParam(String paramname, String paramtype) {
		List<SysParam> dataparam=null;
		Map<String, Object> map=new HashMap<String, Object>();
		if(paramname.equals("")&&paramtype.equals(""))
		{
			dataparam=alldao.getsysParamMapperImpl().selectAllParam();
		}
		else if(!paramname.equals("")&&!paramtype.equals("")){
			map.put("paramname", paramname);
			map.put("paramtype", Integer.parseInt(paramtype));
			dataparam=alldao.getsysParamMapperImpl().SearchSysParam(map);
		}
		else{
			map.put("paramtype", Integer.parseInt(paramtype));
			dataparam=alldao.getsysParamMapperImpl().SearchByType(map);
		}
		return JSONArray.fromObject(dataparam);
	}

}
