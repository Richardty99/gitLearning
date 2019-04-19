package com.example.demo.service;


import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 08:16
 * @Description:
 */
@Repository
public interface UserService {

   void selectUser(RequestModel requestModel)throws SQLException;

   RequestModel<User> selectUserByAccount(String account)throws SQLException;


}
