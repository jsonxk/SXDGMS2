package com.xk.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
