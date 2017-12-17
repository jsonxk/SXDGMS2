package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.ApplyMapper;
import com.xk.orm.Apply;
import com.xk.orm.ApplyDocTime;
import com.xk.orm.ApplyMore;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月13日 下午11:10:24
 * @version :
 * 
 */
@Repository
public class ApplyMapperImpl implements ApplyMapper{
	@Autowired
	private ApplyMapper applymapper;
	@Override
	public int insertApplyInfo(ApplyMore applyinfo) {
		//ApplyStringTime info=new ApplyStringTime();
		applymapper.insertApplyInfo(applyinfo);
		return applyinfo.getApplyid();
 	}
	@Override
	public int ModifyApplyInfo(ApplyMore applyStringTime) {
		return applymapper.ModifyApplyInfo(applyStringTime);
	}
	public List<ApplyMore> SelectApplyInfoAll(PublicEntity publicentity) {
		return applymapper.SelectApplyInfoAll(publicentity);
	}
	@Override
	public int SelectApplyCount(PublicEntity publicEntity) {
		return applymapper.SelectApplyCount(publicEntity);
	}
	/**
	 * 修改申请apply表中的status，hanglineid
	 * @param dicitemid
	 * @param hanglineid
	 * @param applyid
	 */
	public int ModifyProcessInstanceId(Apply apply) {
		return applymapper.ModifyProcessInstanceId(apply);
	}
	@Override
	public List<ApplyMore> SelectApplyAndTask(PublicEntity publicentity) {
		// TODO Auto-generated method stub
		return applymapper.SelectApplyAndTask(publicentity);
	}
	@Override
	public int SelectApplyALLCount(PublicEntity publicEntity) {
		// TODO Auto-generated method stub
		return applymapper.SelectApplyALLCount(publicEntity);
	}
	/**
	 * 修改申请apply表中的status，hanglineid
	 * @param dicitemid
	 * @param hanglineid
	 * @param applyid
	 */
	/*public int ModifyApplyStatus(Integer dicitemid, int hanglineid, int applyid) {
		return applymapper.ModifyApplyStatus(dicitemid,hanglineid,applyid);
	}*/
}
