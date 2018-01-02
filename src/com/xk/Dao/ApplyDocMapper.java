package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.ApplyDoc;
import com.xk.orm.ApplyDocTime;
import com.xk.orm.Doctype;


public interface ApplyDocMapper {
	/**
	 * 添加申请文件信息
	 * @param applyDocTime
	 * @return
	 */
    int InsertApplydoc(ApplyDocTime applyDocTime);
    /**
     * 根据appid查找文件信息
     * @param applyid
     * @return
     */
    List<ApplyDoc> SelectDocByApplyId(@Param("applyid")Integer applyid);
	/**
	 * 判断该申请是否上传过文件
	 * @param appDocTime
	 * @return
	 */
    List<ApplyDoc> SelectApplyDoc(ApplyDocTime appDocTime);
    /**
     * 修改申请信息
     * @param appDocTime
     * @return
     */
	int ModifyApplyDoc(ApplyDocTime appDocTime);
	/**
	 * 查找applyid申请文件信息
	 * @param applyid
	 * @return
	 */
	List<Doctype> SelectApplyDocInfo(int applyid);
}