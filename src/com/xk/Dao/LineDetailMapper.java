package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.LineDetail;
import com.xk.orm.LineDetailList;
import com.xk.orm.Pole;

public interface LineDetailMapper {
	/**
	 * 添加线路明细信息
	 * @param powerLine
	 * @return
	 */
	int InsertLinePoleDetail(Pole powerLine);
 /*   int deleteByPrimaryKey(Integer linedetailid);

    int insert(LineDetail record);

    int insertSelective(LineDetail record);

    LineDetail selectByPrimaryKey(Integer linedetailid);

    int updateByPrimaryKeySelective(LineDetail record);

    int updateByPrimaryKey(LineDetail record);*/
	/**
	 * 添加线路线杆明细信息
	 * @param lineDetail
	 * @return
	 */
	int insertPoleLineDetail(LineDetail lineDetail);
	/**
	 * 查找电力线路
	 * @param poleid
	 * @return
	 */
	List<LineDetailList> SelectAllLineIdByPoleid(@Param("poleid")int poleid);
	/**
	 * 根据poleid直接查找所有信息
	 * @param poleid
	 * @return
	 */
	List<LineDetail> selectAllHangDetail(@Param("poleid") int poleid);
	/**
	 * 批量添加电力线路细节
	 * @param linedetail
	 * @return
	 */
	int InsertLineDetailList(LineDetailList linedetail);
}