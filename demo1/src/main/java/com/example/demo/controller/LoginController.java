package com.example.demo.controller;

import com.example.demo.base.common.Result;
import com.example.demo.base.contants.BaseContants;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;

/**
 * @Auther: HX001
 * @Date: 2019/4/8 16:38
 * @Description:
 */
@Api(value = "登陆接口",tags = "登陆接口")
@Slf4j
@Validated
@Controller
@RequestMapping(value = "/richard/1.0/")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    
    /**
     * 功能描述: 
     * @param: 用户登陆接口
     * @return: user
     * @auther: richard
     * @date: 2019/4/18 10:03
     */

    @ApiOperation(value = "用户登录",httpMethod = "GET",response = RequestModel.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account" , value = "用户账号" , dataType = "String" , paramType = "query" , required = true),
            @ApiImplicitParam(name = "password" , value = "用户密码" , dataType = "String" , paramType = "query" , required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200 , message = "操作成功" , response = RequestModel.class)
    })
    @RequestMapping(path = "login/" , method = RequestMethod.GET)
    public ResponseEntity<RequestModel> login(
            @NotNull
            @RequestParam(name = "account" , required = true) String account ,
            @NotNull
            @RequestParam(name = "password" , required = true) String password
    )throws Exception {


            RequestModel<User> requestModel=loginService.login(account , password);

            session.setAttribute(BaseContants.LOGIN_USER, requestModel.getData());

            return Result.getSure(requestModel);
        }
}
