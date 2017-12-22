package com.xk.ActivitiUtil;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.DaoImpl.AllDao;
import com.xk.Util.SpringContextUtil;
import com.xk.orm.User;
import com.xk.orm.UserInfo;

/**
 * @author: xk
 * @date:2017年11月16日 下午7:57:53
 * @version :
 * 租用单位监听
 */
public class RentUnitListener implements TaskListener{
	@Autowired
	private TaskService taskservice;
	private Expression unitid;  
	  
    public Expression getUnitid() {  
        return unitid;  
    }  
  
    public void setUnitid(Expression unitid) {  
        this.unitid = unitid;  
    } 
	@Override
	public void notify(DelegateTask task) {
		System.out.println(task.getId()+"dddd");
		//Integer unitid=(Integer) taskservice.getVariable(task.getId(), "unitid");
		System.out.println(unitid.getValue(task)+"我是unitid");
		AllDao alldao=(AllDao)SpringContextUtil.getApplicationContext().getBean("allDao");
		List<UserInfo> userlist=alldao.getuserMapperImpl().selectallUser();
		/**
		 * 线路所属单位的unitid
		 */
		if(userlist.size()>0)
		{
			for(UserInfo ui:userlist)
			{
				if(unitid.getValue(task).equals(ui.getUnitid()))
				{
					//System.out.println(ui.getUserid()+"Regee而发给你看见男人看见你看妇女节g");
					task.addCandidateUser(ui.getUserid()+"");
				}
			}
		}
	}
}
