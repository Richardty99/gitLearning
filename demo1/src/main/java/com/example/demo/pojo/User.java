package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@ApiModel(value = "用户实体类")
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)//当前台传来的数据比requestBody的对象字段夺得时候过滤忽略
public class User {

    @ApiModelProperty(value = "用户自增Id")
    private Integer userId;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "用户密码")
    private String userPassword;
    @ApiModelProperty(value = "性别，0保密，1男，2女")
    private Integer sex;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "登陆ip地址")
    private Integer ip;
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;
    @ApiModelProperty(value = "经度")
    private BigDecimal lng;
    @ApiModelProperty(value = "创建人名称")
    private String createUserName;
    @ApiModelProperty(value = "创建人Id")
    private Integer createUserId;
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(value = "更新人名称")
    private String updateUserName;
    @ApiModelProperty(value = "更新人Id")
    private Integer updateUserId;
    @ApiModelProperty(value = "更新时间")
    private Timestamp updateTime;
    @ApiModelProperty(value = "用户电话")
    private String phone;
    @ApiModelProperty(value = "账号状态 0冻结，1启用")
    private int state;
    @ApiModelProperty(value = "头像地址")
    private Integer headImgUrl;
    @ApiModelProperty(value = "是否删除 0未删，1删除")
    private int isDeleted;
    @ApiModelProperty(value = "乐观锁")
    private Integer version;
    @ApiModelProperty(value = "备注")
    private String remarks;


}