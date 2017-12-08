package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.sf.json.JSONArray;

import com.xk.orm.HangLine;
import com.xk.orm.Pole;

public interface PoleMapper {
	/**
	 * 根据线路查找线杆
	 * @param lineid
	 * @return
	 */
	List<Pole> SelectPoleInfo(int lineid);
	/**
	 * 添加线杆
	 * 返回主键poleid
	 */
	int InsertPoleInfo(Pole pole);
	/**
	 * 加载所有的线杆信息
	 * @return
	 */
	List<Pole> selectAllPole();
	/**
	 * 修改线杆经纬度
	 * @param pole
	 * @return
	 */
	int ModifyPolePosition(Pole pole);
	/**
	 * 根据poleid查找线杆信息
	 * @param poleid
	 * @return
	 */
	List<Pole> SelectPoleInfoByPoleId(@Param("poleid")int poleid);
	/**
	 * 搜索线杆信息
	 * @param name
	 * @return
	 */
	List<Pole> SelectPoleInfoByName(@Param("name")String name);
	/**
	 * 搜索线杆信息精确
	 * @param name
	 * @return
	 */
	List<Pole> SelectPoleInfoByAllName(@Param("name")String name);
}