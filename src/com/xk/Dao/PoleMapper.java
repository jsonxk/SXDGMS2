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
	List<Pole> SelectPoleInfo(@Param("lineid")int lineid,@Param("poleid")int poleid);
	/**
	 * 根据lineid查找线杆数量
	 * @param lineid
	 * @return
	 */
	int SelectPoleCount(@Param("lineid") int lineid);
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
	 * @return [pole,[linedetail]]
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
	/**
	 * 删除线杆及相关的搭挂，线路详情
	 * @param poleid
	 * @return
	 */
	int DelPoleByPoleId(@Param("poleid")int poleid);
	/**
	 * 根据poleid修改prevpoleid
	 * @param poleid
	 * @return
	 */
	int ModifyPrevPoleIdByPoleId(@Param("poleid")int poleid);
}