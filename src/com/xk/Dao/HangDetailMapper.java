package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.HangDetail;
import com.xk.orm.HangDetailList;
import com.xk.orm.Pole;

public interface HangDetailMapper {
	/**
	 * 查找搭挂线杆信息
	 * @param hanglineid
	 * @return
	 */
	List<Pole> selectHangPole(@Param("hanglineid")int hanglineid);
	/**
	 * 添加搭挂线杆信息
	 * @param hangDetail2
	 * @return
	 */
	int InsertHangPoleDetail(HangDetail hangDetail2);
	/**
	 * 根据poleid查找搭挂线路信息
	 * @param poleid
	 * @return
	 */
	List<HangDetailList> SelectHangLineByPoleid(@Param("poleid")int poleid);
	/**
	 * 根据hanglineid查找线杆信息
	 * @param hanglineid
	 * @return
	 */
	List<HangDetail> SelectHangPoleByHangLineid(int hanglineid);
}