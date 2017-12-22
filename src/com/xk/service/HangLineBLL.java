package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.CheckType;
import com.xk.orm.HangDetail;
import com.xk.orm.HangDetailList;
import com.xk.orm.HangLine;
import com.xk.orm.LineDetail;
import com.xk.orm.Pole;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

/**
 * @author: xk
 * @date:2017年11月9日 下午6:09:31
 * @version :
 * 
 */
@Service
public class HangLineBLL {
	@Autowired
	private AllDao alldao;
	/*
	 * 所有申请线路的状态
	 */
	public JSONArray SelectHangLineStatus(String typename)
	{
		List<dictype> typelist=alldao.getdictypeMapperImpl().selectTypeByInfo(typename);
		List<dicitem> typeitem=null;
		JSONArray data=new JSONArray();
		JSONObject jodata=new JSONObject();
		for(dictype type:typelist)
		{
			typeitem=alldao.getdicitemMapperImpl().selectItemByTypeid(type.getDictypeid());
			for(dicitem item:typeitem)
			{
				jodata.put("dicitemid", item.getDicitemid());
				jodata.put("item", item.getItem());
				jodata.put("Code", item.getCode());
				jodata.put("memo", item.getMemo());
				data.add(jodata);
			}
		}
		return data;
	}
		/**
	 * 根据poleid查找搭挂信息
	 * @param poleid
	 * @return
	 */
	public JSONArray SelectHangLineByPoleid(int poleid) {
		List<HangDetailList> hangdetail=alldao.getHangLineMapperImpl().SelectHangLineByPoleid(poleid);
		return JSONArray.fromObject(hangdetail);
	}
	/**
	 * 查找搭挂线路信息
	 * @param hanglineid
	 * @return
	 */
	public JSONArray SelectHangLineByHangLineId(int hanglineid) {
		List<HangLine> hanglineList=alldao.getHangLineMapperImpl().SelectHangLineByHangLineId(hanglineid);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<LineDetail> lineinfo=null;
		for(HangLine hl:hanglineList)
		{
			if(hl.getCreatetime()!=null)
			{
				hl.setTimeString(format.format(hl.getCreatetime()));
			}
			for(int i=0;i<hl.getHangList().size();i++)
			{
				lineinfo=alldao.getLinePoleMapperImpl().selectAllHangDetail(hl.getHangList().get(i).getPoleid());
				hl.getHangList().get(i).setPolename(lineinfo.get(0).getName());
			}
		}
		return JSONArray.fromObject(hanglineList);
	}
	/**
	 * 根据hangname查找搭挂线路
	 * @param hangname
	 * @return
	 */
	public JSONArray SelectHangLineByName(String hangname) {
		List<HangLine> hangdetail=alldao.getHangLineMapperImpl().SelectHangLineByName(hangname);
		return JSONArray.fromObject(hangdetail);
	}
	/**
	 * 根据hangname查找搭挂线路精确查找
	 * @param hangname
	 * @return
	 */
	public JSONArray SelectHangLineByAllName(String hangname) {
		List<HangLine> hangdetail=alldao.getHangLineMapperImpl().SelectHangLineByAllName(hangname);
		return JSONArray.fromObject(hangdetail);
	}

	/**
	 * 根据hanglineid查找poleid
	 * @param hanglineid
	 * @return
	 */
	public JSONArray SelectHangPoleByHangLineid(int hanglineid) {
		List<HangDetail> detailinfo=alldao.getHangLineMapperImpl().SelectHangPoleByHangLineid(hanglineid);
		return JSONArray.fromObject(detailinfo);
	}
	/**
	 * 查找搭挂线路细节，组装poleid信息
	 * @return
	 */
	public JSONArray selectAllHangAndPole() {
		List<HangDetailList> hangDtl=alldao.getHangLineMapperImpl().selectAllHangAndPole();
		//List<Object> liatall=new ArrayList<Object>();
		List<Pole> poleinfo=null;
		//JSONArray jadata=new JSONArray();
		for(int i=0;i<hangDtl.size();i++)
		{
			if(hangDtl.get(i).getHangList().size()>0)
			{
				for(int j=0;j<hangDtl.get(i).getHangList().size();j++)
				{
					poleinfo=alldao.getLinePoleMapperImpl().SelectPoleInfoByPoleId(hangDtl.get(i).getHangList().get(j).getPoleid());
					hangDtl.get(i).getHangList().get(j).setPoleList(poleinfo);
				}
			}
		}
		return JSONArray.fromObject(hangDtl);
	}
	/**
	 * 添加搭挂线路信息及详情
	 * @param hangline
	 * @return
	 */
	public JSONArray InsertHangLineAndDetail(HangLine hangline) {
		/*
		 * 1.添加搭挂线路返回主键id
		 * 2.添加搭挂详情
		 */
		int i=alldao.getHangLineMapperImpl().insertHangLine(hangline);
		System.out.println(i+"dd");
		if(i>0)
		{
			/*for(int j=0;j<hangline.getHangList().size();j++)
			{
				hangline.getHangList().get(j).setHanglineid(i);
				hangline.getHangList().get(j).setGetmethod(24);
				hangline.getHangList().get(j).setStatus(32);
				alldao.getHangLineMapperImpl().InsertHangDetailList(hangline);
			}*/
			for(HangDetail hangdetail:hangline.getHangList())
			{
				hangdetail.setHanglineid(i);
				hangdetail.setGetmethod(24);
				hangdetail.setStatus(32);
			}
			System.out.println(JSONArray.fromObject(hangline.getHangList()));
			int j=alldao.getHangLineMapperImpl().InsertHangDetailList(hangline);
			if(j>0)
			{
				return JSONArray.fromObject("[{'msg':'添加搭挂信息成功'}]");
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}
}
