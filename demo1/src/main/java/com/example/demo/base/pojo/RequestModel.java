package com.example.demo.base.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 08:44
 * @Description:
 */
@ApiModel(value = "请求体实体类")
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestModel<T> implements Serializable {

    @ApiModelProperty(value = "返回请求状态码")
    private Integer resultCode;
    @ApiModelProperty(value = "定义信息")
    private String  message;
    @ApiModelProperty(value = "数据集")
    private Object  data;
    @ApiModelProperty(value = "分页")
    private QueryParams queryParams=new QueryParams();
    @ApiModelProperty(value = "泛型集合")
    private List<T> list;

}
