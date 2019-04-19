package com.example.demo.dao;

import com.example.demo.base.pojo.QueryParams;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

//    int deleteByPrimaryKey(Integer userId);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(Integer userId);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
//
//    int deleteUserInIds(String userIds);

    User selectUserByAccount(@Param("account")String account); //根据account查询用户

    List<User> selectUser(QueryParams queryParams);//查询所有用户 集合 用于分页查询

}