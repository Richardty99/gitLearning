package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HX001
 * @Date: 2019/4/4 16:09
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET,produces = "application/json;charset=UTF-8",value = "/test")
    public String Test(){
        return "Hello World";
    }
}
