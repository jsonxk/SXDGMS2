package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
