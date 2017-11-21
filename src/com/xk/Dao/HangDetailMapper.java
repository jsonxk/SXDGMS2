package com.xk.Dao;

import com.xk.orm.HangDetail;

public interface HangDetailMapper {
    int deleteByPrimaryKey(Integer handdetailid);

    int insert(HangDetail record);

    int insertSelective(HangDetail record);

    HangDetail selectByPrimaryKey(Integer handdetailid);

    int updateByPrimaryKeySelective(HangDetail record);

    int updateByPrimaryKey(HangDetail record);
}