package com.xk.Dao;

import com.xk.orm.HangLine;

public interface HangLineMapper {
    int deleteByPrimaryKey(Integer hanglineid);

    int insert(HangLine record);

    int insertSelective(HangLine record);

    HangLine selectByPrimaryKey(Integer hanglineid);

    int updateByPrimaryKeySelective(HangLine record);

    int updateByPrimaryKey(HangLine record);
}