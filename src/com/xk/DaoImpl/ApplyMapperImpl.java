package com.xk.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.ApplyMapper;
import com.xk.orm.ApplyStringTime;

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
	public int insertApplyInfo(ApplyStringTime applyinfo) {
	 	return applymapper.insertApplyInfo(applyinfo);
 	}
}
