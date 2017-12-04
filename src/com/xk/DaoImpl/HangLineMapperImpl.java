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
		return hangLineMapper.insertHangLine(hangline);
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

}
