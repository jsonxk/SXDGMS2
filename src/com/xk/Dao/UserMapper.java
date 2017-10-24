package com.xk.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.User;
import com.xk.orm.UserInfo;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

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

    int updateByPrimaryKey(User record);
}