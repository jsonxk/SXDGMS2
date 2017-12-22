package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.LineDetail;
import com.xk.orm.Pole;
import com.xk.orm.PowerLine;
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
	/**
	 * 添加线路信息 同时添加首杆尾杆信息
	 * @param lineid
	 * @return{boolean}
	 */
	@RequestMapping(value="/insertLineInfo",method=RequestMethod.POST)
	public @ResponseBody boolean InsertLineInfo(@RequestBody PowerLine powerLine){
		return allservice.getLinePoleBLL().InsertLineInfo(powerLine);
	}
	/**
	 * 添加线杆信息
	 * @param Pole
	 * @return poleid
	 */
	@RequestMapping(value="/insertPoleInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray InsertPoleInfo(@RequestBody Pole pole){
		return allservice.getLinePoleBLL().InsertPoleInfo(pole);
	}
	/**
	 * 加载所有的线杆信息
	 * @return
	 */
	@RequestMapping(value="/selectAllPole",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllPole(){
		return allservice.getLinePoleBLL().selectAllPole();
	}
	/**
	 * 加载所有线路信息
	 * @return {name+lineid}
	 */
	@RequestMapping(value="/selectAllLineName",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllLineName(){
		return allservice.getLinePoleBLL().selectAllLineName();
	}
	/**
	 * 添加线路明细
	 * @return
	 */
	@RequestMapping(value="/insertPoleLineDetail",method=RequestMethod.POST)
	public @ResponseBody boolean insertPoleLineDetail(@RequestBody LineDetail lineDetail){
		return allservice.getLinePoleBLL().insertPoleLineDetail(lineDetail);
	}
	/**
	 * 修改线杆的经纬度
	 * @param pole
	 * @return
	 */
	@RequestMapping(value="/modifyPolePosition",method=RequestMethod.POST)
	public @ResponseBody boolean ModifyPolePosition(@RequestBody Pole pole){
		//System.out.println(pole.getLatitude()+"四渡赤水的");
		return allservice.getLinePoleBLL().ModifyPolePosition(pole);
		//System.out.println(pole.getPoleid()+"从四渡赤水的");
		//return true;
	}
	/**
	 * 根据poleid查找所属电力线路信息
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/selectAllLineByPoleid",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllLineByPoleid(@RequestParam("poleid")int poleid){
		System.out.println(allservice.getLinePoleBLL().SelectAllLineByPoleid(poleid));
		return allservice.getLinePoleBLL().SelectAllLineByPoleid(poleid);
	}
	/**
	 * 根据poleid查找线杆信息
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/selectPoleInfoByPoleid",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectPoleInfoByPoleid(@RequestParam("poleid")int poleid){
		//System.out.println(allservice.getLinePoleBLL().SelectAllLineByPoleid(poleid));
		return allservice.getLinePoleBLL().SelectPoleInfoByPoleid(poleid);
	}
	/**
	 * 搜索电力线路，搭挂线路，线杆
	 * @param name 名称
	 * @return
	 */
	@RequestMapping(value="/selectAllInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllInfo(@RequestParam("name")String name){
		return allservice.getLinePoleBLL().SelectAllInfo(name);
	}
	/**
	 * 查找电力线路信息
	 * @param lineid
	 * @return
	 */
	@RequestMapping(value="/selectLineInfoByLineId",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectLineInfoByLineId(@RequestParam("lineid")int lineid){
		return allservice.getLinePoleBLL().SelectLineInfoByLineId(lineid);
	}
	/**
	 * 根据名称模糊查找搭挂线杆信息
	 * @param polename
	 * @return
	 */
	@RequestMapping(value="/selectHangPoleByName",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangPoleByName(@RequestParam("polename") String polename){
		return allservice.getLinePoleBLL().SelectHangPoleByName(polename);
	}
	/**
	 * 根据名称精确查找搭挂线杆信息
	 * @param polename
	 * @return
	 */
	@RequestMapping(value="/selectHangPoleByAllName",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHangPoleByAllName(@RequestParam("polename") String polename){
		return allservice.getLinePoleBLL().SelectHangPoleByAllName(polename);
	}
	/**
	 * 删除线杆并删除相关的搭挂详情和线路详情
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/delPoleByPoleId",method=RequestMethod.POST)
	public @ResponseBody JSONArray DelPoleByPoleId(@RequestParam("poleid") int poleid){
		return allservice.getLinePoleBLL().DelPoleByPoleId(poleid);
	}
	/**
	 * 地图上添加电力电路信息，pole，linedetail
	 * @param pLine
	 * @return
	 */
	@RequestMapping(value="/insertNewLineAndDetail",method=RequestMethod.POST)
	public @ResponseBody JSONArray InsertNewLineAndDetail(@RequestBody PowerLine pLine){
		return allservice.getLinePoleBLL().InsertNewLineAndDetail(pLine);
	}
	/**
	 * 修改线路信息{name,status,type,unitid}
	 * @param pLine
	 * @return
	 */
	@RequestMapping(value="/modifyLineInfo",method=RequestMethod.POST)
	public  @ResponseBody boolean ModifyLineInfo(@RequestBody PowerLine pLine){
		return allservice.getLinePoleBLL().ModifyLineInfo(pLine);
	}
	/**
	 * 删除电力线路信息
	 * @param lineid
	 * @return
	 */
	@RequestMapping(value="/delLineInfo",method=RequestMethod.POST)
	public @ResponseBody boolean DelLineInfo(@RequestParam("lineid") int lineid){
		return allservice.getLinePoleBLL().DelLineInfo(lineid);
	}
	/**
	 * 根据poleid查找相关图片信息
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/selectPolePhoto",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectPolePhoto(@RequestParam("poleid") int poleid){
		return allservice.getLinePoleBLL().SelectPolePhoto(poleid);
	}
}
