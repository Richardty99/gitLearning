package com.example.demo.controller;

import com.example.demo.base.common.Result;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.em.ErrorMsgEnum;
import com.example.demo.base.exception.BusinessException;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 16:08
 * @Description:
 */
@Api(value = "用户操作接口",tags = "用户操作接口")
@Slf4j
@Validated
@Controller
@RequestMapping(path = "/richard/1.0/")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;



    /**
     * 功能描述: 
     * @param: 分页查询
     * @return: 
     * @auther: richard
     * @date: 2019/4/18 13:56
     */
    @ApiOperation(value = "分页查询所有用户",httpMethod = "POST",response = RequestModel.class)
    @ApiResponses({
            @ApiResponse(code =200,message = "操作成功",response = RequestModel.class),
    })
    @RequestMapping(path = "user/select/page/",method = RequestMethod.POST)
    public ResponseEntity<RequestModel> selectPageUser(
            @RequestBody RequestModel requestModel
    )throws Exception{

            userService.selectUser(requestModel);

            return Result.getPage(requestModel);


    }
    /**
     * 功能描述: 
     * @param: 
     * @return: 
     * @auther: richard
     * @date: 2019/4/19 15:44
     */
    @ApiOperation(value = "查询用户",httpMethod = "GET",response = RequestModel.class)
    @ApiResponses({
            @ApiResponse(code =200,message = "操作成功",response = RequestModel.class),
    })
    @RequestMapping(path = "user/select/account/",method = RequestMethod.GET)
    public ResponseEntity<RequestModel> selectUserByAccount(
            @RequestParam String account
    )throws Exception{
        RequestModel<User> requestModel=userService.selectUserByAccount(account);
        return Result.getSure(requestModel);
    }

}
