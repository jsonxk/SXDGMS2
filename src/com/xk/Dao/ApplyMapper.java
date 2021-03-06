package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	/**
	 * 申请信息管理
	 * @param publicentity{unitid,status{!=1},time{申请批准}}
	 * @return
	 */
	List<ApplyMore> SelectApplyAndTask(PublicEntity publicentity);
	/**
	 * 除提交申请外总数
	 * @param publicEntity
	 * @return
	 */
	int SelectApplyALLCount(PublicEntity publicEntity);
	/**
	 * 修改hanglineid,status
	 * @param dicitemid
	 * @param hanglineid
	 * @param applyid
	 * @return
	 */
	//int ModifyApplyStatus(Integer dicitemid, int hanglineid, int applyid);
	/**
	 * 删除apply以及相关applydoc
	 * @param applyid
	 * @return
	 */
	int DelApplyAndApplyDoc(@Param("applyid")int applyid);
	/**
	 * 查询处于查看或者施工验收状态的申请
	 * @return
	 */
	List<ApplyMore> SelectApplyCheckTask();
}