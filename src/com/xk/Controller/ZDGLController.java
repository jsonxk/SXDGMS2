package com.xk.Controller;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xk
 * @date:2017年10月27日 下午9:29:31
 * @version :
 * 
 */
@Controller
@RequestMapping("/ZDGL")
public class ZDGLController {
	@RequestMapping(value="/selectAllType",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectAllType(@RequestParam("typename")String typename,@RequestParam("pageNumber")String pageNumber,@RequestParam("pageSize")String pageSize)
	{
		return null;
	}
}
