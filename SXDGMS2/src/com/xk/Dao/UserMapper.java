package com.xk.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User LoginJudgy(@Param("username")String username,@Param("password") String password);
    
    List<User> selectallUser() ;
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}