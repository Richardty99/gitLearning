package com.example.demo.base.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 08:59
 * @Description:
 */
@ApiModel(value = "分页参数实体类")
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryParams implements Serializable {

    @ApiModelProperty(value = "当前页码")
    Integer curr_page=1;
    @ApiModelProperty(value = "每页显示记录数")
    Integer page_size=5;
    @ApiModelProperty(value = "条件")
    private String where;
    @ApiModelProperty(value = "排序")
    private String order;
}
