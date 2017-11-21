package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Pole;
import com.xk.orm.PowerLine;
import com.xk.orm.PublicEntity;
import com.xk.orm.dicitem;

/**
 * @author: xk
 * @date:2017年11月21日 上午11:21:48
 * @version :
 * 线路线杆逻辑层
 */
@Service
public class LinePoleBLL {
	@Autowired
	private AllDao allDao;
	/**
	 * 某用户单位电力线路信息
	 * @param searchinfo{pagesize,offset,name,userid,unitid}
	 * @return{rows:[],total:""}
	 */
	public JSONArray SelectAllLine(PublicEntity searchinfo) {
		int count=allDao.getLinePoleMapperImpl().SelectAllLineCount(searchinfo);
		List<PowerLine> lineList=allDao.getLinePoleMapperImpl().SelectAllLine(searchinfo);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		for(PowerLine line:lineList)
		{
			if(line.getCreatetime()!=null)
			{
				line.setTime(format.format(line.getCreatetime()).toString());
			}
		}
		JSONArray jadata=new JSONArray();
		JSONObject jodata=new JSONObject();
		jodata.put("rows", JSONArray.fromObject(lineList));
		jodata.put("total", count);
		jadata.add(jodata);
		return jadata;
	}
	/**
	 * 根据lineid查找pole信息
	 * @param lineid
	 * @return
	 */
	public JSONArray SelectPoleInfo(int lineid) {
		List<Pole> poleinfo=allDao.getLinePoleMapperImpl().SelectPoleInfo(lineid);
		return JSONArray.fromObject(poleinfo);
	}
}
