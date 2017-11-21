package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.Doctype;

public interface DoctypeMapper {
	/**
	 * 查找申请状态需要的文件
	 * @param dicitemid
	 * @return
	 */
    List<Doctype> SelectDoctypeByStatus(@Param("dicitemid") Integer dicitemid);
}