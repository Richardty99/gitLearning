package com.example.demo.base.common;

import com.example.demo.base.pojo.RequestModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 11:10
 * @Description:
 */
public class Result<T> {

    @Autowired


    /**
     *
     * 功能描述:用于分页请求成功  GET
     *
     * @param:
     * @return:
     * @auther: HX001
     * @date: 2019/4/9 11:11
     */
    public static<T> ResponseEntity<RequestModel> getPage(RequestModel requestModel){
           requestModel.setResultCode(200);
           requestModel.setMessage("分页查询成功");
           return new ResponseEntity<RequestModel>(requestModel,HttpStatus.OK);

    }
    /**
     *
     * 功能描述: 
     *
     * @param: 请求失败异常
     * @return: 
     * @auther: HX001
     * @date: 2019/4/9 17:01
     */

    public static<T> ResponseEntity<RequestModel> RequestError(RequestModel requestModel){


        return new ResponseEntity<RequestModel>(requestModel,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    /**
     *
     * 功能描述:
     *
     * @param: get请求成功
     * @return:
     * @auther: HX001
     * @date: 2019/4/10 15:15
     */
      public static<T> ResponseEntity<RequestModel> getSure(RequestModel<T> requestModel){
          requestModel.setResultCode(200);
          requestModel.setMessage("成功");
          return  new ResponseEntity<RequestModel>(requestModel,HttpStatus.OK);

      }


}
