package com.example.demo.service;

import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;

import java.sql.SQLException;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 14:52
 * @Description:
 */
public interface LoginService {

    void login(RequestModel<User> requestModel,User user)throws SQLException;
}
