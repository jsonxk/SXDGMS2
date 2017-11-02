package com.xk.DaoImpl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.SysParamMapper;
import com.xk.orm.SysParam;

/**
 * @author: xk
 * @date:2017年11月2日 下午8:56:20
 * @version :
 * 
 */
@Repository
public class SysParamMapperImpl {
	@Autowired
	private SysParamMapper sysParamMapper;
	/*
	 * 查找系统参数信息
	 */
	public List<SysParam> SearchSysParam(Map<String, Object> map) {
		return sysParamMapper.SearchSysParam(map);
	}
	/*
	 * 所有参数信息
	 */
	public List<SysParam> selectAllParam(){
		return sysParamMapper.selectAllParam();
	}
	public List<SysParam> SearchByType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sysParamMapper.SearchByType(map);
	}
	
}
