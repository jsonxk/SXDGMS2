package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.CheckDetailMapper;
import com.xk.Dao.CheckTypeMapper;
import com.xk.Dao.FaultMapper;
import com.xk.Dao.HangLineMapper;
import com.xk.Dao.HistoryEmailMapper;
import com.xk.Dao.LineCheckMapper;
import com.xk.Dao.NoticeMapper;
import com.xk.Dao.PhotoMapper;
import com.xk.orm.CheckDetail;
import com.xk.orm.CheckDtlNotice;
import com.xk.orm.CheckInfoCommon;
import com.xk.orm.CheckType;
import com.xk.orm.Fault;
import com.xk.orm.HangLine;
import com.xk.orm.HistoryEmail;
import com.xk.orm.LineCheck;
import com.xk.orm.Notice;
import com.xk.orm.Photo;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月24日 下午12:48:42
 * @version :
 * 缺陷数据层
 */
@Repository
public class FaultMapperImpl implements CheckTypeMapper,CheckDetailMapper,PhotoMapper,HistoryEmailMapper,LineCheckMapper,FaultMapper{
	@Autowired
	private CheckTypeMapper checkTypeMapper;
	@Autowired
	private CheckDetailMapper checkDetailMapper;
	@Autowired
	private PhotoMapper photoMapper;
	@Autowired
	private HistoryEmailMapper historyEmailMapper;
	@Autowired
	private LineCheckMapper lineCheckMapper;
	@Autowired 
	private FaultMapper faultMapper;
	@Autowired
	private NoticeMapper noticeMapper;
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
	public List<CheckDtlNotice> SelectAllFaultInfo(PublicEntity publicEntity) {
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
	/**
	 * 新建线路检查信息
	 * @param linechk
	 * @return
	 */
	public int InsertNewLineChk(LineCheck linechk) {
		lineCheckMapper.InsertNewLineChk(linechk);
		return linechk.getLinecheckid();
	}
	/**
	 * 查询搭挂线路线杆检查类型
	 * @return
	 */
	public List<CheckType> SelectLineChkType() {
		return checkTypeMapper.SelectLineChkType();
	}
	/**
	 * 新建一次检查细节
	 * @param checkinfocommon
	 * @return
	 */
	public int InsertPoleChkDtl(CheckInfoCommon checkinfocommon) {
		checkDetailMapper.InsertPoleChkDtl(checkinfocommon);
		return checkinfocommon.getCheckdetailid();
	}
	/**
	 * 新建错误信息
	 * @param fault
	 * @return
	 */
	public int InsertFaultInfo(Fault fault) {
		faultMapper.InsertFaultInfo(fault);
		return fault.getFaultid();
	}
	/**
	 * 添加照片信息
	 * @param checkinfocommon
	 * @return
	 */
	public int InsertPhotoInfo(CheckInfoCommon checkinfocommon) {
		return photoMapper.InsertPhotoInfo(checkinfocommon);
	}
	/**
	 * 添加一条notice处理错误记录
	 * @param notice
	 * @return
	 */
	public int InsertNewNotice(Notice notice) {
		return noticeMapper.InsertNewNotice(notice);
	}
	/**
	 * 修改checkdetail中processid
	 * @param checkdetailid
	 * @param faultid
	 * @param processid 
	 */
	public int ModifyCheckDtlProcess(int checkdetailid, int faultid, int processid) {
		return checkDetailMapper.ModifyCheckDtlProcess(checkdetailid,faultid,processid);
	}
	/**
	 * 修改notice表处理fault的状态
	 * @param faultid
	 * @param status
	 * @return
	 */
	public int MofidyNoticeStatus(int faultid, int status) {
		return noticeMapper.MofidyNoticeStatus(faultid,status);
	}
	/**
	 * 根据poleid查找photo信息
	 * @param poleid
	 * @return
	 */
	public List<Photo> SelectPolePhoto(int poleid) {
		return photoMapper.SelectPolePhoto(poleid);
	}
	/**
	 * 删除已经整改完整或者不用整改的错误
	 * @param checkdetailid
	 * @return
	 */
	public int DelCheckDtlFault(int checkdetailid) {
		return faultMapper.DelCheckDtlFault(checkdetailid);
	}
	/**
	 * 查询状态为整改验收的错误信息
	 * @return
	 */
	public List<CheckDetail> SelectFaultTask() {
		return checkDetailMapper.SelectFaultTask();
	}
	/**
	 * 根据applyid查找线路查勘信息
	 * @param applyid
	 * @return
	 */
	public List<CheckDetail> SelectCheckInfo(int applyid) {
		return checkDetailMapper.SelectCheckInfo(applyid);
	}
}
