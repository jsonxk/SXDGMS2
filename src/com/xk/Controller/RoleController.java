package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.service.AllService;

@Controller
@RequestMapping("/role")
public class RoleController {
@Autowired
private AllService allService;
@RequestMapping(value="/selectrole",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectRole(@RequestParam("userid") String userid){
		int uid=Integer.parseInt(userid);
		return allService.getroleMapperBLL().selectByUserid(uid);
	}
}
