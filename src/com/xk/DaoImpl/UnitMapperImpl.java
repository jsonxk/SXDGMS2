package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.UnitMapper;
import com.xk.orm.Unit;
@Repository
public class UnitMapperImpl {
@Autowired 
private UnitMapper unitMapper;
public List<Unit> selectAllUnitName(){
	return unitMapper.selectAllUnitName();
}
}
