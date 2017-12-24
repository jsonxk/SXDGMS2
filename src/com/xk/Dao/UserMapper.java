package com.xk.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.User;
import com.xk.orm.UserInfo;
/*
 * 用户
 */
public interface UserMapper {
    User LoginJudgy(@Param("username")String username,@Param("password") String password);
    
    /*
     * 获取所有用户
     */
    List<UserInfo> selectallUser() ;
    /*
     * 根据信息查找用户
     */
    List<UserInfo> selectUserByInfo(UserInfo user);
    /*
     * 删除某个用户
     */
    int deleteByUserid(@Param("userid")Integer userid);
    /**
     * 根据userid查找信息
     * @param userid
     * @return
     */
    List<UserInfo> SelectUserByUserId(@Param("userid") int userid);
    /**
     * app登录
     * @param username
     * @param password
     * @return
     */
	List<UserInfo> AppUserLogin(@Param("username")String username,@Param("password") String password);
}