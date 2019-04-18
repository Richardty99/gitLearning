package com.example.demo.base.controller;

import com.example.demo.base.common.Result;
import com.example.demo.base.contants.BaseContants;
import com.example.demo.base.em.ErrorMsgEnum;
import com.example.demo.base.exception.BusinessException;
import com.example.demo.base.pojo.RequestModel;
import com.example.demo.pojo.User;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLException;
import java.util.Set;


/**
 * @Auther: HX001
 * @Date: 2019/4/9 16:13
 * @Description:
 */
@RestController
@ControllerAdvice
public abstract class BaseController {
         private static final Logger log=Logger.getLogger(BaseController.class);
         protected HttpServletRequest request;
         protected HttpServletResponse response;
         public HttpSession session;


         @InitBinder
         public void initHttpParam(HttpServletRequest req,HttpServletResponse res){
             request=req;
             response=res;
             session=req.getSession();
         }


         /**
          * 功能描述:
          * @param: 参数检验异常，用于get请求
          * @return:
          * @auther: richard
          * @date: 2019/4/18 10:23
          */
         @ExceptionHandler(ValidationException.class)
         public ResponseEntity<RequestModel> validationExcepiton(ValidationException ve){
             RequestModel requestModel = new RequestModel();
             StringBuilder errorMsg = new StringBuilder();
            if (ve instanceof ConstraintViolationException){
                ConstraintViolationException cve =(ConstraintViolationException) ve;
                Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();

                //最后一个信息不拼接逗号
                int count = 1;
                for (ConstraintViolation<?> item : violations){
                    if (count == violations.size()){
                        errorMsg.append(item.getMessage());
                    }else {
                        errorMsg.append(item.getMessage()).append(",");
                    }
                    count ++;
                }
            }
             requestModel.setMessage(errorMsg.toString());
             return Result.RequestError(requestModel);
         }

         /**
          * 功能描述:
          * @param: 参数检验异常
          * @return:
          * @auther: richard
          * @date: 2019/4/18 10:41
          */
         @ExceptionHandler(MethodArgumentNotValidException.class)
         public ResponseEntity<RequestModel> methodArgumentNotValidException(MethodArgumentNotValidException me){
             RequestModel requestModel = new RequestModel();
             BindingResult bindingResult = me.getBindingResult();
             StringBuilder errorMsg = new StringBuilder();

             int count = 1;
             for (FieldError fieldError : bindingResult.getFieldErrors()){
                 if (count == bindingResult.getFieldErrors().size()){
                     errorMsg.append(fieldError.getDefaultMessage());
                 }else {
                     errorMsg.append(fieldError.getDefaultMessage()).append(",");
                 }
                 count ++;
             }
             requestModel.setMessage(errorMsg.toString());
             return Result.RequestError(requestModel);
         }

         /**
          *
          * 功能描述:
          * @param: 统一业务异常处理
          * @return:
          * @auther: HX001
          * @date: 2019/4/15 10:46
          */
         @ExceptionHandler(BusinessException.class)
         public ResponseEntity<RequestModel> businessException(BusinessException bex){
             RequestModel requestModel =new RequestModel();
             requestModel.setMessage(bex.getMsg());
             requestModel.setResultCode(bex.getCode());
             log.error(bex.getMessage(),bex);
             return Result.RequestError(requestModel);
         }
         
         /**
          *
          * 功能描述: 
          *
          * @param: 统一系统异常处理
          * @return: 
          * @auther: HX001
          * @date: 2019/4/15 13:55
          */
         @ExceptionHandler(Exception.class)
         public ResponseEntity<RequestModel> exception(Exception ex){
             RequestModel requestModel =new RequestModel();
             if ("org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator".equals(ex.getStackTrace()[0].getClassName())){
                 requestModel.setMessage(ErrorMsgEnum.SQL_ERROR.getMsg());
                 requestModel.setResultCode(ErrorMsgEnum.SQL_ERROR.getCode());
             }else {
                 requestModel.setMessage(ErrorMsgEnum.SYSTEM_ERROR.getMsg());
                 requestModel.setResultCode(ErrorMsgEnum.SYSTEM_ERROR.getCode());
             }
             log.error(requestModel.getMessage(),ex);
             return Result.RequestError(requestModel);
         }
         
         /**
          *
          * 功能描述: 
          *
          * @param: 统一sql异常处理
          * @return: 
          * @auther: HX001
          * @date: 2019/4/15 14:58
          */
         @ExceptionHandler(SQLException.class)
         public ResponseEntity<RequestModel> sqlException(SQLException se){
             RequestModel requestModel =new RequestModel();
             requestModel.setMessage(ErrorMsgEnum.SQL_ERROR.getMsg());
             requestModel.setResultCode(ErrorMsgEnum.SQL_ERROR.getCode());
             log.error(requestModel.getMessage(),se);
             return Result.RequestError(requestModel);
             
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
