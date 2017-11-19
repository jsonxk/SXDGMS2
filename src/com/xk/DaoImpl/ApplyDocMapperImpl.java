package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.ApplyDocMapper;
import com.xk.orm.ApplyDoc;
import com.xk.orm.ApplyDocTime;

/**
 * @author: xk
 * @date:2017年11月15日 下午7:31:14
 * @version :
 * 
 */
@Repository
public class ApplyDocMapperImpl implements ApplyDocMapper{
	@Autowired
	private ApplyDocMapper applydoc;
	@Override
	public int InsertApplydoc(ApplyDocTime applyDocTime) {
		return applydoc.InsertApplydoc(applyDocTime);
	}
	@Override
	public List<ApplyDoc> SelectDocByApplyId(Integer applyid) {
		return applydoc.SelectDocByApplyId(applyid);
	}
	public List<ApplyDoc> SelectApplyDoc(ApplyDocTime appDocTime) {
		return applydoc.SelectApplyDoc(appDocTime);
	}
	public int ModifyApplyDoc(ApplyDocTime appDocTime) {
		return applydoc.ModifyApplyDoc(appDocTime);
	}
}
