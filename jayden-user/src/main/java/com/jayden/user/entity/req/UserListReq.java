package com.jayden.user.entity.req;

import lombok.Data;

@Data
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
