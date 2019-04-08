package com.example.demo.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private Integer userId;

    private String userName;

    private String account;

    private String userPassword;

    private Integer sex;

    private Integer age;

    private Date birthday;

    private String email;

    private Integer ip;

    private BigDecimal lat;

    private BigDecimal lng;

    private String createUserName;

    private Integer createUserId;

    private Timestamp createTime;

    private String updateUserName;

    private Integer updateUserId;

    private Timestamp updateTime;

    private String phone;

    private int state;

    private Integer headImgUrl;

    private int isDeleted;

    private Integer version;

    private String remarks;


}