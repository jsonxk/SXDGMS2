package com.xk.Dao;

import com.xk.orm.Apply;
import com.xk.orm.ApplyStringTime;

public interface ApplyMapper {
	/**
	 * 添加申请信息
	 * @param applyinfo
	 * @return
	 */
    int insertApplyInfo(ApplyStringTime applyinfo);
}