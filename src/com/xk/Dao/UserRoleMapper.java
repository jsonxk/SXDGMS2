package com.xk.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xk.orm.User;
import com.xk.orm.UserRole;
/*
 * 用户角色
 */
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userroleid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userroleid);
    /*
     * 根据userid找到roleid
     */
    List<UserRole> selectroleidByUserid(@Param("userid") Integer userid);
    int updateByPrimaryKeySelective(UserRole record);
    /*
     * 添加用户角色
     */
    int insertRoleByUserid(UserRole userrole);
    /*
     * 删除用户角色
     */
    int deleteByuseridRoleid(UserRole userRole);
    int updateByPrimaryKey(UserRole record);
    /**
     * 根据roleid 查找用户id
     * @param repairId（roleid）
     * @return
     */
	List<UserRole> SelectRepairUsers(@Param("repairId")int repairId);
}