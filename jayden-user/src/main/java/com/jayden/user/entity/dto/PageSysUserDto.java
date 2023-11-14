package com.jayden.user.entity.dto;

import com.jayden.page.PageRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageSysUserDto extends PageRequest implements Serializable {

    private String name;

    private Integer age;

}
