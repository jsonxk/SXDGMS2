package com.xk.ActivitiUtil;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.DaoImpl.AllDao;
import com.xk.Util.SpringContextUtil;
import com.xk.orm.Role;
import com.xk.orm.User;
import com.xk.orm.UserRole;

/**
 * @author: xk
 * @date:2017年11月16日 下午7:49:02
 * @version :
 * 运维检修部监听
 */
public class RepairUnitListener implements TaskListener{
	@Override
	public void notify(DelegateTask task) {
		//System.out.println(task.getId()+task.getName()+"撒大大是");
		//task.setAssignee("萨达");
		AllDao alldao=(AllDao)SpringContextUtil.getApplicationContext().getBean("allDao");
		List<Role> repairUser=alldao.getRoleMapperImpl().selectAllRole();
		int RepairId=0;
		for(Role role:repairUser)
		{
			if(role.getName().equals(EnumData.RepairUsers))
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
