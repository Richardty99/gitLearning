package com.example.demo.base.exception;

import com.example.demo.base.em.ErrorMsgEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: HX001
 * @Date: 2019/4/12 13:36
 * @Description:
 */
@Getter
@Setter
@ApiModel("业务异常类")
public class BusinessException extends RuntimeException {

    @ApiModelProperty(value = "异常状态码")
    int code;
    @ApiModelProperty(value = "异常信息")
    String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(String msg) {
        this.msg = msg;
    }

    public BusinessException(ErrorMsgEnum em) {
        this.code = em.getCode();
        this.msg = em.getMsg();
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
