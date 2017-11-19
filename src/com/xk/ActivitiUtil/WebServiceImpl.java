package com.xk.ActivitiUtil;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
//@WebService(endpointInterface="com.xk.ActivitiUtil.WebServiceimp")
public class WebServiceImpl implements WebServiceimp{
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private FormService formService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ManagementService managementService;
	@WebMethod
	@Override
	public List<Object> ProcessEngine() {
		
		//部署流程定义
		repositoryService=processEngine.getRepositoryService();
		Deployment de=repositoryService.createDeployment().addClasspathResource("./Activiti/MyProcess.bpmn").deploy();
		
		// * 流程定义类
		 
		List<ProcessDefinition> processDefinition=repositoryService.createProcessDefinitionQuery().list();
		
		 //* 流程执行实例
		 
		//ProcessInstance processInstance=processEngine.getRuntimeService().startProcessInstanceByKey("")
		runtimeService=processEngine.getRuntimeService();
		//默认最新的key启动流程实例
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("myProcess");
		taskService=processEngine.getTaskService();
		List<Task> task=taskService.createTaskQuery().list();
		for(Task t:task)
		{
			System.out.println("任务id"+t.getId()+"名称"+t.getName());
			//processEngine.getTaskService().complete(t.getId());
		}
		List<Object> list=null;
		return list;
	}
	@Override
	public List<Object> Playruntime() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object> TaskListen() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void RepositoryStart() {
		repositoryService=processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("./Activiti/ApplyProcess.bpmn");
	}
}
