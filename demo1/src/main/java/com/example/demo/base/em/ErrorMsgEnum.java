package com.example.demo.base.em;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 15:23
 * @Description:
 */
@ApiModel("错误信息枚举类")
public enum  ErrorMsgEnum {
    /*枚举
     */
    SYSTEM_ERROR(500,"系统异常,请联系管理员"),
    NULL_ACCOUNT(1000,"账号不能为空"),
    NULL_PASSWROD(1001,"密码不能为空"),
    NO_ACCOUNT(1002,"账号不存在"),
    ERROR_PASS(1003,"密码错误"),
    NO_STATE(1004,"账号未激活，请联系管理员"),
    ERROR_PAGE(1005,"分页查询失败"),
    NO_PERMISSIONS(1006,"权限不足"),
    SQL_ERROR(1020,"SQL异常，请修改SQL语句"),
    ;

    @ApiModelProperty(value = "状态码")
    public  int code;
    @ApiModelProperty(value = "信息")
    public  String msg;

    ErrorMsgEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public void setMessage(ErrorMsgEnum em){
        this.code=em.getCode();
        this.msg=em.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
