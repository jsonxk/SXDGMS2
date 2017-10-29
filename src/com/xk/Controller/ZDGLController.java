package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xk.orm.dictype;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年10月27日 下午9:29:31
 * @version :
 * 
 */
@Controller
@RequestMapping("/ZDGL")
public class ZDGLController {
	@Autowired
	private AllService allservice;
	//查找所有字典信息
	@RequestMapping(value="/selectAllType",method=RequestMethod.POST)
	public  @ResponseBody JSONArray selectAllType(@RequestParam("typename")String typename,@RequestParam("pageSize")String pageSize,@RequestParam("offset")String offset)
	{
		//return allservice.getdicTypeBLL().selectAlltype(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), typename);
		return allservice.getdicTypeBLL().selectAlltype(Integer.parseInt(offset),Integer.parseInt(pageSize), typename);
	}
	//查找字典详细信息
	@RequestMapping(value="/SelectItemByTypeId",method=RequestMethod.POST)
	public @ResponseBody  JSONArray SelectItemByTypeId(@RequestParam("dictypeid") String dictypeid){
		return allservice.getdicitemBll().selectItemByTypeid(Integer.parseInt(dictypeid));
	}
	//删除dictype
	@RequestMapping(value="/DelDictype",method=RequestMethod.POST)
	public @ResponseBody  boolean DelDictype(@RequestParam("dictypeid") String dictypeid){
		return allservice.getdicTypeBLL().DelDictype(Integer.parseInt(dictypeid));
	}
	//添加字典类型
	@RequestMapping(value="/InsertDictype",method=RequestMethod.POST)
	public @ResponseBody boolean InsertDictype(@RequestParam("typename") String typename,@RequestParam("memo")String memo){
		System.out.println(typename+memo);
		dictype dic=new dictype();
		dic.setDicname(typename);
		dic.setMemo(memo);
		allservice.getdicTypeBLL().InsertDictype(dic);
		return true;
	}	
}
