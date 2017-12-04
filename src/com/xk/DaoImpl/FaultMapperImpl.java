package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.CheckDetailMapper;
import com.xk.Dao.CheckTypeMapper;
import com.xk.Dao.HangLineMapper;
import com.xk.Dao.HistoryEmailMapper;
import com.xk.Dao.PhotoMapper;
import com.xk.orm.CheckDetail;
import com.xk.orm.CheckType;
import com.xk.orm.HangLine;
import com.xk.orm.HistoryEmail;
import com.xk.orm.Photo;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月24日 下午12:48:42
 * @version :
 * 缺陷数据层
 */
@Repository
public class FaultMapperImpl implements CheckTypeMapper,CheckDetailMapper,PhotoMapper,HistoryEmailMapper{
	@Autowired
	private CheckTypeMapper checkTypeMapper;
	@Autowired
	private CheckDetailMapper checkDetailMapper;
	@Autowired
	private PhotoMapper photoMapper;
	@Autowired
	private HistoryEmailMapper historyEmailMapper;
	/**
	 * 查询缺陷类型
	 * @return
	 */
	public List<CheckType> SelectFaultType() {
		return checkTypeMapper.SelectFaultType();
	}
	/**
	 * 查询线路检查中有缺陷信息
	 * @return
	 */
	public List<CheckDetail> SelectAllFaultInfo(PublicEntity publicEntity) {
		return checkDetailMapper.SelectAllFaultInfo(publicEntity);
	}
	/**
	 * 查找缺陷图片信息
	 * @param checkdetailid
	 * @return
	 */
	public List<Photo> FaultPhoto(int checkdetailid) {
		return photoMapper.FaultPhoto(checkdetailid);
	}
	/**
	 * 把发送的整改信息添加到表中
	 * @param historyEmail
	 * @return
	 */
	public int SubmitRepairInfo(HistoryEmail historyEmail) {
		return historyEmailMapper.SubmitRepairInfo(historyEmail);
	}
}
