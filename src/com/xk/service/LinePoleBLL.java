package com.xk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.HangLine;
import com.xk.orm.LineDetail;
import com.xk.orm.LineDetailList;
import com.xk.orm.Photo;
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
	 * 某单位电力线路信息
	 * @param searchinfo{pagesize,offset,name,userid,unitid}
	 * @return{rows:[],total:""}
	 */
	public JSONArray SelectAllLine(PublicEntity searchinfo) {
		int count=allDao.getLinePoleMapperImpl().SelectAllLineCount(searchinfo);
		List<PowerLine> lineList=allDao.getLinePoleMapperImpl().SelectAllLine(searchinfo);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		for(PowerLine line:lineList)
		{
			if(line.getCreatetime()!=null)
			{
				line.setTime(format.format(line.getCreatetime()).toString());
			}
			int  polecount=allDao.getLinePoleMapperImpl().SelectPoleCount(line.getLineid());
			line.setLineNum(polecount+"");
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
	/**
	 * 添加线路信息 同时添加首杆尾杆信息
	 * @param PowerLine
	 * @return{boolean}
	 */
	public boolean InsertLineInfo(PowerLine powerLine) {
		/**
		 * lineid主键
		 */
		int LineKeyId=allDao.getLinePoleMapperImpl().InsertLineInfo(powerLine);
		/**
		 * 添加线杆poleid主键
		 */
		int polereturn1=0,polereturn2=0;
		int InsertLinePoleDetail=0;
		Pole pole=new Pole();
		//SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<2;i++)
		{
			pole.setLineid(LineKeyId);
			pole.setUnitid(powerLine.getUnitid());
			pole.setName(powerLine.getName());
			pole.setTimeString(powerLine.getTimeString());
			pole.setPositionmethod(24);
			pole.setHeight(17);
			pole.setMemo(powerLine.getMemo());
			//pole.setType(powerLine.getType());
			//pole.setStatus(powerLine.getStatus());
			if(i==0)
			{
				pole.setCode(powerLine.getCode());
				pole.setLongtitude(powerLine.getLineFirstPolelon());
				pole.setLatitude(powerLine.getLineFirstPolelat());
				pole.setName(powerLine.getName()+"起杆");
				//polereturn1=allDao.getLinePoleMapperImpl().InsertPoleInfo(pole);
				pole.setPoleid(polereturn1);
				powerLine.setFirstpoleid(polereturn1);
				/**
				 * 首尾杆信息添加到明细表
				 */
				//InsertLinePoleDetail=allDao.getLinePoleMapperImpl().InsertLinePoleDetail(pole);
			}
			else{
				pole.setCode(powerLine.getCode());
				pole.setLongtitude(powerLine.getLineLastPolelon());
				pole.setLatitude(powerLine.getLineLastPolelat());
				pole.setName(powerLine.getName()+"尾杆");
				//polereturn2=allDao.getLinePoleMapperImpl().InsertPoleInfo(pole);
				powerLine.setFinallypoleid(polereturn2);
				/**
				 * 首尾杆信息添加到明细表
				 */
				//InsertLinePoleDetail=allDao.getLinePoleMapperImpl().InsertLinePoleDetail(pole);
			}
			/**
			 * 添加首尾杆到线路表
			 */
			int modifyline=allDao.getLinePoleMapperImpl().ModifyLinePoleId(powerLine);
		}
		return false;
	}
	/**
	 * 添加线杆信息 
	 * @param pole
	 * @return
	 */
	public JSONArray InsertPoleInfo(Pole pole) {
		int poleid=allDao.getLinePoleMapperImpl().InsertPoleInfo(pole);
		JSONArray jadata=new JSONArray();
		JSONObject jodata=new JSONObject();
		if(poleid>0)
		{
			jodata.put("poleid", poleid);
		}
		else{
			jodata.put("poleid", "");
		}
		jadata.add(jodata);
		return jadata;
	}
	/**
	 * 加载所有线杆信息
	 * @return
	 */
	public JSONArray selectAllPole() {
		List<Pole> listPole=allDao.getLinePoleMapperImpl().SelectPoleInfo(0);
		return JSONArray.fromObject(listPole);
	}
	/**
	 * 加载所有线路信息
	 * @return
	 */
	public JSONArray selectAllLineName() {
		return JSONArray.fromObject(allDao.getLinePoleMapperImpl().selectAllLineName());
	}
	/**
	 * 添加线路明细
	 * @param lineDetail
	 * @return
	 */
	public boolean insertPoleLineDetail(LineDetail lineDetail) {
		List<PowerLine> alllineLines=allDao.getLinePoleMapperImpl().selectAllLineName();
		for(PowerLine line:alllineLines)
		{
			if(line.getLineid()==lineDetail.getLineid())
			{
				lineDetail.setName(line.getName()+"#"+lineDetail.getCode());
			}
		}
		//lineDetail.setName(lineDetail);
		int i=allDao.getLinePoleMapperImpl().insertPoleLineDetail(lineDetail);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 修改线杆经纬度
	 * @param pole{poleid,lng,lat}
	 * @return
	 */
	public boolean ModifyPolePosition(Pole pole) {
		int i=allDao.getLinePoleMapperImpl().ModifyPolePosition(pole);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 根据poleid查找所属电力线路
	 * @param poleid
	 * @return
	 */
	public JSONArray SelectAllLineByPoleid(int poleid) {
		/**
		 * 根据poleid查找所有的lineDetail
		 */
		//JSONArray jadata=new 
		List<LineDetailList> Ofline=allDao.getLinePoleMapperImpl().SelectAllLineIdByPoleid(poleid);
		return JSONArray.fromObject(Ofline);
	}
	/**
	 * 根据poleid查找线杆信息
	 * @param poleid
	 * @return
	 */
	public JSONArray SelectPoleInfoByPoleid(int poleid) {
		List<Pole> poleinfo=allDao.getLinePoleMapperImpl().SelectPoleInfoByPoleId(poleid);
		List<Pole> listPole=allDao.getLinePoleMapperImpl().SelectPoleInfo(0);
		System.out.println(JSONArray.fromObject(listPole));
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		for(Pole pole:poleinfo)
		{
			if(pole.getCreatetime()!=null)
			{
				pole.setTimeString(format.format(pole.getCreatetime()));
			}
			for(int i=0;i<pole.getLinedetailList().size();i++)
			{
				for(Pole p:listPole)
				{
					System.out.println(pole.getLinedetailList().get(i).getPrepoleid()+"ffff"+p.getPoleid());
					if(p.getPoleid().equals(pole.getLinedetailList().get(i).getPrepoleid()))
					{
						pole.getLinedetailList().get(i).setPrepolename(p.getLinedetailList().get(0).getName());
						return JSONArray.fromObject(poleinfo);
					}
				}
			}
		}
		return JSONArray.fromObject(poleinfo);
	}
	/**
	 * 搜索电力线路，搭挂线路，线杆
	 * @param name
	 * @return
	 */
	public JSONArray SelectAllInfo(String name) {
		JSONObject jodata=new JSONObject();
		JSONArray jadata=new JSONArray();
		/**
		 * 线杆信息
		 */
		List<Pole> poleinfo=allDao.getLinePoleMapperImpl().SelectPoleInfoByName(name);
		/**
		 * 电力线路信息
		 */
		List<PowerLine> lineinfo=allDao.getLinePoleMapperImpl().SelectLineInfoByName(name);
		/**
		 * 搭挂线路
		 */
		List<HangLine> hanginfo=allDao.getHangLineMapperImpl().SelectHangInfoByName(name);
		jodata.put("poleinfo", poleinfo);
		jodata.put("lineinfo", lineinfo);
		jodata.put("hangline", hanginfo);
		jadata.add(jodata);
		return jadata;
	}
	/**
	 * 根据lineid查找电力线路信息
	 * @param lineid
	 * @return
	 */
	public JSONArray SelectLineInfoByLineId(int lineid) {
		List<PowerLine> lineInfo=allDao.getLinePoleMapperImpl().SelectLineInfoByLineId(lineid);
		return JSONArray.fromObject(lineInfo);
	}
	/**
	 * 查找搭挂线杆信息
	 * @param polename
	 * @return
	 */
	public JSONArray SelectHangPoleByName(String polename) {
		List<Pole> poleinfo=allDao.getLinePoleMapperImpl().SelectPoleInfoByName(polename);
		return JSONArray.fromObject(poleinfo);
	}
	/**
	 * 查找搭挂线杆信息精确
	 * @param polename
	 * @return
	 */
	public JSONArray SelectHangPoleByAllName(String polename) {
		List<Pole> poleinfo=allDao.getLinePoleMapperImpl().SelectPoleInfoByAllName(polename);
		return JSONArray.fromObject(poleinfo);
	}
	/**
	 * 删除线杆并删除相关的搭挂详情和线路详情
	 * @param poleid
	 * @return
	 */
	public JSONArray DelPoleByPoleId(int poleid) {
		/**
		 * 查询当前线杆是否有所属的搭挂线路
		 */
		
		/**
		 * 删除线杆并删除相关的搭挂详情和线路详情
		 */
		int i=allDao.getLinePoleMapperImpl().DelPoleByPoleId(poleid);
		if(i>0)
		{
			/**
			 * 修改hangdetail中所有prevpoleid为空
			 * linedetail
			 */
			allDao.getLinePoleMapperImpl().ModifyPrevPoleIdByPoleId(poleid);
			return JSONArray.fromObject("[{'msg':'删除线杆成功'}]");
		}
		else{
			return JSONArray.fromObject("[{'msg':'删除线杆失败'}]");
		}
	}
	/**
	 * 地图上添加电力线路及相关poleid和linedetail
	 * @param pLine
	 * @return
	 */
	public JSONArray InsertNewLineAndDetail(PowerLine pLine) {
		Pole pole=new Pole();
		/**
		 * 电力线路细节信息
		 */
		List<LineDetail> linedetail=new ArrayList<LineDetail>();
		//List<Integer> polelist=new ArrayList<Integer>(); 
		if(pLine.getPoleList().size()>0)
		{
			pole.setUnitid(pLine.getUnitid());
			pole.setTimeString(pLine.getTimeString());
			pole.setPositionmethod(0);
			pole.setHeight(17);
			pole.setType(23);
			pole.setStatus(pLine.getPolestatus());
			for(int i=0;i<pLine.getPoleList().size();i++)
			{
				/**
				 * 添加线杆信息返回主键
				 */
				pole.setCode(pLine.getPoleList().get(i).getCode());
				pole.setLongtitude(pLine.getPoleList().get(i).getLongtitude());
				pole.setLatitude(pLine.getPoleList().get(i).getLatitude());
				int RtnPoleid=allDao.getLinePoleMapperImpl().InsertPoleInfo(pole);
				/**
				 * 设置返回的主键poleid
				 * List加入对象是因为加入的是引用地址所以需要一个对象
				 */
				LineDetail lDetail=new LineDetail();
				lDetail.setPoleid(RtnPoleid);
				System.out.println(lDetail.getPoleid());
				lDetail.setCode(pLine.getPoleList().get(i).getCode());
				lDetail.setName(pLine.getPoleList().get(i).getName());
				linedetail.add(lDetail);
			}
			System.out.println(JSONArray.fromObject(linedetail));
			pLine.setFirstpoleid(linedetail.get(0).getPoleid());
			pLine.setFinallypoleid(linedetail.get(linedetail.size()-1).getPoleid());
			/**
			 * 添加电力线路
			 */
			int RtnLineid=allDao.getLinePoleMapperImpl().InsertLineInfo(pLine);
			System.out.println(RtnLineid);
			for(int j=0;j<linedetail.size();j++)
			{
				linedetail.get(j).setLineid(RtnLineid);
				System.out.println(linedetail.get(j).getLineid());
				if(j>0)
				{
					/**
					 * 设置前一杆prepoleid
					 */
					linedetail.get(j).setPrepoleid(linedetail.get(j-1).getPoleid());
				}
			}
			System.out.println(JSONArray.fromObject(linedetail));
			/**
			 * 批量添加电力线路细节
			 */
			LineDetailList detailList=new LineDetailList();
			detailList.setLineList(linedetail);
			int lDetailId=allDao.getLinePoleMapperImpl().InsertLineDetailList(detailList);
			if(lDetailId>0)
			{
				return JSONArray.fromObject("[{'msg':'添加线路成功'}]");
			}
		}
		return null;
	}
	/**
	 * 修改电力线路信息
	 * @param pLine
	 * @return boolean
	 */
	public boolean ModifyLineInfo(PowerLine pLine) {
		int i=allDao.getLinePoleMapperImpl().ModifyLineInfo(pLine);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 删除电力线路信息
	 * @param lineid
	 * @return
	 */
	public boolean DelLineInfo(int lineid) {
		int i=allDao.getLinePoleMapperImpl().DelLineInfo(lineid);
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * 根据poleid查找线杆信息
	 * @param poleid
	 * @return
	 */
	public JSONArray SelectPolePhoto(int poleid) {
		List<Photo> photoList=allDao.getFaultMapperImpl().SelectPolePhoto(poleid);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		for(Photo p:photoList)
		{
			p.setStringcreatetime(format.format(p.getCreatetime()));
		}
		return JSONArray.fromObject(photoList);
	}
}
