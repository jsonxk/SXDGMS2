package com.xk.ActivitiUtil;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import basetest.SpringCaseTest;

/**
 * @author: xk
 * @date:2017年11月16日 下午4:38:32
 * @version :
 * 部署启动一个流程
 */
public class ActivitiMain extends SpringCaseTest{
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	Logger log=Logger.getLogger(ActivitiMain.class);
	@Test
	public void startRepositoryProcess(){
		repositoryService=processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("./Activiti/ApplyProcess.bpmn").deploy();
		processEngine.getRuntimeService().startProcessInstanceByKey("sxdgsplc");
	}
}
