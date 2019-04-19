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

    RequestModel<User> login( String account , String password)throws SQLException;
}
