package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.dictypeMapper;
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

	// 分页查询字典类型信息
	public List<dictype> selectAlltype(Integer offset, Integer pagesize) {
		return dictypeMapper.selectAlltype(offset, pagesize);
	}

	public int selectTotalCount() {
		return dictypeMapper.selectTotalCount();
	}
}
