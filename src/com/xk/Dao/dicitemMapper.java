package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.dicitem;
/*
 * 字典类型项目
 */
public interface dicitemMapper {
    int deleteByPrimaryKey(Integer dicitemid);

    int insert(dicitem record);

    int insertSelective(dicitem record);

    dicitem selectByPrimaryKey(Integer dicitemid);

    int updateByPrimaryKeySelective(dicitem record);

    int updateByPrimaryKey(dicitem record);
    /*
     * @param dictypeId
     * 根绝字典类型获取详细项目
     */
    List<dicitem> selectItemByTypeid(@Param("dictypeid") Integer dictypeid);
    List<dicitem> selectAllItem();
    //添加项目
	int InsertDicItem(dicitem item);
}