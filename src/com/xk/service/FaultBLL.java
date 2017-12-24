package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.ActivitiUtil.EnumData;
import com.xk.DaoImpl.AllDao;
import com.xk.Util.SendMailDemo;
import com.xk.orm.ApplyMore;
import com.xk.orm.CheckDetail;
import com.xk.orm.CheckDtlNotice;
import com.xk.orm.CheckInfoCommon;
import com.xk.orm.CheckType;
import com.xk.orm.Fault;
import com.xk.orm.HangLine;
import com.xk.orm.HistoryEmail;
import com.xk.orm.LineCheck;
import com.xk.orm.LineDetail;
import com.xk.orm.Notice;
import com.xk.orm.Photo;
import com.xk.orm.PublicEntity;
import com.xk.orm.Role;
import com.xk.orm.Unit;
import com.xk.orm.UserRole;
import com.xk.orm.dicitem;

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
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private IdentityService identityService;
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
		List<CheckDtlNotice> ListChkDtl=alldao.getFaultMapperImpl().SelectAllFaultInfo(publicEntity);
		List<LineDetail> linedetail=null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		for(int j=0;j<ListChkDtl.size();j++)
		{
			Date date=new Date(1970,1 , 1, 0, 0, 0);
			if(ListChkDtl.get(j).getCreatetime()!=null)
			{
				ListChkDtl.get(j).setStringtime(format.format(ListChkDtl.get(j).getCreatetime()));
			}
			if(ListChkDtl.get(j).getStatus1()==null)
			{
				ListChkDtl.get(j).setStatusname("缺陷上报");
				ListChkDtl.get(j).setStatus1(11);
			}
			/*else if(ListChkDtl.get(j).getStatusname()=="整改完成")
			{
				ListChkDtl.remove(j);
			}*/
			if(ListChkDtl.get(j).getCreatetime1()==null)
			{
				ListChkDtl.get(j).setCreatetime1(date);
			}
			/**
			 * 查询错误线杆的名称
			 */
			linedetail=alldao.getLinePoleMapperImpl().selectAllHangDetail(ListChkDtl.get(j).getPoleid());
			if(linedetail.size()>0)
			{
				ListChkDtl.get(j).setPolename(linedetail.get(0).getName());
			}
		}
		return JSONArray.fromObject(ListChkDtl);
	}
	/**
	 * 租用单位查看缺陷信息
	 * @param publicEntity
	 * @return
	 */
	public JSONArray SelectRentFaultInfo(PublicEntity publicEntity) {
		/**
		 * 获取所有线路检查信息中有缺陷的部分
		 */
		List<CheckDtlNotice> ListChkDtl=alldao.getFaultMapperImpl().SelectAllFaultInfo(publicEntity);
		List<CheckDtlNotice> finaldata=new ArrayList<CheckDtlNotice>();
		List<LineDetail> linedetail=null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		for(int j=0;j<ListChkDtl.size();j++)
		{
			Date date=new Date(1970,1 , 1, 0, 0, 0);
			if(ListChkDtl.get(j).getCreatetime()!=null)
			{
				ListChkDtl.get(j).setStringtime(format.format(ListChkDtl.get(j).getCreatetime()));
			}
			if(ListChkDtl.get(j).getStatus1()==null)
			{
				ListChkDtl.get(j).setStatusname("缺陷上报");
				ListChkDtl.get(j).setStatus1(11);
			}
			/*else if(ListChkDtl.get(j).getStatusname()=="整改完成")
			{
				ListChkDtl.remove(j);
			}*/
			if(ListChkDtl.get(j).getCreatetime1()==null)
			{
				ListChkDtl.get(j).setCreatetime1(date);
			}
			/**
			 * 查询错误线杆的名称
			 */
			linedetail=alldao.getLinePoleMapperImpl().selectAllHangDetail(ListChkDtl.get(j).getPoleid());
			if(linedetail.size()>0)
			{
				ListChkDtl.get(j).setPolename(linedetail.get(0).getName());
			}
			//System.out.println(JSONArray.fromObject(ListChkDtl));
		}
		int k=0;
		for(int i=0;i<ListChkDtl.size();i++)
		{
			if(ListChkDtl.get(i).getUnitid1()!=null)
			{
				k++;
				if(publicEntity.getUnitid()==ListChkDtl.get(i).getUnitid1())
				{
					finaldata.add(ListChkDtl.get(i));
					System.out.println(JSONArray.fromObject(finaldata));
				}
			}
		}
		System.out.println(k+"擦擦擦");
		return JSONArray.fromObject(finaldata);
	}
	/**
	 * 根据poleid掺杂或单位，搭挂线路信息
	 * @param poleid
	 * @return
	 */
	public JSONArray FaultPoleOfLine(int poleid) {
		List<HangLine> hanglist=alldao.getHangLineMapperImpl().FaultPoleOfLine(poleid);
		List<LineDetail> linedtlList=null;
		for(HangLine hl:hanglist)
		{
			linedtlList=alldao.getLinePoleMapperImpl().selectAllHangDetail(hl.getPoleid());
			hl.setName(linedtlList.get(0).getName());
		}
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
	/**
	 * 添加线杆检查细节
	 * @param checkinfocommon
	 * @return checkdtl主键id
	 */
	public int InsertPoleChkDtl(CheckInfoCommon checkinfocommon) {
		/**
		 * 本次检查细节id
		 * 有错误返回主键id
		 */
		int checkdetailId=0;
		int faultid=0;
		/**
		 * 1表示表示只是正常检查信息没有上报错误
		 */
		//SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(checkinfocommon.getChecktypeid()==1)
		{
			//checkinfocommon.setChkDtlCreatetime(format.format(checkinfocommon.getStringchkDtlCreatetime()));
			checkdetailId=alldao.getFaultMapperImpl().InsertPoleChkDtl(checkinfocommon);
		}
		else{
			Fault fault=new Fault();
			fault.setMemo(checkinfocommon.getChkDtlDescription());
			fault.setStringtime(checkinfocommon.getStringchkDtlCreatetime());
			faultid=alldao.getFaultMapperImpl().InsertFaultInfo(fault);
			checkinfocommon.setFaultid(faultid);
			checkdetailId=alldao.getFaultMapperImpl().InsertPoleChkDtl(checkinfocommon);
		}
		return checkdetailId;
	}
	/**
	 * 添加拍摄图片信息
	 * @param checkinfocommon
	 * @return
	 */
	public boolean InsertPhotoInfo(CheckInfoCommon checkinfocommon) {
		int i=alldao.getFaultMapperImpl().InsertPhotoInfo(checkinfocommon);
		if(i>0)
		{
			return true;	
		}
		else{
			return false;
		}
	}
	/**
	 * 开启缺陷整改流程
	 * @param userid
	 * @param faultid
	 * @param checkdetailid
	 * @param unitid
	 * @param status 
	 * @return
	 */
	public JSONArray StartRepairAct(int userid, int faultid, int checkdetailid,
			int unitid, int status){
		int count=0;
		/**
		 * 所有角色
		 */
		List<Role> repairUser=alldao.getRoleMapperImpl().selectAllRole();
		int RunUserId=0;
		for(Role role:repairUser)
		{
			if(role.getName().equals(EnumData.RunUsers))
			{
				RunUserId=role.getRoleid();
			}
		}
		/**
		 * 线路运行单位所有用户
		 */
		List<UserRole> allRunUser=alldao.getuserRoleMapperLmpl().SelectRepairUsers(RunUserId);
		for(UserRole ur:allRunUser)
		{
			if(ur.getUserid()==userid)
			{
				count++;
			}
		}
		/**
		 * 用户有权限开启流程
		 */
		if(count>0)
		{
			//开启流程
			runtimeService=processEngine.getRuntimeService();
			Map<String, Object> map=new HashMap<String, Object>();
			/**
			 * 设置提交申请的用户
			 */
			map.put("repairuser", userid+"");
			identityService=processEngine.getIdentityService();
			ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(EnumData.RepairKey, map);
			/**
			 * 当前任务
			 */
			Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
			// 添加批注时候的审核人，通常应该从session获取
			Authentication.setAuthenticatedUserId(userid+"");
			taskService.addComment(task.getId(),processInstance.getId(),"repairprocess");
			taskService.complete(task.getId());
			/**
			 * 1.新建一个Fault处理信息->notice表
			 * 2.修改检查细节中该细节的taskid和processid
			 */
			Notice notice=new Notice();
			notice.setProccessid1(Integer.parseInt(processInstance.getId()));
			notice.setCreatetime1(new Date());
			notice.setFaultid1(faultid);
			notice.setUnitid1(unitid);
			notice.setStatus1(status+1);
			//no
			/**
			 * 天假一条notice处理记录
			 */
			alldao.getFaultMapperImpl().InsertNewNotice(notice);
			/**
			 * 修改checkdetail表中processid
			 */
			alldao.getFaultMapperImpl().ModifyCheckDtlProcess(checkdetailid,faultid,Integer.parseInt(processInstance.getId()));
			return JSONArray.fromObject("[{'msg':'启动缺陷整改流程'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'您没有权限处理本任务'}]");
		}
	}
	/**
	 * 处理当前任务
	 * @param userid
	 * @param processid
	 * @param faultid
	 * @param status 
	 * @param handtype{0，1(0只有在有网关时才有)}
	 * @return
	 */
	public JSONArray HanderRepairAct(int userid, int processid, int faultid,
			int handtype, int status) {
		taskService=processEngine.getTaskService();
		List<Task> task=taskService.createTaskQuery().processInstanceId(processid+"").taskCandidateUser(userid+"").list();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("type", handtype+"");
		if(task.size()>0)
		{
			/**
			 * 1.完成当前任务
			 * 2.修改niotice表状态
			 */
			Authentication.setAuthenticatedUserId(userid+"");
			taskService.addComment(task.get(0).getId(), processid+"", processid+"");
			taskService.complete(task.get(0).getId(), map);
			/**
			 * 找到完成后的下一个任务名称
			 */
			task=taskService.createTaskQuery().processInstanceId(processid+"").list();
			if(task.size()>0)
			{
				System.out.println(task.get(0).getName()+"我是任务");
				List<dicitem> dicitem=alldao.getdicitemMapperImpl().selectItemByName(task.get(0).getName());
				alldao.getFaultMapperImpl().MofidyNoticeStatus(faultid,dicitem.get(0).getDicitemid());
			}
			return JSONArray.fromObject("[{'msg':'处理成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'您没有权限处理'}]");	
		}
	}
	/**
	 * 发送整改信息
	 * @param localpath 
	 * @param historyEmail{subject,context,taskid,unitid,userid,Docpath}
	 * @return
	 */
	public JSONArray SubmitRepairInfo(HistoryEmail historyEmail, String localpath) {
		List<Task> task=GetTaskId(historyEmail);
		List<Unit> unitlist=null;
		Map<String, String> rtnMap=new HashMap<String, String>();
		if(task.size()>0)
		{
			unitlist=alldao.getunitMapperImpl().selectAllUnitName();
			/**
			 * 设置要发送单位邮件接受地址
			 */
			for(Unit unit:unitlist)
			{
				if(unit.getUnitid()==historyEmail.getUnitid())
				{
					historyEmail.setToaddress(unit.getEmailaddress());
				}
			}
			/**
			 * 发送地址
			 */
			historyEmail.setSendaddress(EnumData.SendAddress);
			/**
			 * 发送邮件
			 */
			new SendMailDemo().run(historyEmail,localpath);
			/**
			 * 添加发送邮件信息
			 */
			alldao.getFaultMapperImpl().SubmitRepairInfo(historyEmail);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("type",1);
			Authentication.setAuthenticatedUserId(historyEmail.getUserid()+"");
			taskService.addComment(task.get(0).getId(),historyEmail.getProcessid()+"", historyEmail.getProcessid()+"");
			taskService.setVariable(task.get(0).getId(),"unitid",historyEmail.getUnitid());
			//System.out.println(task.get(0).getId()+"测试taskid");
			taskService.complete(task.get(0).getId(),map);
			/**
			 * 修改搭挂线路错误的状态
			 */
			alldao.getFaultMapperImpl().MofidyNoticeStatus(historyEmail.getFaultid(),historyEmail.getStatus()+1);
			//task=GetNextTaskId(historyEmail);
			//if(task.size()>0)
			//{
				//taskService.setVariable(task.get(0).getId(),"unitid",historyEmail.getUnitid());
				//System.out.println(task.get(0).getId()+"测试taskid");
				//task=GetNextTaskId(historyEmail);	
				//taskService.complete(task.get(0).getId(),map);
			//}
			//else{
			//}
			return JSONArray.fromObject("[{'msg':'发送邮件成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'您没有权限处理此业务'}]");
		}
	}
	public List<Task> GetTaskId(HistoryEmail historyEmail){
		List<Task> task=taskService.createTaskQuery().processInstanceId(historyEmail.getProcessid()+"").taskCandidateUser(historyEmail.getUserid()+"").list();
		return task;
	}
	public List<Task> GetNextTaskId(HistoryEmail historyEmail){
		List<Task> task=taskService.createTaskQuery().processInstanceId(historyEmail.getProcessid()+"").list();
		return task;
	}
	/**
	 * 删除整改完成或者不用整改的错误
	 * @param checkdetailid
	 * @return
	 */
	public boolean DelCheckDtlFault(int checkdetailid) {
		int i=alldao.getFaultMapperImpl().DelCheckDtlFault(checkdetailid);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 查询所有查勘，整改验收任务
	 * @return
	 */
	public JSONArray SelectTasks() {
		/**
		 * 获取查勘，施工验收任务
		 */
		List<ApplyMore> ApplyTask=alldao.getApplyMapperImpl().SelectApplyCheckTask();
		/**
		 * 查询整改验收阶段的任务
		 */
		List<CheckDetail> FaultTask=alldao.getFaultMapperImpl().SelectFaultTask();
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		jo.put("applytask", ApplyTask);
		jo.put("faulttask", FaultTask);
		ja.add(jo);
		return ja;
	}
}
