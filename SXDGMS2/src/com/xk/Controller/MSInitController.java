package com.xk.Controller;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.service.AllService;

@Controller
@RequestMapping("/SXDG")
public class MSInitController {
	@Autowired
	private AllService allService;
	@RequestMapping(value="/init",method=RequestMethod.POST)
	public  @ResponseBody JSONArray MSInit(@RequestParam(value="userid",required=true) String userid){
		Integer parentid=0;
		JSONArray funlist=allService.getfunctionBLL().selectOnUserid(Integer.parseInt(userid), 0);
		return funlist;
	}
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public  @ResponseBody JSONArray page(){
		Integer parentid=0;
		JSONArray ja=new JSONArray();
		JSONObject jo=new JSONObject();
		for(int i=0;i<55;i++)
		{
			jo.put("useremail",i);
			jo.put("usercompany", i);
			jo.put("userdates", i);
			jo.put("userlastlogintime", 1);
			jo.put("userversion", 1);
			ja.add(jo);
		}
		return ja;
	}
}
