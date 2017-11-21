package com.xk.Dao;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.xk.orm.Unit;
import com.xk.orm.UnitCount;
/*
 * 公司单位
 */
public interface UnitMapper {
    //获取所有单位信息
    List<Unit> selectAllUnitName();

    int updateByPrimaryKey(Unit record);
    //查找信息
	List<Unit> selectUnitByname(@Param("unitname")String unitname);
	//分页查找信息
	List<Unit> selectAllUnitpage(@Param("pagesize")int pagesize,@Param("offset") int offset);
	//添加单位信息
	int InsertUnit(List<Unit> dataunit);
	//删除信息
	int DelUnit(@Param("unitid")int unitid, @Param("status")int status);
	//修改信息
	int unittypeModify(List<Unit> unitlist);
	/**
	 * 查找正常状态单位
	 * @return
	 */
	List<Unit> selectAllnormalUnit(@Param("status")Integer status);
}