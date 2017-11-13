package com.xk.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.Apply;
import com.xk.orm.ApplyStringTime;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月8日 下午11:05:30
 * @version :
 * 
 */
@Controller
@RequestMapping("/HangLine")
public class HangLineController {
	@Autowired
	private AllService allService;
	/**
	 * 获取相关状态
	 * @param typename
	 * @return jsonarray
	 */
	@RequestMapping(value="/selectHangStatus",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangLineStatus(@RequestParam("typename") String typename){
		return allService.gethangLineBLL().SelectHangLineStatus(typename);
	}
	/**
	 * 添加申请信息
	 * @param applyinfo
	 * @return
	 */
	@RequestMapping(value="/InsertApplyInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray InsertApplyInfo(@RequestBody ApplyStringTime applyinfo)
	{
		
		JSONArray msg=new JSONArray();
		if(allService.getApplyMapperBLL().InsertApplyInfo(applyinfo))
		{
			msg=JSONArray.fromObject("[{'msg':'success'}]");
		}
		else 
			msg=JSONArray.fromObject("[{'msg':'error'}]");
		return msg;
	}
}
