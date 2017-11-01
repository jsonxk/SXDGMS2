package com.xk.Controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.xk.DaoImpl.AllDao;
import com.xk.orm.Unit;
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
	//查找单位信息
	@RequestMapping(value="/selectAllUnit",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllUnit(@RequestParam(value="unitname",required=false) String unitname,@RequestParam("unitstatus") String unitstatus,@RequestParam(value="pageSize") String pageSize,@RequestParam(value="offset") String offset){
		return allService.getuniBll().selectUnitByname(unitname,unitstatus,Integer.parseInt(pageSize),Integer.parseInt(offset));
	}
	//添加单位信息
	@RequestMapping(value="/InsertUnit",method=RequestMethod.POST)
	public @ResponseBody boolean InsertUnit(@RequestBody List<Unit> list){
		//return allService.getuniBll().selectUnitByname(unitname,Integer.parseInt(pageSize),Integer.parseInt(offset));
		return allService.getuniBll().InsertUnit(list);
	}
	/*
	 * 查找单位类别
	 */
	@RequestMapping(value="/SelectUnitType",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectUnitType(@RequestParam("unittype")String unittype){
		return JSONArray.fromObject(allService.getuniBll().SelectUnitType(unittype));
	}
	/*
	 * 删除单位
	 * 并不是真正的删除只是修改状态
	 */
	@RequestMapping(value="/DelUnit",method=RequestMethod.POST)
	public @ResponseBody boolean DelUnit(@RequestParam("unitid")String unitid){
		return allService.getuniBll().DelUnit(Integer.parseInt(unitid));
	}
	/*
	 * 修改单位信息
	 */
	@RequestMapping(value="/ModifyUnit",method=RequestMethod.POST)
	public @ResponseBody boolean ModifyUnit(@RequestBody List<Unit> unitlist){
		return allService.getuniBll().unittypeModify(unitlist);
	}
}
