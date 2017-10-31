package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.xk.DaoImpl.AllDao;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年10月31日 下午5:00:48
 * @version :
 * 单位管理
 */
@Controller
@RequestMapping("Unit")
public class UnitController {
	@Autowired
	private AllService allService;
	@RequestMapping(value="/selectAllUnit",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllUnit(@RequestParam(value="unitname",required=false) String unitname,@RequestParam(value="pageSize") String pageSize,@RequestParam(value="offset") String offset){
		return allService.getuniBll().selectUnitByname(unitname,Integer.parseInt(pageSize),Integer.parseInt(offset));
	}
}
