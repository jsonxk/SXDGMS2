package com.xk.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Apply;
import com.xk.orm.ApplyMore;
import com.xk.orm.CheckDetail;
import com.xk.orm.Doctype;
import com.xk.orm.PublicEntity;
import com.xk.orm.Unit;
import com.xk.orm.UserInfo;
import com.xk.orm.dicitem;

/**
 * @author: xk
 * @date:2017年11月19日 下午10:23:17
 * @version :
 * 
 */
@Service
public class SqxxglBLL {
	@Autowired
	private AllDao allDao;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private TaskService taskService;
	/**
	 * 查找正常单位
	 * @param status
	 * @return{所有正常类型单位}
	 */
	public JSONArray selectAllnormalUnit(String status){
		List<dicitem> itemdata=allDao.getdicitemMapperImpl().selectAllItem();
		List<Unit> unitinfo=null;
		for(dicitem item:itemdata)
		{
			if(item.getItem().equals(status))
			{
				unitinfo=allDao.getunitMapperImpl().selectAllnormalUnit(item.getDicitemid());
			}
		}
		return JSONArray.fromObject(unitinfo);
	}
	/**
	 * 查找可处理信息
	 * @param publicEntity
	 * @return
	 */
	public JSONArray SelectApplyAndTask(PublicEntity publicEntity){
		JSONArray jadata=new JSONArray();
		JSONObject jodata=new JSONObject();
		SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * 查找需要处理的申请信息
		 */
		List<ApplyMore> applyinfo=allDao.getApplyMapperImpl().SelectApplyAndTask(publicEntity);
		taskService=processEngine.getTaskService();
		/**
		 * 当前任务
		 */
		List<Task> task=taskService.createTaskQuery().taskCandidateUser(publicEntity.getUserid()+"").orderByTaskCreateTime().desc().list();
		//System.out.println(task.size());
		//List<IdentityLink> identityLinks=null;
		for(Task t:task)
		{
			System.out.println(t.getId()+t.getName()+t.getProcessInstanceId());
			//identityLinks=taskService.getIdentityLinksForTask(t.getId());
			//for(IdentityLink link:identityLinks)
			//{
				//System.out.println(link.getUserId()+t.getAssignee()+t.getId()+t.getName()+t.getProcessInstanceId());
			//}
			for(ApplyMore appMore:applyinfo)
			{
				/**
				 * 设置时间格式
				 */
				try {
					String str = appMore.getPermitStringtime();
					if (str != null) {
						appMore.setPermitStringtime(formart.format(formart.parse(str)));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				appMore.setApplystringtime(formart.format(appMore.getApplytime()));
				if(appMore.getProcessid()!=null&&(appMore.getProcessid()!="")&&appMore.getProcessid().equals(t.getProcessInstanceId()))
				{
					appMore.setTaskId(t.getId());
				}
			}
		}
		//System.out.println());
		jodata.put("rows", JSONArray.fromObject(applyinfo));
		jodata.put("total", allDao.getApplyMapperImpl().SelectApplyALLCount(publicEntity));
		jadata.add(jodata);
		System.out.println(jadata);
		return jadata;
	}
	/**
	 * 处理当前申请任务
	 * @param applyid
	 * @param hanglineid
	 * @param handtype
	 * @param processid
	 * @param  
	 * @return
	 */
	public JSONArray HanderApply(String handermemo,int applyid,int userid, int hanglineid, int handtype,
			int processid,int unitid) {
		/**
		 * 获取当前任务
		 */
		List<Task> task=null;
		task=taskService.createTaskQuery().processInstanceId(processid+"").taskCandidateUser(userid+"").list();
		Date nowdate=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(task.size()>0)
		{
			Map<String , Object> map=new HashMap<String, Object>();
			map.put("type", handtype);
			Authentication.setAuthenticatedUserId(userid+"");
			taskService.addComment(task.get(0).getId(), processid+"", handtype+"");
			taskService.addComment(task.get(0).getId(), processid+"", handermemo);
			taskService.addComment(task.get(0).getId(), processid+"", format.format(nowdate)+"");
			taskService.setVariable(task.get(0).getId(),"unitid",unitid);
			taskService.complete(task.get(0).getId(), map);
			/**
			 * 修改apply表中申请的状态和hanglineid搭挂线路
			 */
			task=taskService.createTaskQuery().processInstanceId(processid+"").list();
			if(task.size()>0)
			{
				//System.out.println(task.get(0).getName());
				/**
				 * 下一个任务的名称
				 */
				List<dicitem> item=allDao.getdicitemMapperImpl().selectItemByName(task.get(0).getName());
				Apply apply=new Apply();
				apply.setApplyid(applyid);
				apply.setHanglineid(hanglineid);
				//System.out.println(item.get(0).getDicitemid()+"fffffff");
				apply.setStatus(item.get(0).getDicitemid());
				/**
				 * 根据applyid修改hanglineid和status
				 */
				/*if(item.get(0).getItem()=="申请受理")
				{
					apply.set
				}*/
				allDao.getApplyMapperImpl().ModifyProcessInstanceId(apply);
			}
			return JSONArray.fromObject("[{'msg':'处理成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'您没有权限处理此业务'}]");
		}
	}
	/**
	 * 查询某个申请的历史处理任务信息
	 * @param processid
	 * @return
	 */
	@Autowired
	private HistoryService historyService;
	public JSONArray SelectHistoryTaskInfo(int processid) {
		historyService=processEngine.getHistoryService();
		/**
		 * 审核任务和审核人
		 */
		List<HistoricTaskInstance> histask=historyService.createHistoricTaskInstanceQuery().processInstanceId(processid+"").list();
		JSONArray HanderInfo=new JSONArray();
		JSONObject OneHanderInfo=new JSONObject();	
		List<UserInfo> OneuserInfo=null;
		for(HistoricTaskInstance instance:histask)
		{
			System.out.println(instance.getName()+instance.getId());
			List<Comment> comment=taskService.getTaskComments(instance.getId());
			if(comment.size()>0)
			{
				//System.out.println(+"hj"+comment.get(0).getFullMessage());
				/**
				 * 根据userid查找审批人信息
				 */
				OneuserInfo= allDao.getuserMapperImpl().SelectUserByUserId(Integer.parseInt(comment.get(0).getUserId()));
				if(OneuserInfo.size()>0)
				{
					OneHanderInfo.put("handeruser",OneuserInfo.get(0).getName());
					//OneHanderInfo.put("handeruserPhone",OneuserInfo.get(0).getPhone());
					OneHanderInfo.put("handertask", instance.getName());
					OneHanderInfo.put("handertime", comment.get(0).getFullMessage());
					if(comment.get(2).getFullMessage().equals("1"))
					{
						OneHanderInfo.put("handerresult", "通过");
					}
					else{
						OneHanderInfo.put("handerresult", "驳回");
					}
					OneHanderInfo.put("handerDes",comment.get(1).getFullMessage());
					HanderInfo.add(OneHanderInfo);
				}
			}
		}
		return HanderInfo;
	}
	/**
	 * 根据applyid查找搭挂线路查勘信息
	 * @param applyid
	 * @return
	 */
	public JSONArray SelectCheckInfo(int applyid) {
		List<CheckDetail> ChkDtlList=allDao.getFaultMapperImpl().SelectCheckInfo(applyid);
		return JSONArray.fromObject(ChkDtlList);
	}
	/**
	 * 根据applyid查找申请文件信息
	 * @param applyid
	 * @return
	 */
	public JSONArray SelectApplyDoc(int applyid) {
		List<Doctype> doctypeLiat=allDao.getApplyDocMapperImpl().SelectApplyDocInfo(applyid);
		return JSONArray.fromObject(doctypeLiat);
	}
}
