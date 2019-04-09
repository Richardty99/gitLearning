package com.example.demo.base.common;

import com.example.demo.base.pojo.RequestModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public static<T> ResponseEntity<RequestModel<T>> getPage(RequestModel requestModel)throws Exception{
       if (requestModel.getData()==null){
           return null;
       }else {
           requestModel.setResultCode(200);
           requestModel.setMessage("分页查询成功");
           return new ResponseEntity<RequestModel<T>>(requestModel,HttpStatus.OK);

       }



    }
    /**
     *
     * 功能描述: 
     *
     * @param: 用于分页查询失败
     * @return: 
     * @auther: HX001
     * @date: 2019/4/9 17:01
     */

    public static<T> ResponseEntity<RequestModel<T>> getPageError(int code,String msg)throws Exception{
        RequestModel<T> requestModel=new RequestModel<T>();
        requestModel.setMessage(msg);
        requestModel.setResultCode(code);

        return new ResponseEntity<RequestModel<T>>(requestModel,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
