package com.xk.service;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.dicitem;

/**
 * @author: xk
 * @date:2017年10月28日 下午9:28:51
 * @version :
 * 
 */
@Service
public class DicitemBLL {
	@Autowired
	private AllDao alldao;
	public JSONArray selectItemByTypeid(int dictypeid)
	{
		List<dicitem> datalist=null;
		datalist=alldao.getdicitemMapperImpl().selectItemByTypeid(dictypeid);
		return JSONArray.fromObject(datalist);
	}
}
