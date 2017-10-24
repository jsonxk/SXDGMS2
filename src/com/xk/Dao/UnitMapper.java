package com.xk.Dao;

import java.util.List;

import com.xk.orm.Unit;

public interface UnitMapper {
    int deleteByPrimaryKey(Integer unitid);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitid);
    List<Unit> selectAllUnitName();
    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}