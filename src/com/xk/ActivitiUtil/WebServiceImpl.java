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
import org.springframework.beans.factory.annotation.Autowired;
@WebService(endpointInterface="com.xk.ActivitiUtil.WebServiceimp")
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
	public List<Object> getlist() {
		// TODO Auto-generated method stub
		List<Object> list=new ArrayList<Object>();
		list.add("ss");
		list.add("bb");
		return list;
	}
	@WebMethod
	@Override
	public String Say(String id) {
		// TODO Auto-generated method stub
		System.out.println(id+"水电费胜多负少的");
		return id;
	}
	@WebMethod
	@Override
	public List<Object> ProcessEngine() {
		Deployment de=processEngine.getRepositoryService().createDeployment().addClasspathResource("./Activiti/HangLineApply.bpmn").deploy();
		return null;
	}
	
}
