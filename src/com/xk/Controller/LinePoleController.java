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
 * @date:2017年11月21日 上午11:16:05
 * @version :
 * 线路线杆管理
 */
@Controller
@RequestMapping("/LinePole")
public class LinePoleController {
	@Autowired
	private AllService allservice;    
	/**
	 * 查找所有电力线路信息
	 * @param searchinfo{pagesize,offset,name,userid,unitid}
	 * @return
	 */
	@RequestMapping(value="/selectAllLine",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllLine(@RequestBody PublicEntity searchinfo){
		return allservice.getLinePoleBLL().SelectAllLine(searchinfo);
	}
	/**
	 * 根据lineid查找pole信息
	 * @param lineid
	 * @return{pole}
	 */
	@RequestMapping(value="/selectpoleinfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectPoleInfo(@RequestParam("lineid") int lineid){
		return allservice.getLinePoleBLL().SelectPoleInfo(lineid);
	}
}
