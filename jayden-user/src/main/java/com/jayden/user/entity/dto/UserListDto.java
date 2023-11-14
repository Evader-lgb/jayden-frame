package com.jayden.user.entity.dto;

import lombok.Data;

@Data
public class UserListDto {
    private String name;

    private Integer age;

    private Integer pageNo;

    private Integer pageSize;
}
