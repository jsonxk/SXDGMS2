package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.ActivitiUtil.EnumData;
import com.xk.DaoImpl.AllDao;
import com.xk.Util.SendMailDemo;
import com.xk.orm.CheckDetail;
import com.xk.orm.CheckType;
import com.xk.orm.HangLine;
import com.xk.orm.HistoryEmail;
import com.xk.orm.LineCheck;
import com.xk.orm.Photo;
import com.xk.orm.PublicEntity;
import com.xk.orm.Unit;

/**
 * @author: xk
 * @date:2017年11月24日 下午12:43:55
 * @version :
 * 缺陷管理逻辑层
 */
@Service
public class FaultBLL {
	@Autowired
	private AllDao alldao;
	/**
	 * 查询缺陷类型
	 * @return
	 */
	public JSONArray SelectFaultType() {
		List<CheckType> data=alldao.getFaultMapperImpl().SelectFaultType();
		List<CheckType> datatype=new ArrayList<CheckType>();
		CheckType objcheck=new CheckType();
		objcheck.setChecktypeid(0);
		objcheck.setName("全部类型");
		datatype.add(objcheck);
		datatype.removeAll(data);
		datatype.addAll(data);
		return JSONArray.fromObject(datatype);
	}
	/**
	 * 查询所有缺陷信息
	 * @param publicEntity
	 * @return
	 */
	public JSONArray SelectAllFaultInfo(PublicEntity publicEntity) {
		/**
		 * 获取所有线路检查信息中有缺陷的部分
		 */
		List<CheckDetail> ListChkDtl=alldao.getFaultMapperImpl().SelectAllFaultInfo(publicEntity);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		for(CheckDetail checkDetail:ListChkDtl)
		{
			//checkDetail.setCreatetime(null);
			if(checkDetail.getCreatetime()!=null)
			{
				checkDetail.setTimeString(format.format(checkDetail.getCreatetime()));
			}
		}
		return JSONArray.fromObject(ListChkDtl);
	}
	/**
	 * 根据poleid掺杂或单位，搭挂线路信息
	 * @param poleid
	 * @return
	 */
	public JSONArray FaultPoleOfLine(int poleid) {
		List<HangLine> hanglist=alldao.getHangLineMapperImpl().FaultPoleOfLine(poleid);
		return JSONArray.fromObject(hanglist);
	}
	/**
	 * 根据checkdtlid查找图片信息
	 * @param checkdetailid
	 * @return
	 */
	public JSONArray FaultPhoto(int checkdetailid) {
		List<Photo> photoList=alldao.getFaultMapperImpl().FaultPhoto(checkdetailid);
		return JSONArray.fromObject(photoList);
	}
	/**
	 * 发送整改信息
	 * @param historyEmail{subject,context,taskid,unitid,userid,Docpath}
	 * @return
	 */
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private TaskService taskService;
	public JSONArray SubmitRepairInfo(HistoryEmail historyEmail) {
		List<Unit> unitlist=alldao.getunitMapperImpl().selectAllUnitName();
		for(Unit unit:unitlist)
		{
			if(unit.getUnitid()==historyEmail.getUnitid())
			{
				historyEmail.setToaddress(unit.getEmailaddress());
			}
		}
		historyEmail.setSendaddress(EnumData.SendAddress);
		new SendMailDemo().run(historyEmail);
		/**
		 * 添加发送邮件信息
		 */
		int Emailinfo=alldao.getFaultMapperImpl().SubmitRepairInfo(historyEmail);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("type", 1);
		taskService.complete(historyEmail.getTaskid()+"",map);
		return null;
	}
	/**
	 * 新建线路检查
	 * @param linechk
	 * @return  jsonarray{"linechkid":value}
	 */
	public JSONArray InsertNewLineChk(LineCheck linechk) {
		Date date=new Date();
		linechk.setCreatetime(date);
		int linechkid=alldao.getFaultMapperImpl().InsertNewLineChk(linechk);
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		if(linechkid>0)
		{
			jo.put("linecheckid", linechkid);
			ja.add(jo);
		}
		return ja;
	}
	/**
	 * 查询搭挂线路线杆查找类型
	 * @return
	 */
	public JSONArray SelectLineChkType() {
		List<CheckType> chkTypeList=alldao.getFaultMapperImpl().SelectLineChkType();	
		return JSONArray.fromObject(chkTypeList);
	}
	
}
