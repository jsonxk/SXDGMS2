package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.HangDetail;
import com.xk.orm.HangLine;
import com.xk.orm.LineDetail;
import com.xk.orm.Pole;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月23日 下午7:12:51
 * @version :
 * 搭挂线路管理逻辑层
 */
@Service
public class DgxlglBLL {
	@Autowired
	private AllDao alldao;
	/**
	 * 查找所有的搭挂线路信息{服务器端分页}
	 * @param publicEntity
	 * @return HangLine
	 */
	public JSONArray SelectAllHangLine(PublicEntity publicEntity) {
		List<HangLine> hlineData=alldao.getHangLineMapperImpl().SelectAllHangLine(publicEntity);
		int count=alldao.getHangLineMapperImpl().SelectAllHangLineCount(publicEntity);
		JSONArray jadata=new JSONArray();
		JSONObject jodata=new JSONObject();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(hlineData.size()+"萨达撒多");
		for(HangLine line:hlineData)
		{
			if(line.getCreatetime()!=null)
			{
				line.setTimeString(format.format(line.getCreatetime()));
			}
		}
		jodata.put("rows",JSONArray.fromObject(JSONArray.fromObject(hlineData)));
		jodata.put("total",count);
		jadata.add(jodata);
		return jadata;
	}
	/**
	 * 查找搭挂线杆信息
	 * @param hanglineid
	 * @return
	 */
	public JSONArray selectHangPole(int hanglineid) {
		List<HangDetail> polelist=alldao.getHangLineMapperImpl().SelectHangDetailPole(hanglineid);
		return JSONArray.fromObject(polelist);
	}
	/**
	 * 添加搭挂线路信息
	 * @param hangline
	 * @return
	 */
	public boolean insertHangLine(HangLine hangline) {
		int i=alldao.getHangLineMapperImpl().insertHangLine(hangline);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 添加线杆信息
	 * @param hangDetail
	 * @return
	 */
	public boolean InsertHangPoleDetail(HangDetail hangDetail) {
		hangDetail.setGetmethod(24);
		int i=alldao.getHangLineMapperImpl().InsertHangPoleDetail(hangDetail);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 查找所有搭挂线路信息
	 * @return
	 */
	public JSONArray SelectAllHangLineName() {
		List<HangLine> lineinfo=alldao.getHangLineMapperImpl().SelectAllHangLineName();
		return JSONArray.fromObject(lineinfo);
	}
	/**
	 * 查询所有搭挂线杆信息
	 * @return
	 */
	public JSONArray selectAllHangPoleName() {
		List<Pole> Poleinfo=alldao.getHangLineMapperImpl().selectAllHangPoleName();
		return JSONArray.fromObject(Poleinfo);
	}
	/**
	 * 修改搭挂线路信息
	 * @param hangline
	 * @return
	 */
	public boolean ModifyHangLine(HangLine hangline) {
		int i=alldao.getHangLineMapperImpl().ModifyHangLine(hangline);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 修改搭挂线杆信息
	 * @param hangDetail
	 * @return
	 */
	public boolean ModifyHangPole(HangDetail hangDetail) {
		int i=alldao.getHangLineMapperImpl().ModifyHangPole(hangDetail);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 删除搭挂线路信息
	 * hangline,hangdetail
	 * @param hanglineid
	 * @return
	 */
	public boolean DelHangLine(int hanglineid) {
		int i=alldao.getHangLineMapperImpl().DelHangLine(hanglineid);
		if(i>0)
		{
			return true;
		}
			return false;
	}
	/**
	 * 根据handdetailid删除搭挂线杆信息
	 * @param handdetailid
	 * @return
	 */
	public boolean DelHangPole(int handdetailid) {
		int  i=alldao.getHangLineMapperImpl().DelHangPole(handdetailid);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}

}
