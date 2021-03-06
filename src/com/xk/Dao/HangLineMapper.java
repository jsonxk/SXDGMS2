package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.HangLine;
import com.xk.orm.PublicEntity;


public interface HangLineMapper {

	/**
	 * 查找所有的搭挂线路信息
	 * @param publicEntity
	 * @return hangline
	 */
	List<HangLine> SelectAllHangLine(PublicEntity publicEntity);
	/**
	 * 查找搭挂线路数量
	 * @param publicEntity
	 * @return int
	 */
	int SelectAllHangLineCount(PublicEntity publicEntity);
	/**
	 * 添加搭挂信息
	 * @param hangline
	 * @return
	 */
	int insertHangLine(HangLine hangline);
	/**
	 * 查找所有搭挂线路信息
	 * @return
	 */
	List<HangLine> SelectAllHangLineName();
	/**
	 * 根据poleid查找搭挂线路信息
	 * @param poleid
	 * @return
	 */
	List<HangLine> FaultPoleOfLine(@Param("poleid")int poleid);
	/**
	 * 搜索搭挂线路信息
	 * @param name
	 * @return
	 */
	List<HangLine> SelectHangInfoByName(@Param("name")String name);
	/**
	 * 根据hanglineid查找搭挂信息
	 * @param hanglineid
	 * @return
	 */
	List<HangLine> SelectHangLineByHangLineId(@Param("hanglineid")int hanglineid);
	/**
	 * 根据name查找搭挂信息
	 * @param hangname
	 * @return
	 */
	List<HangLine> SelectHangLineByName(@Param("hangname")String hangname);
	/**
	 * 根据name查找搭挂信息精确查找
	 * @param hangname
	 * @return
	 */
	List<HangLine> SelectHangLineByAllName(@Param("hangname")String hangname);
	/**
	 * 修改搭挂线路信息
	 * @param hangline
	 * @return
	 */
	int ModifyHangLine(HangLine hangline);
	/**
	 * 删除搭挂线路信息
	 * @param hanglineid
	 * @return
	 */
	int DelHangLine(@Param("hanglineid")int hanglineid);
}