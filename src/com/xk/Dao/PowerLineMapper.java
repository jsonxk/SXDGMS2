package com.xk.Dao;

import java.util.List;

import com.xk.orm.PowerLine;
import com.xk.orm.PublicEntity;


public interface PowerLineMapper {
	/**
	 * 所有电力线路信息
	 * @param searchinfo{pagesize,offset,name,userid,unitid}
	 * @return
	 */
	List<PowerLine> SelectAllLine(PublicEntity searchinfo);
	/**
	 * 查找电力线路信息数量
	 * @param sPublicEntity
	 * @return
	 */
	int SelectAllLineCount(PublicEntity sPublicEntity);
}