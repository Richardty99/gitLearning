package com.example.demo.base.exception;

import com.example.demo.base.pojo.RequestModel;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: HX001
 * @Date: 2019/4/12 17:16
 * @Description:
 */
public class BusinessExceptionResolver extends SimpleMappingExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        RequestModel requestModel=new RequestModel();

        return super.resolveException(request, response, handler, ex);
    }
}
