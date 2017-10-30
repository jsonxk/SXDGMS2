package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.dicitemMapper;
import com.xk.orm.dicitem;
import com.xk.orm.dictype;

/**
 * @author: xk
 * @date:2017年10月28日 下午9:20:26
 * @version :
 *字典类型项目 
 */
@Repository
public class DicitemMapperImpl {
	@Autowired
	private dicitemMapper dicitemMapper;
	/*
     * @param dictypeId
     * 根绝字典类型获取详细项目
     */
	public List<dicitem> selectItemByTypeid(int dictypeid){
		return dicitemMapper.selectItemByTypeid(dictypeid);
	}
	/*
	 * 获取所有的项目信息
	 * 用于用户比较是否存在该用户类型
	 */
	public List<dicitem> selectAllItem()
	{
		return dicitemMapper.selectAllItem();
	}
	//添加项目信息
	public int  InsertDicItem(dicitem item) {
		return dicitemMapper.InsertDicItem(item);
	}
}
