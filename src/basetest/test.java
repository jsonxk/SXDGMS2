package basetest;

import java.util.List;

import net.sf.json.JSONArray;

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
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.UserInfo;
import com.xk.orm.UserRole;
import com.xk.service.AllService;

public class test extends SpringCaseTest{
	@Autowired
	private AllService allService;
	@Autowired
	private AllDao alldao;
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
	Logger logger=Logger.getLogger(test.class);
	@Test
	public void test(){
		//JSONArray fun=allService.getuserRoleFunctionBLL().SelectFunByUserid(1);
		//User fun=allService.getuserMapperBLL().LoginJudgy("xk", "123");
		//UserRole info=new UserRole();
		//info.setUserid(1);
		//info.setRoleid(3);
		//JSONArray funlist=allService.getuserMapperBLL().selectallUser(info);
		//JSONArray funlist=allService.getuniBll().selectAllUnitName();
		//System.out.println(JSONArray.fromObject(allService.getroleMapperBLL().SelectAllRole("")));
		//System.out.println(allService.getsysparambll().SearchSysParam("数据库"));

		//部署流程定义
		repositoryService=processEngine.getRepositoryService();
		Deployment de=repositoryService.createDeployment().addClasspathResource("./Activiti/MyProcess.bpmn").deploy();
		/*
		 * 流程定义类
		 */
		List<ProcessDefinition> processDefinition=repositoryService.createProcessDefinitionQuery().list();
		System.out.println(processDefinition.size()+"发的搭挂");
		/*
		 * 流程执行实例
		 */
		//ProcessInstance processInstance=processEngine.getRuntimeService().startProcessInstanceByKey("")
		runtimeService=processEngine.getRuntimeService();
		//默认最新的key启动流程实例
		//ProcessInstance processInstance=runtimeService.startProcessInstanceById(processDefinitionId)
		runtimeService.startProcessInstanceByKey("myProcess");
		taskService=processEngine.getTaskService();
		List<Task> task=taskService.createTaskQuery().list();
		/*for(Task t:task)
		{
			System.out.println("任务id"+t.getId()+"名称"+t.getName());
			//processEngine.getTaskService().complete(t.getId());
		}*/
	}
}
