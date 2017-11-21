package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.PublicEntity;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月19日 下午9:47:22
 * @version :
 * 
 */
@Controller
@RequestMapping("/SQXXGL")
public class SQXXGLController {
	@Autowired
	private AllService allservice;
	/**
	 * 查找所有单位
	 * @return
	 */
	@RequestMapping(value="/selectallunit",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllUnit(@RequestParam("status") String status){
		System.out.println(status);
		return allservice.getSqxxglBll().selectAllnormalUnit(status);
	}
	/**
	 * 查找所有可处理申请信息
	 * @param publicEntity
	 * @return
	 * taskid，processid，基本信息
	 */
	@RequestMapping(value="/selectApplyAndTask",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectApplyAndTask(@RequestBody PublicEntity publicEntity){
		return allservice.getSqxxglBll().SelectApplyAndTask(publicEntity);
	}
}
