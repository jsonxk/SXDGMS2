package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.FunctionMapper;
import com.xk.orm.FunctionList;
@Repository
public class FunctionMapperImpl {
	@Autowired
	private FunctionMapper functionMapper;
	public List<FunctionList> selectOnUserid(Integer userid,Integer parentid)
	{
		return functionMapper.selectOnUserid(userid, parentid);
	}
}
