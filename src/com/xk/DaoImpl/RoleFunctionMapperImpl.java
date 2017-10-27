package com.xk.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.RoleFunctionMapper;
import com.xk.orm.RoleFunction;

/**
 * @author: xk
 * @date:2017年10月27日 下午2:41:03
 * @version :
 * 
 */
@Repository
public class RoleFunctionMapperImpl{
	@Autowired
	private RoleFunctionMapper rolefuncmapper;
	public int deleteFunc(RoleFunction rf) {
		return rolefuncmapper.deleteFunc(rf);
	}
	public int insertFunc(RoleFunction rf) {
		return rolefuncmapper.insertFunc(rf);
	}
}
