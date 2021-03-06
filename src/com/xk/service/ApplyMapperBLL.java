package com.xk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.ActivitiUtil.EnumData;
import com.xk.DaoImpl.AllDao;
import com.xk.orm.Apply;
import com.xk.orm.ApplyDoc;
import com.xk.orm.ApplyDocTime;
import com.xk.orm.ApplyMore;
import com.xk.orm.Doctype;
import com.xk.orm.HangDetail;
import com.xk.orm.HangDetailList;
import com.xk.orm.PublicEntity;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

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
	 * 
	 * @param applyStringTime
	 * @return
	 */
	public int InsertApplyInfo(ApplyMore applyStringTime) {

		return alldao.getApplyMapperImpl().insertApplyInfo(applyStringTime);
	}

	/**
	 * 修改申请信息
	 * 
	 * @param applyStringTime
	 * @return
	 */
	public boolean ModifyApplyInfo(ApplyMore applyStringTime) {
		int i = alldao.getApplyMapperImpl().ModifyApplyInfo(applyStringTime);
		if (i > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * 查找申请所需文件
	 * 
	 * @param Applytype
	 *            ("申请状态")
	 * @return{doctypeid,docname,must,status},{申请文件id，申请文件名字，是否必须，状态文件}
	 */
	public JSONArray SelectDoctype(String Applytype) {
		List<dictype> typedata = alldao.getdictypeMapperImpl()
				.selectTypeByInfo(Applytype);
		int dictypestatus = typedata.get(0).getDictypeid();
		List<Doctype> DocData = alldao.getdocTypeMapperImpl()
				.SelectDoctypeByStatus(dictypestatus);
		JSONArray jadata = new JSONArray();
		JSONObject jodata = new JSONObject();
		for (Doctype type : DocData) {
			jodata.put("doctypeid", type.getDoctypeid());
			jodata.put("docname", type.getDocname());
			if (type.getMust() == 1) {
				jodata.put("must", "必须");
			} else
				jodata.put("must", "可选");
			jodata.put("status", Applytype);
			jadata.add(jodata);
		}
		return jadata;
	}

	/**
	 * 文件上传相关信息存入ApplyDoc
	 * 
	 * @param appDocTime
	 * @return
	 */
	public boolean InsertApplydoc(ApplyDocTime appDocTime) {
		int i = 0;
		List<ApplyDoc> flag=alldao.getApplyDocMapperImpl().SelectApplyDoc(appDocTime);
		if(flag.size()>0)
		{
			/*
			 * 表中有信息修改信息
			 */
			appDocTime.setApplydocid(flag.get(0).getApplydocid());
			i=alldao.getApplyDocMapperImpl().ModifyApplyDoc(appDocTime);
		}
		else{
			/**
			 * 没有系信息添加  
			 */
			i=alldao.getApplyDocMapperImpl().InsertApplydoc(appDocTime);
		}
		if (i > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * 根据上传信息查找申请信息
	 * 
	 * @param publicentity{pagesize,status,userid,unitid,offset}
	 * @return 
	 * 
	 */
	public JSONArray SelectApplyInfo(PublicEntity publicentity) {
		// System.out.println(publicentity.getTimestatus()+"dsa"+publicentity.getFinishtime()+"史蒂夫"+publicentity.getStatus());
		List<ApplyMore> applyinfo = null;
		List<ApplyDoc> applydoc=null;
		JSONArray jsondata = new JSONArray();
		JSONObject jodata = new JSONObject();
		/**
		 * 查找申请信息
		 * unitid，userid，status{申请类型}
		 */
		applyinfo = alldao.getApplyMapperImpl().SelectApplyInfoAll(publicentity);
		SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
		for (ApplyMore apply : applyinfo) {
			try {
				String str = apply.getPermitStringtime();
				if (str != null) {
					apply.setPermitStringtime(formart.format(formart.parse(str)));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			apply.setApplystringtime(formart.format(apply.getApplytime()));
			// apply.setPermitStringtime(formart.format(permitdate));
			/*
			 * 根据applyid查找文件信息 
			 */
			applydoc=alldao.getApplyDocMapperImpl().SelectDocByApplyId(apply.getApplyid());
			if(applydoc!=null)
			{
				apply.setListDoc(applydoc);
			}
		}
		jodata.put("rows", JSONArray.fromObject(applyinfo));
		jodata.put("total",
				alldao.getApplyMapperImpl().SelectApplyCount(publicentity));
		jsondata.add(jodata);
		return jsondata;
	}
	/**
	 * 提交后用于启动流程
	 * @param publicentity
	 * @return
	 */
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RuntimeService runtimeService; 
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;
	/**
	 * 开启审批流程
	 * @param apply
	 * @return
	 */
	public JSONArray SubmitApply(Apply apply) {
		runtimeService=processEngine.getRuntimeService();
		taskService=processEngine.getTaskService();
		/**
		 * 处理的userid
		 */
		String useridInfo=apply.getUserid()+"";
		Date nowdate=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Map<String, Object> map=new HashMap<String, Object>();
		/**
		 * 设置提交申请的用户
		 */
		map.put("applyuserid", useridInfo);
		identityService=processEngine.getIdentityService();
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(EnumData.ApplyprocessKey, map);
		/**
		 * 当前任务
		 */
		List<Task> task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
		/**
		 * 完成第一个提交申请的任务
		 */
		for(Task t:task){
			Authentication.setAuthenticatedUserId(useridInfo);
			/**
			 * 添加一个处理结果
			 */
			taskService.addComment(t.getId(),processInstance.getId(),"1");
			taskService.addComment(t.getId(),processInstance.getId(),apply.getMemo());
			taskService.addComment(t.getId(),processInstance.getId(), format.format(nowdate));
			taskService.complete(t.getId());
		};
		apply.setProcessid(processInstance.getId());
		/**
		 * 修改申请表中ProcessId和status状态
		 */
		task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
		List<dicitem> dicitem=alldao.getdicitemMapperImpl().selectItemByName(task.get(0).getName());
		apply.setStatus(dicitem.get(0).getDicitemid());
		int i=ModifyProcessInstanceId(apply);
		if(i>0)
		{
			return JSONArray.fromObject("[{'msg':'提交申请成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'提交申请失败'}]");
		}
	}
	/**
	 * xiugai Apply Table zhong processid 
	 * @param processinstanceid
	 * @return
	 */
	public int ModifyProcessInstanceId(Apply publicentity)
	{
		int i=alldao.getApplyMapperImpl().ModifyProcessInstanceId(publicentity);
		return i;
	}
	/**
	 * 删除搭挂申请以及相关申请信息{Apply，applydoc}
	 * @param applyid
	 * @return
	 */
	public JSONArray DelHangLineApply(int applyid) {
		int DelApplyAndApplyDoc=alldao.getApplyMapperImpl().DelApplyAndApplyDoc(applyid);
		if(DelApplyAndApplyDoc>0)
		{
			return JSONArray.fromObject("[{'msg':'删除信息成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'删除信息失败'}]");
		}
	}
}
