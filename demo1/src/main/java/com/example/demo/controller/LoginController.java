package com.example.demo.controller;

import com.example.demo.base.common.Result;
import com.example.demo.base.contants.BaseContants;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HX001
 * @Date: 2019/4/8 16:38
 * @Description:
 */
@Api(value = "登陆接口")
@RestController
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    public ResponseEntity<RequestModel> login(RequestModel<User> requestModel, User user)throws Exception {

            loginService.login(requestModel, user);
            session.setAttribute(BaseContants.LOGIN_USER,requestModel.getData());
            return Result.getSure(requestModel);

    }
}
