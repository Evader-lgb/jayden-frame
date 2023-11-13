package com.jayden.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.jayden.entity.BaseEntity;
import lombok.Data;

@TableName("user")
@Data
public class UserPo extends BaseEntity {

    private String name;

    private Integer age;
}
