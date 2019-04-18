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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 16:08
 * @Description:
 */
@Api(value = "用户操作接口")
@Slf4j
@Validated
@RestController
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
    @ApiOperation(value = "分页查询所有用户",httpMethod = "GET",response = RequestModel.class)
    @ApiResponses({
            @ApiResponse(code =200,message = "操作成功",response = RequestModel.class),
    })
    @RequestMapping(path = "user/select/page/",method = RequestMethod.GET)
    public ResponseEntity<RequestModel> selectPageUser(RequestModel requestModel)throws Exception{

            userService.selectUser(requestModel);

            return Result.getPage(requestModel);


    }

}
