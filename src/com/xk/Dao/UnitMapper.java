package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.xk.orm.Unit;
import com.xk.orm.UnitCount;
/*
 * 公司单位
 */
public interface UnitMapper {
    int deleteByPrimaryKey(Integer unitid);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitid);
    //获取所有单位信息
    List<Unit> selectAllUnitName();
    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
    //查找信息
	List<Unit> selectUnitByname(@Param("unitname")String unitname);
	//分页查找信息
	List<Unit> selectAllUnitpage(@Param("pagesize")int pagesize,@Param("offset") int offset);
	//添加单位信息
	int InsertUnit(List<Unit> dataunit);
	//删除信息
	int DelUnit(@Param("unitid")int unitid, @Param("status")int status);

	int unittypeModify(List<Unit> unitlist);
}