package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: HX001
 * @Date: 2019/4/8 16:38
 * @Description:
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    public ResponseEntity<User> login(String account, String password){

      return ResponseEntity.ok(User);
    }
}
