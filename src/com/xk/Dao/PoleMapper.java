package com.xk.Dao;

import java.util.List;

import net.sf.json.JSONArray;

import com.xk.orm.Pole;

public interface PoleMapper {
	/**
	 * 根据线路查找线杆
	 * @param lineid
	 * @return
	 */
	List<Pole> SelectPoleInfo(int lineid);
  
}