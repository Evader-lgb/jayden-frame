package com.jayden.user.entity.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "用户列表请求对象")
public class UserListReq {
    private String name;

    private Integer age;

    /**
     * 分页页数
     */
    private Integer pageNo;

    /**
     * 每页数量
     */
    private Integer pageSize;
}
