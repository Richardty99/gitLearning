package com.example.demo.controller;

import com.example.demo.base.common.Result;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.em.ErrorMsgEnum;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 16:08
 * @Description:
 */
@Api(value = "用户操作接口")
@RestController
@RequestMapping(path = "/user/")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    public ResponseEntity<RequestModel<User>> selectPageUser(RequestModel requestModel)throws Exception{
        try{
            userService.selectUser(requestModel);
            return Result.getPage(requestModel);

        }catch (Exception ex){

                return Result.getPageError(ErrorMsgEnum.ERROR_PAGE.getCode(), ErrorMsgEnum.ERROR_PAGE.getMsg());


        }
    }

}
