package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.CheckInfoCommon;
import com.xk.orm.Photo;

public interface PhotoMapper {

	/**
	 * 根据checkdetailid查找缺陷图片信息
	 * @param checkdetailid
	 * @return
	 */
	List<Photo> FaultPhoto(@Param("checkdetailid")int checkdetailid);
	/**
	 * 添加照片信息
	 * @param checkinfocommon
	 * @return
	 */
	int InsertPhotoInfo(CheckInfoCommon checkinfocommon);
  
}