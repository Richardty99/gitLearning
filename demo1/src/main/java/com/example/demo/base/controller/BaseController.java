package com.example.demo.base.controller;

import com.example.demo.base.contants.BaseContants;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Auther: HX001
 * @Date: 2019/4/9 16:13
 * @Description:
 */
@RestController
public abstract class BaseController {
         protected HttpServletRequest request;
         protected HttpServletResponse response;
         protected HttpSession session;


         @InitBinder
         public void initHttpParam(HttpServletRequest req,HttpServletResponse res){
             request=req;
             response=res;
             session=req.getSession();
         }



         /**
          *
          * 功能描述:获取session中的信息
          *
          * @param:
          * @return:
          * @auther: HX001
          * @date: 2019/4/9 16:27
          */
         protected User getSessionUser()throws Exception{
             User user=(User)session.getAttribute(BaseContants.LOGIN_USER);

             if (user==null){
                 throw new Exception("未登陆");
             }
             return user;
         }

}
