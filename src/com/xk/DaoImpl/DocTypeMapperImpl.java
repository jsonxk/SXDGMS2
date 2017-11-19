package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.DoctypeMapper;
import com.xk.orm.Doctype;

/**
 * @author: xk
 * @date:2017年11月14日 下午1:14:37
 * @version :
 * 
 */
@Repository
public class DocTypeMapperImpl implements DoctypeMapper{
	@Autowired
	private DoctypeMapper doctypemapper;
	@Override
	public List<Doctype> SelectDoctypeByStatus(Integer dicitemid) {
		return doctypemapper.SelectDoctypeByStatus(dicitemid);
	}
}
