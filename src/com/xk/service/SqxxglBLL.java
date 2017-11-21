package com.xk.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.ApplyMore;
import com.xk.orm.PublicEntity;
import com.xk.orm.Unit;
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
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private TaskService taskService;
	public JSONArray SelectApplyAndTask(PublicEntity publicEntity){
		JSONArray jadata=new JSONArray();
		JSONObject jodata=new JSONObject();
		SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
		List<ApplyMore> applyinfo=allDao.getApplyMapperImpl().SelectApplyAndTask(publicEntity);
		taskService=processEngine.getTaskService();
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
}
