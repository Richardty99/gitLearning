package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteUserInIds(String userIds);

    User selectUserByAccount(@Param("account")String account );
}