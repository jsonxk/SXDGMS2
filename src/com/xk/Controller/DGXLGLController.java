package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.HangDetail;
import com.xk.orm.HangLine;
import com.xk.orm.PublicEntity;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月23日 下午7:06:10
 * @version :
 * 搭挂线路管理Controller
 */
@Controller
@RequestMapping("/DGXLGL")
public class DGXLGLController {
	@Autowired
	private AllService allservice;    
	/**
	 * 查找所有搭挂线路信息
	 * @param searchinfo{pagesize,offset,hangname,unitid}
	 * @return
	 */
	@RequestMapping(value="/selectAllHangLine",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllHangLine(@RequestBody PublicEntity publicEntity){
		return allservice.getDgxlglBLL().SelectAllHangLine(publicEntity);
	}
	/**
	 * 查找所有搭挂线路信息
	 * @return
	 */
	@RequestMapping(value="/selectAllHangLineName",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllHangLineName(){
		return allservice.getDgxlglBLL().SelectAllHangLineName();
	}
	/**
	 * 查找所有搭挂线杆信息
	 * @return
	 */
	@RequestMapping(value="/selectAllHangPoleName",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllHangPoleName(){
		return allservice.getDgxlglBLL().selectAllHangPoleName();
	}
	/**
	 * 查找搭挂线杆信息
	 * @param hanglineid
	 * @return
	 */
	@RequestMapping(value="/selectHangPole",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectHangPole(@RequestParam("hanglineid") int hanglineid){
		return allservice.getDgxlglBLL().selectHangPole(hanglineid);
	}
	/**
	 * 添加搭挂线路信息
	 * @param hangline
	 * @return
	 */
	@RequestMapping(value="/insertHangLine",method=RequestMethod.POST)
	public @ResponseBody boolean InsertHangLine(@RequestBody HangLine hangline){
		return allservice.getDgxlglBLL().insertHangLine(hangline);
	}
	/**
	 * 添加搭挂线杆信息
	 * @param hangline
	 * @return
	 */
	@RequestMapping(value="/InsertHangPoleDetail",method=RequestMethod.POST)
	public @ResponseBody boolean InsertHangPoleDetail(@RequestBody HangDetail hangDetail){
		return allservice.getDgxlglBLL().InsertHangPoleDetail(hangDetail);
	}
}
