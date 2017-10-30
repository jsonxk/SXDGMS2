package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.dictype;
/*
 * 字典类型
 */
public interface dictypeMapper {
    int deleteByPrimaryKey(Integer dictypeid);

    int insert(dictype record);

    int insertSelective(dictype record);

    dictype selectByPrimaryKey(Integer dictypeid);

    int updateByPrimaryKeySelective(dictype record);

    int updateByPrimaryKey(dictype record);
    /*
     *获取所有类型信息
     * @param offset偏移量
     * @param pagesize 页大小
     */
    List<dictype> selectAlltype(@Param("offset") Integer offset,@Param("pagesize")Integer pagesize);
    
    List<dictype> selectAllTypeNoParam();
    //获取总个数
    int selectTotalCount();
    /*
     * 查找信息
     */
    List<dictype> selectTypeByInfo(@Param("typename") String typename);

	int DelDictype(@Param("dictypeid")Integer dictypeid);

	int InsertDictype(dictype dictype);
}