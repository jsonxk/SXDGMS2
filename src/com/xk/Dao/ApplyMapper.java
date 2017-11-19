package com.xk.Dao;

import java.util.List;

import com.xk.orm.Apply;
import com.xk.orm.ApplyMore;
import com.xk.orm.PublicEntity;

public interface ApplyMapper {
	/**
	 * 添加申请信息
	 * @param applyinfo
	 * @return
	 */
    int insertApplyInfo(ApplyMore applyinfo);
    /**
     * 修改申请信息
     * @param applyinfo
     * @return
     */
	int ModifyApplyInfo(ApplyMore applyinfo);
	/**
	 * 根据参数查找信息
	 * {时间，userid，类型}
	 * @param publicentity
	 * @return
	 */
	List<ApplyMore> SelectApplyInfoAll(PublicEntity publicentity);
	/**
	 * 获取查询数据的总数
	 * @param publicEntity
	 * @return
	 */
	int SelectApplyCount(PublicEntity publicEntity);
	/**
	 * xiugai processid
	 * @param apply
	 * @return
	 */
	int ModifyProcessInstanceId(Apply apply);
}