package com.xk.Controller;


import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.UserInfo;
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
	public  @ResponseBody JSONArray page(HttpServletRequest req){
		/*
		 * 根据用户名
		 * 单位
		 * 类型搜索信息
		 */
		String username=req.getParameter("username");
		String type=req.getParameter("status");
		String unit=req.getParameter("unit");
		UserInfo info =new UserInfo();
		info.setName(username);
		info.setType(type);
		info.setUnitname(unit);
		System.out.println(username+type+"防守打法"+unit);
		JSONArray ja=allService.getuserMapperBLL().selectallUser(info);
		return ja;
	}
	@RequestMapping(value="/unit",method=RequestMethod.POST)
	public  @ResponseBody JSONArray InitUnit(){
		JSONArray unitlist=allService.getuniBll().selectAllUnitName();
		return unitlist;
	}
}
