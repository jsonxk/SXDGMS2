package com.xk.DaoImpl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.LineDetailMapper;
import com.xk.Dao.PoleMapper;
import com.xk.Dao.PowerLineMapper;
import com.xk.orm.HangLine;
import com.xk.orm.LineDetail;
import com.xk.orm.LineDetailList;
import com.xk.orm.Pole;
import com.xk.orm.PowerLine;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月21日 上午11:25:49
 * @version :
 * 线路线杆管理数据层
 */
@Repository
public class LinePoleMapperImpl implements PowerLineMapper,PoleMapper{
	@Autowired
	private PowerLineMapper powerLineMapper;
	@Autowired
	private PoleMapper poleMapper;
	@Autowired
	private LineDetailMapper lineDetailMapper;
	/**
	 * @param 查询某用户单位电力线路信息
	 * @return 电力信息集合
	 */
	public List<PowerLine> SelectAllLine(PublicEntity searchinfo) {
		return powerLineMapper.SelectAllLine(searchinfo);
	}
	/**
	 * 电力线路数量
	 */
	public int SelectAllLineCount(PublicEntity sPublicEntity) {
		return powerLineMapper.SelectAllLineCount(sPublicEntity);
	}
	/**
	 * 查找线杆信息
	 * @param lineid
	 * @return
	 */
	public List<Pole> SelectPoleInfo(int lineid) {
		return poleMapper.SelectPoleInfo(lineid);
	}
	/**
	 * 添加线路信息
	 */
	public int InsertLineInfo(PowerLine powerLine) {
		powerLineMapper.InsertLineInfo(powerLine);
		return powerLine.getLineid();
	}
	/**
	 * 添加线杆信息
	 */
	@Override
	public int InsertPoleInfo(Pole pole) {
		poleMapper.InsertPoleInfo(pole);
		return pole.getPoleid();
	}
	/**
	 * 添加首尾杆id
	 * @param powerLine
	 * @return
	 */
	public int ModifyLinePoleId(PowerLine powerLine) {
		return powerLineMapper.ModifyLinePoleId(powerLine);
	}
	/**
	 * 添加线路明细表
	 * @param powerLine
	 * @return
	 */
	public int InsertLinePoleDetail(Pole powerLine) {
		return lineDetailMapper.InsertLinePoleDetail(powerLine);
	}
	/**
	 * 加载所有的线杆信息
	 * @return
	 */
	public List<Pole> selectAllPole() {
		return poleMapper.selectAllPole();
	}
	/**
	 * 加载所有线路信息
	 * @return
	 */
	public List<PowerLine> selectAllLineName() {
		return powerLineMapper.selectAllLineName();
	}
	/**
	 * 添加线路线杆明细
	 * @param lineDetail
	 * @return
	 */
	public int insertPoleLineDetail(LineDetail lineDetail) {
		return lineDetailMapper.insertPoleLineDetail(lineDetail);
	}
	/**
	 * 修改线杆经纬度
	 * @param pole
	 * @return
	 */
	public int ModifyPolePosition(Pole pole) {
		// TODO Auto-generated method stub
		return poleMapper.ModifyPolePosition(pole);
	}
	/**
	 * 根据poleid查找所有电力线路信息
	 * @param poleid
	 * @return
	 */
	public List<LineDetailList> SelectAllLineIdByPoleid(int poleid) {
		return lineDetailMapper.SelectAllLineIdByPoleid(poleid);
	}
	/**
	 * 根据poleid查找pole基本信息
	 * @param poleid
	 * @return
	 */
	public List<Pole> SelectPoleInfoByPoleId(int poleid) {
		return poleMapper.SelectPoleInfoByPoleId(poleid);
	}
	/**
	 * 搜索线杆信息
	 * @param name
	 * @return
	 */
	public List<Pole> SelectPoleInfoByName(String name) {
		return poleMapper.SelectPoleInfoByName(name);
	}
	/**
	 * 搜索线杆信息精确
	 * @param name
	 * @return
	 */
	public List<Pole> SelectPoleInfoByAllName(String name) {
		return poleMapper.SelectPoleInfoByAllName(name);
	}
	/**
	 * 搜索电力线路信息
	 * @param name
	 * @return
	 */
	public List<PowerLine> SelectLineInfoByName(String name) {
		return powerLineMapper.SelectLineInfoByName(name);
	}
	/**
	 * 根据lineid查找电力线路信息
	 * @param lineid
	 * @return
	 */
	public List<PowerLine> SelectLineInfoByLineId(int lineid) {
		return powerLineMapper.SelectLineInfoByLineId(lineid);
	}
	/**
	 * 根据poleid直接查找所有信息
	 * @param poleid
	 * @return
	 */
	public List<LineDetail> selectAllHangDetail(int poleid)
	{
		return lineDetailMapper.selectAllHangDetail(poleid);
	}
	/**
	 * 删除线杆及相关的搭挂，线路详情
	 * @param poleid
	 * @return
	 */
	public int DelPoleByPoleId(int poleid) {
		return poleMapper.DelPoleByPoleId(poleid);
	}
	/**
	 * 根据poleid修改prevpoleid,
	 * @param poleid
	 */
	public int ModifyPrevPoleIdByPoleId(int poleid) {
		return poleMapper.ModifyPrevPoleIdByPoleId(poleid);
	}
	/**
	 * 批量添加电力线路细节
	 * @param linedetail
	 */
	public int InsertLineDetailList(LineDetailList linedetail) {
		return lineDetailMapper.InsertLineDetailList(linedetail);
	}
	/**
	 * 根据lineid查找pole数量
	 */
	public int SelectPoleCount(int lineid){
		return poleMapper.SelectPoleCount(lineid);
	}
	/**
	 * 修改电力线路status  type，unitid,name
	 * @param pLine
	 * @return
	 */
	public int ModifyLineInfo(PowerLine pLine) {
		return powerLineMapper.ModifyLineInfo(pLine);
	}
	/**
	 * 删除电路线路信息
	 * @param lineid
	 * @return
	 */
	public int DelLineInfo(int lineid) {
		return powerLineMapper.DelLineInfo(lineid);
	}
	
}
