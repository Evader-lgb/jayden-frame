package com.jayden.user.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 这里为什么要加公共属性
 */
@Data
@ApiModel(value = "系统用户请求对象")
public class SysUserReq implements Serializable {
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer version;
}
