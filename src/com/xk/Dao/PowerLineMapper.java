package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.PowerLine;
import com.xk.orm.PublicEntity;


public interface PowerLineMapper {
	/**
	 * 所有电力线路信息
	 * @param searchinfo{pagesize,offset,name,userid,unitid}
	 * @return
	 */
	List<PowerLine> SelectAllLine(PublicEntity searchinfo);
	/**
	 * 查找电力线路信息数量
	 * @param sPublicEntity
	 * @return
	 */
	int SelectAllLineCount(PublicEntity sPublicEntity);
	/**
	 * 添加线路
	 * @param powerLine
	 * @return{int(主键)}
	 */
	int InsertLineInfo(PowerLine powerLine);
	/**
	 * 修改首尾杆
	 * @param powerLine
	 * @return
	 */
	int ModifyLinePoleId(PowerLine powerLine);
	/**
	 * 加载所有线路信息
	 * @return {lineid，name}
	 */
	List<PowerLine> selectAllLineName();
	/**
	 * 搜索电力线路信息
	 * @param name
	 * @return
	 */
	List<PowerLine> SelectLineInfoByName(@Param("name")String name);
	/**
	 * 根据lineid查找电力线路信息
	 * @param lineid
	 * @return
	 */
	List<PowerLine> SelectLineInfoByLineId(@Param("lineid")int lineid);
	/**
	 * 修改电力线路status，type,unitid,name
	 * @param pLine
	 * @return
	 */
	int ModifyLineInfo(PowerLine pLine);
	/**
	 * 删除电力线路信息
	 * @param lineid
	 * @return
	 */
	int DelLineInfo(@Param("lineid")int lineid);
}