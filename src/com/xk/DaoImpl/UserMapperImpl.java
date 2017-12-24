package com.xk.DaoImpl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.Dao.UserMapper;
import com.xk.orm.User;
import com.xk.orm.UserInfo;

@Repository
public class UserMapperImpl {
@Autowired private UserMapper userMapper;
	public User LoginJudgy(String username,String password)
	{
		return userMapper.LoginJudgy(username, password);
	}
	public List<UserInfo> selectallUser()
	{
		return userMapper.selectallUser();
	}
	public List<UserInfo> selectUserByInfo(UserInfo info){
		return userMapper.selectUserByInfo(info);
	}
	public int deleteByUserid(Integer userid)
	{
		return userMapper.deleteByUserid(userid);
	}
	public List<UserInfo> SelectUserByUserId(int userid){
		return userMapper.SelectUserByUserId(userid);
	}
	/**
	 * 手机端登录
	 * @param username
	 * @param password
	 * @return
	 */
	public JSONArray AppUserLogin(String username, String password) {
		List<UserInfo> userinfoList=userMapper.AppUserLogin(username,password);
		if(userinfoList.size()>0)
		{
			return JSONArray.fromObject(userinfoList);
		}
		return null;
	}
}
