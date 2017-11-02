package com.xk.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.SysParam;

public interface SysParamMapper {
    /*
     * 所有参数信息
     */
    List<SysParam> selectAllParam();
    /*
     * 查找系统参数
     * @param 名称
     * @param 类型
     */
	List<SysParam> SearchSysParam(Map<String, Object> map);
	/*
	 * 查找系统参数
	 * @param 类型
	 */
	List<SysParam> SearchByType(Map<String, Object> map);
}