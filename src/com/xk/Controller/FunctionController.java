package com.xk.Controller;

import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.service.AllService;

@Controller
@RequestMapping("/func")
public class FunctionController {
	@Autowired
	private AllService allService;
	//所有功能
	@RequestMapping(value = "/AllFunc", method = RequestMethod.POST)
	public @ResponseBody JSONArray getFunction(
			@RequestParam(value = "roleid") String roleid) {
		return allService.getfunctionBLL().selectFuncByRoleid(
				Integer.parseInt(roleid));
	}
	//修改或者删除某角色功能信息
	@RequestMapping(value="/modifyFunc",method=RequestMethod.POST)
	public @ResponseBody boolean modifyFunc(@RequestBody List<Object> list){
		System.out.println("修改功能");
		return allService.getfunctionBLL().modifyFunc(list);
	}
	
}
