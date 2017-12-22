package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.HangDetailMapper;
import com.xk.Dao.HangLineMapper;
import com.xk.Dao.PoleMapper;
import com.xk.orm.HangDetail;
import com.xk.orm.HangDetailList;
import com.xk.orm.HangLine;
import com.xk.orm.Pole;
import com.xk.orm.PublicEntity;

/**
 * @author: xk
 * @date:2017年11月23日 下午7:16:44
 * @version :
 * 搭挂线路管理数据层
 */
@Repository
public class HangLineMapperImpl implements HangLineMapper,HangDetailMapper{
	@Autowired
	private HangLineMapper hangLineMapper;
	@Autowired
	private HangDetailMapper hangDetail;
	@Autowired
	private PoleMapper poleMapper;
	/**
	 * 查找所有的搭挂线路信息
	 * @param publicEntity
	 * @return
	 */
	public List<HangLine> SelectAllHangLine(PublicEntity publicEntity) {
		return hangLineMapper.SelectAllHangLine(publicEntity);
	}
	/**
	 * 查找搭挂线路信息数量
	 */
	@Override
	public int SelectAllHangLineCount(PublicEntity publicEntity) {
		return hangLineMapper.SelectAllHangLineCount(publicEntity);
	}
	/**
	 * 查找搭挂线杆信息
	 * @param hanglineid
	 * @return
	 */
	public List<Pole> selectHangPole(int hanglineid) {
		return hangDetail.selectHangPole(hanglineid);
	}
	/**
	 * 添加搭挂线路信息
	 * @param hangline
	 * @return
	 */
	public int insertHangLine(HangLine hangline) {
		hangLineMapper.insertHangLine(hangline);
		return hangline.getHanglineid();
	}
	/**
	 * 添加搭挂线杆信息
	 * @param hangDetail2
	 * @return
	 */
	public int InsertHangPoleDetail(HangDetail hangDetail2) {
		return hangDetail.InsertHangPoleDetail(hangDetail2);
	}
	/**
	 * 查找所有搭挂线路信息
	 * @return
	 */
	public List<HangLine> SelectAllHangLineName() {
		return hangLineMapper.SelectAllHangLineName();
	}
	/**
	 * 查询所有搭挂线杆信息
	 * @return
	 */
	public List<Pole> selectAllHangPoleName() {
		return poleMapper.selectAllPole();
	}
	/**
	 * 根据poleid查找搭挂线路信息
	 * @param poleid
	 * @return
	 */
	public List<HangLine> FaultPoleOfLine(int poleid) {
		return hangLineMapper.FaultPoleOfLine(poleid);
	}
	/**
	 * 根据poleid查找搭挂线路信息
	 * @param poleid
	 * @return
	 */
	public List<HangDetailList> SelectHangLineByPoleid(int poleid) {
		return hangDetail.SelectHangLineByPoleid(poleid);
	}
	/**
	 * 查找搭挂线路信息
	 * @param name
	 * @return
	 */
	public List<HangLine> SelectHangInfoByName(String name) {
		return hangLineMapper.SelectHangInfoByName(name);
	}
	/**
	 * 根据hanglineid查找搭挂信息
	 * @param hanglineid
	 * @return
	 */
	public List<HangLine> SelectHangLineByHangLineId(int hanglineid) {
		return hangLineMapper.SelectHangLineByHangLineId(hanglineid);
	}
	/**
	 * 根据那name查找搭挂线路信息
	 * @param hangname
	 * @return
	 */
	public List<HangLine> SelectHangLineByName(String hangname) {
		return hangLineMapper.SelectHangLineByName(hangname);
	}
	/**
	 * 根据那name查找搭挂线路信息精确查找
	 * @param hangname
	 * @return
	 */
	public List<HangLine> SelectHangLineByAllName(String hangname) {
		return hangLineMapper.SelectHangLineByAllName(hangname);
	}
	/**
	 * 根据hanglineid查找线杆信息
	 * @param hanglineid
	 * @return
	 */
	public List<HangDetail> SelectHangPoleByHangLineid(int hanglineid) {
		return hangDetail.SelectHangPoleByHangLineid(hanglineid);
	}
	/**
	 * 查找搭挂线路信息{hangdetailid：[hangdetailList]}
	 * @return
	 */
	public List<HangDetailList> selectAllHangAndPole() {
		return hangDetail.selectAllHangAndPole();
	}
	/**
	 * 批量添加搭挂详情信息
	 * @param hangline
	 */
	public int InsertHangDetailList(HangLine hangline) {
		return hangDetail.InsertHangDetailList(hangline);
	}
	/**
	 * 修改搭挂线路信息
	 * @param hangline
	 * @return
	 */
	public int ModifyHangLine(HangLine hangline) {
		return hangLineMapper.ModifyHangLine(hangline);
	}
	/**
	 * 根据hanglined查找pole信息
	 */
	@Override
	public List<HangDetail> SelectHangDetailPole(int hanglineid) {
		return hangDetail.SelectHangDetailPole(hanglineid);
	}
	/**
	 * 修改搭挂线杆信息
	 * @param hangDetail2
	 * @return
	 */
	public int ModifyHangPole(HangDetail hangDetail2) {
		return hangDetail.ModifyHangPole(hangDetail2);
	}
	/**
	 * 删除hangline以及hangdetail
	 * @param hanglineid
	 * @return
	 */
	public int DelHangLine(int hanglineid) {
		return hangLineMapper.DelHangLine(hanglineid);
	}
	/**
	 * 根据handdetailid删除搭挂线杆信息
	 * @param handdetailid
	 * @return
	 */
	public int DelHangPole(int handdetailid) {
		return hangDetail.DelHangPole(handdetailid);
	}
}
