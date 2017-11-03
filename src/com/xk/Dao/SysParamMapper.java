package com.xk.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.SysParam;
import com.xk.orm.SysParamInfo;

public interface SysParamMapper {
    /*
     * 所有参数信息
     */
    List<SysParamInfo> selectAllParam();
    /*
     * 查找系统参数
     * @param 名称
     * @param 类型
     */
	List<SysParamInfo> SearchSysParam(Map<String, Object> map);
	/*
	 * 查找系统参数
	 * @param 类型
	 */
	List<SysParamInfo> SearchByType(Map<String, Object> map);
	/*
	 * 添加参数信息
	 */
	int InsertParam(SysParam param);
	/*
	 * 修改参数信息
	 */
	int ModifyParam(SysParam param);
	/*
	 * 删除信息
	 */
	int DelParam(@Param("sysparamid")int sysparamid);
}