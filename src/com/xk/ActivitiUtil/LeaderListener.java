package com.xk.ActivitiUtil;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import com.xk.DaoImpl.AllDao;
import com.xk.Util.SpringContextUtil;
import com.xk.orm.Role;
import com.xk.orm.UserRole;

/**
 * @author: xk
 * @date:2017年11月16日 下午7:50:07
 * @version :
 * 领导任务监听
 */
public class LeaderListener implements TaskListener{
	@Override
	public void notify(DelegateTask task) {
		// TODO Auto-generated method stub
		/**
		 * 设置所有领导人的用户
		 */
		AllDao alldao=(AllDao)SpringContextUtil.getApplicationContext().getBean("allDao");
		List<Role> repairUser=alldao.getRoleMapperImpl().selectAllRole();
		int RepairId=0;
		for(Role role:repairUser)
		{
			if(role.getName().equals(EnumData.LeaderUsers))
			{
				RepairId=role.getRoleid();
			}
		}
		List<UserRole> userinfo=alldao.getuserRoleMapperLmpl().SelectRepairUsers(RepairId);
		for(UserRole userid:userinfo)
		{
			String Assignee=userid.getUserid()+"";
			task.addCandidateUser(Assignee);
		}
	}
}
