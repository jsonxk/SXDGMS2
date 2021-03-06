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
import com.xk.orm.ApplyMore;
import com.xk.orm.HangLine;
import com.xk.orm.PublicEntity;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月8日 下午11:05:30
 * @version :
 * 申请信息管理
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
	public @ResponseBody JSONArray InsertApplyInfo(@RequestBody ApplyMore applyinfo)
	{
		
		JSONArray msg=new JSONArray();
		int i=allService.getApplyMapperBLL().InsertApplyInfo(applyinfo);
		if(i>0)
		{
			msg=JSONArray.fromObject("[{'Insert':"+i+"}]");
		}
		else 
			msg=JSONArray.fromObject("[{'Insert':"+0+"}]");
		return msg;
	}
	/**
	 * 修改申请信息
	 * @param applyinfo
	 * @return
	 */
	@RequestMapping(value="/ModifyApplyInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray ModifyApplyInfo(@RequestBody ApplyMore applyinfo)
	{
		
		JSONArray msg=new JSONArray();
		if(allService.getApplyMapperBLL().ModifyApplyInfo(applyinfo))
		{
			msg=JSONArray.fromObject("[{'Modify':'success'}]");
		}
		else 
			msg=JSONArray.fromObject("[{'Modify':'error'}]");
		return msg;
	}
	/**
	 * 查找搭挂申请所需要的文件信息
	 * @param Applytype申请状态
	 * @return
	 */
	@RequestMapping(value="/SelectDoctype",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectDoctype(@RequestParam("Applytype") String Applytype){
		return allService.getApplyMapperBLL().SelectDoctype(Applytype);
	}
	/**
	 * 获取所有申请信息(包括查找信息)
	 * @param publicentity{时间,类型}
	 * @return
	 */
	@RequestMapping(value="/SelectApplyInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectApplyInfo(@RequestBody PublicEntity publicentity ){
		return allService.getApplyMapperBLL().SelectApplyInfo(publicentity);
	}
	/**
	 * 用户提交申请接受信息后用于开启流程
	 * @param publicentity
	 * @return
	 */
	@RequestMapping(value="/SubmitApply",method=RequestMethod.POST)
	public @ResponseBody JSONArray SubmitApply(@RequestBody Apply publicentity ){
		return allService.getApplyMapperBLL().SubmitApply(publicentity);
	}
	/**
	 * 根据poleid查找搭挂线路信息
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/selectHangLineByPoleid",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangLineByPoleid(@RequestParam("poleid") int poleid){
		return allService.gethangLineBLL().SelectHangLineByPoleid(poleid);
	}
	/**
	 * 根据hanglineid查找搭挂线路信息
	 * @param hanglineid
	 * @return
	 */
	@RequestMapping(value="/selectHangLineByHangLineid",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangLineByHangLineId(@RequestParam("hanglineid") int hanglineid){
		return allService.gethangLineBLL().SelectHangLineByHangLineId(hanglineid);
	}
	/**
	 * 根据名称查找搭挂线路
	 * @param hangname
	 * @return
	 */
	@RequestMapping(value="/selectHangLineByName",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangLineByName(@RequestParam("hangname") String hangname){
		return allService.gethangLineBLL().SelectHangLineByName(hangname);
	}
	/**
	 * 根据名称查找搭挂线路精确查找
	 * @param hangname
	 * @return
	 */
	@RequestMapping(value="/selectHangLineByAllName",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangLineByALLName(@RequestParam("hangname") String hangname){
		return allService.gethangLineBLL().SelectHangLineByAllName(hangname);
	}
	/**
	 * 根据hanglineid查找搭挂线杆信息
	 * @param hanglineid
	 * @return
	 */
	@RequestMapping(value="/selectHangPoleByHangLineid",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangPoleByHangLineid(@RequestParam("hanglineid") int hanglineid){
		return allService.gethangLineBLL().SelectHangPoleByHangLineid(hanglineid);
	}
	/**
	 * 查找所有的搭挂线路信息以及上一杆
	 * @return{hangdetail}
	 */
	@RequestMapping(value="/selectAllHangAndPole",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllHangAndPole(){
		return allService.gethangLineBLL().selectAllHangAndPole();
	}
	/**
	 * 添加搭挂线路信息及搭挂细节
	 * @param hangline
	 * @return
	 */
	@RequestMapping(value="/insertHangLineAndDetail",method=RequestMethod.POST)
	public @ResponseBody JSONArray InsertHangLineAndDetail(@RequestBody HangLine hangline){
		return allService.gethangLineBLL().InsertHangLineAndDetail(hangline);
	}
	/**
	 * 根据applyid删除搭挂线路及相关申请信息
	 * @param applyid
	 * @return
	 */
	@RequestMapping(value="/delHangLineApply",method=RequestMethod.POST)
	public @ResponseBody JSONArray DelHangLineApply(@RequestParam("applyid") int applyid){
		return allService.getApplyMapperBLL().DelHangLineApply(applyid);
	}
}
