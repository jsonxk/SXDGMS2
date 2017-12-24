package com.xk.Controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.Role;
import com.xk.orm.UserRole;
import com.xk.service.AllService;

@Controller
@RequestMapping("/role")
public class RoleController {
@Autowired
private AllService allService;
private UserRole userrole;
@RequestMapping(value="/selectrole",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectRole(@RequestParam("userid") String userid){
		int uid=Integer.parseInt(userid);
		return allService.getroleMapperBLL().selectByUserid(uid);
	}
/*
 * 修改某个用户的角色
 */
@RequestMapping(value="/modifyrole",method=RequestMethod.POST)
public @ResponseBody boolean modifyRole(@RequestParam("roleid") String roleid,@RequestParam("flag") String flag,@RequestParam("userid") String userid){
	int rid=Integer.parseInt(roleid);
	int Uid=Integer.parseInt(userid);
	int rFlag=Integer.parseInt(flag);
	userrole=new UserRole();
	userrole.setRoleid(rid);
	userrole.setUserid(Uid);
	boolean ret=allService.getuserRoleFunctionBLL().modifyrole(userrole, rFlag);
	return ret;
}
/*
 * 获取所有角色信息
 * 包括角色搜索
 */
@RequestMapping(value="/selectAllrole",method=RequestMethod.POST)
public @ResponseBody JSONArray SelectAllRole(@RequestParam(value="rolename",required=false) String rolename){
	List<Role> list=allService.getroleMapperBLL().SelectAllRole(rolename);
	return JSONArray.fromObject(list);
}
/**
 * 修改角色信息
 * @param roleid
 * @param name
 * @param memo
 * @return
 */
/*@RequestMapping(value="/modifyRoleInfo",method=RequestMethod.POST)
public @ResponseBody boolean ModifyRoleInfo(@RequestParam("roleid") int roleid,@RequestParam("name") String name,@RequestParam("memo") String memo){
	return allService.getroleMapperBLL().ModifyRoleInfo(roleid,name,memo);
}*/
}
