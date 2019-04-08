package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HX001
 * @Date: 2019/4/4 16:09
 * @Description:
 */
@Controller
@RequestMapping(value = {"/test"})
public class TestController {
    @RequestMapping(method = RequestMethod.GET,produces = "application/json;charset=UTF-8",value = "/test")
    public String Test(){
        return "Hello World";
    }
    @RequestMapping(method = RequestMethod.GET,produces = "application/json;charset=UTF-8",value = "/login")
    public String Login(){
        return "Login";
    }
}
