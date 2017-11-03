package com.xk.DaoImpl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.SysParamMapper;
import com.xk.orm.SysParam;
import com.xk.orm.SysParamInfo;

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
	public List<SysParamInfo> SearchSysParam(Map<String, Object> map) {
		return sysParamMapper.SearchSysParam(map);
	}
	/*
	 * 所有参数信息
	 */
	public List<SysParamInfo> selectAllParam(){
		return sysParamMapper.selectAllParam();
	}
	public List<SysParamInfo> SearchByType(Map<String, Object> map) {
		return sysParamMapper.SearchByType(map);
	}
	public int InsertParam(SysParam param) {
		return sysParamMapper.InsertParam(param);
	}
	public int ModifyParam(SysParam param) {
		return sysParamMapper.ModifyParam(param);
	}
	public int DelParam(int sysparamid) {
		return sysParamMapper.DelParam(sysparamid);
	}
	
}
