package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.dictype;

public interface dictypeMapper {
    int deleteByPrimaryKey(Integer dictypeid);

    int insert(dictype record);

    int insertSelective(dictype record);

    dictype selectByPrimaryKey(Integer dictypeid);

    int updateByPrimaryKeySelective(dictype record);

    int updateByPrimaryKey(dictype record);
    /*
     *获取所有西点类型信息
     * @param offset偏移量
     * @param pagesize 页大小
     */
    List<dictype> selectAlltype(@Param("offset") Integer offset,@Param("pagesize")Integer pagesize);
    //获取总个数
    int selectTotalCount();
}