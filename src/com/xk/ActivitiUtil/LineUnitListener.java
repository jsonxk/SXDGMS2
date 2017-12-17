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
 * @date:2017年11月16日 下午7:46:42
 * @version :
 * 线路运行单位监听
 */
public class LineUnitListener implements TaskListener{
	@Override
	public void notify(DelegateTask task) {
		/**
		 * 设置所有线路运行单位用户
		 */
		AllDao alldao=(AllDao)SpringContextUtil.getApplicationContext().getBean("allDao");
		List<Role> repairUser=alldao.getRoleMapperImpl().selectAllRole();
		int RepairId=0;
		for(Role role:repairUser)
		{
			if(role.getName().equals(EnumData.RunUsers))
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
