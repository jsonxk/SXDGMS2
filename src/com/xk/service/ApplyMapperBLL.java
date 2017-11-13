package com.xk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.ApplyStringTime;

/**
 * @author: xk
 * @date:2017年11月13日 下午11:07:27
 * @version :
 * 
 */
@Service
public class ApplyMapperBLL {
	@Autowired
	private AllDao alldao;
	/**
	 * 添加申请信息
	 * @param applyStringTime
	 * @return
	 */
	public boolean InsertApplyInfo(ApplyStringTime applyStringTime)
	{
		int i=alldao.getApplyMapperImpl().insertApplyInfo(applyStringTime);
		if(i>0)
		{
			return true;
		}
		else
			return true;
	}
}
