package com.xk.Controller;


import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.User;
import com.xk.service.AllService;

@Controller
@RequestMapping("/user")
public class UserDelController {
	@Autowired 
	private AllService allService;
	@RequestMapping(value="/deluser",method=RequestMethod.POST)
	public @ResponseBody boolean DelUser(@RequestParam("userid") String userid)
	{
		int uid=Integer.parseInt(userid);
		return allService.getuserMapperBLL().deleteByUserid(uid);
	}
	/**
	 * 查找用户信息
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/selectUserInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectUserInfo(@RequestParam("userid") String userid)
	{
		int uid=Integer.parseInt(userid);
		return allService.getuserMapperBLL().SelectUserInfo(uid);
	}
	/**
	 * 修改个人用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/modifyUserInfo",method=RequestMethod.POST)
	public @ResponseBody boolean ModifyUserInfo(@RequestBody User user)
	{
		return allService.getuserMapperBLL().ModifyUserInfo(user);
	}
	/**
	 * 添加个人用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/addUserInfo",method=RequestMethod.POST)
	public @ResponseBody boolean AddUserInfo(@RequestBody User user)
	{
		return allService.getuserMapperBLL().AddUserInfo(user);
	}
}
