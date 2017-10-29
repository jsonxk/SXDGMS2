package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.dicitemMapper;
import com.xk.Dao.dictypeMapper;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

/**
 * @author: xk
 * @date:2017年10月27日 下午11:38:18
 * @version :
 * 
 */
@Repository
public class dictypeMapperImpl {
	@Autowired
	private dictypeMapper dictypeMapper;
	@Autowired
	private dicitemMapper dicitemMapper;
	// 分页查询字典类型信息
	public List<dictype> selectAlltype(Integer offset, Integer pagesize) {
		return dictypeMapper.selectAlltype(offset, pagesize);
	}
	//获取字典总数
	public int selectTotalCount() {
		return dictypeMapper.selectTotalCount();
	}
	/*
	 * 查找信息
	 */
	public List<dictype> selectTypeByInfo(String typename){
		return dictypeMapper.selectTypeByInfo(typename);
	}
	/*
	 * 根据 dictypeid获取类型详细信息
	 */
	public List<dicitem> selectItemByTypeid(int dictypeid)
	{
		return dicitemMapper.selectItemByTypeid(dictypeid);
	}
	public int DelDictype(Integer dictypeid){
		return dictypeMapper.DelDictype(dictypeid);
	}
	public int InsertDictype(dictype dictype) {
		// TODO Auto-generated method stub
		return dictypeMapper.InsertDictype(dictype);
	}
}
