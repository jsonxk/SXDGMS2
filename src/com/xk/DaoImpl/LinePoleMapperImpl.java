package com.xk.DaoImpl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.PoleMapper;
import com.xk.Dao.PowerLineMapper;
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
}
