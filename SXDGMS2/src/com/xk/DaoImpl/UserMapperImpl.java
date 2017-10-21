package com.xk.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.UserMapper;
import com.xk.orm.User;

@Repository
public class UserMapperImpl {
@Autowired private UserMapper userMapper;
	public User LoginJudgy(String username,String password)
	{
		return userMapper.LoginJudgy(username, password);
	}
	public List<User> selectallUser()
	{
		return userMapper.selectallUser();
	}
}
