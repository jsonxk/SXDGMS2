package com.xk.Controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.SysParam;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月2日 下午5:35:31
 * @version :
 * 系统参数Controller
 */
@Controller
@RequestMapping("/CSGL")
public class CSGLController {
	@Autowired
	private AllService allservice;
	/*
	 * 获取系统参数
	 */
	@RequestMapping("/selectAllParam")
	public @ResponseBody JSONArray selectAllParam(@RequestParam("paramname") String paramname,@RequestParam("paramtype") String paramtype){
		return allservice.getsysparambll().SearchSysParam(paramname,paramtype);
	}
	//添加参数
	@RequestMapping(value="/InsertParam",method=RequestMethod.POST)
	public @ResponseBody boolean InsertParam(@RequestBody SysParam param){
		return allservice.getsysparambll().InsertParam(param);
	}
	//修改参数
	@RequestMapping(value="/ModifyParam",method=RequestMethod.POST)
	public @ResponseBody boolean ModifyParam(@RequestBody SysParam param){
		return allservice.getsysparambll().ModifyParam(param);
	}
	//删除参数
	@RequestMapping(value="/DelParam",method=RequestMethod.POST)
	public @ResponseBody boolean DelParam(@RequestParam("sysparamid") int sysparamid){
		return allservice.getsysparambll().DelParam(sysparamid);
	}
}
