package com.xk.Dao;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Notice;

public interface NoticeMapper {
	/**
	 * 添加一条Notice处理错误记录
	 * @param notice
	 * @return
	 */
	int InsertNewNotice(Notice notice);
	/**
	 * 修改notice表的处理错误的状态
	 * @param faultid
	 * @param status
	 * @return
	 */
	int MofidyNoticeStatus(@Param("faultid")int faultid, @Param("status")int status);
}