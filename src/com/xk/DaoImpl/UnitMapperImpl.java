package com.xk.DaoImpl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.UnitMapper;
import com.xk.orm.Unit;
@Repository
public class UnitMapperImpl {
@Autowired 
private UnitMapper unitMapper;
//获取所有单位信息
	public List<Unit> selectAllUnitName(){
		return unitMapper.selectAllUnitName();
	}
	//查找信息
	public List<Unit> selectUnitByname(String unitname){
		return unitMapper.selectUnitByname(unitname);
	}
	public List<Unit> selectAllUnitPage(int pagesize, int offset) {
		// TODO Auto-generated method stub
		return unitMapper.selectAllUnitpage(pagesize, offset);
	}
	public int selectCount(){
		return unitMapper.selectCount();
	}
}
