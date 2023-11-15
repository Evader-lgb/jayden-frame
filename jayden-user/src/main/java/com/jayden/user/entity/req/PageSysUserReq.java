package com.jayden.user.entity.req;

import com.jayden.page.PageRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "系统用户分页请求对象")
public class PageSysUserReq extends PageRequest implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer version;
}
