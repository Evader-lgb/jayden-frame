package com.jayden.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jayden.entity.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:56:09
 */
@TableName("sys_user")
@Data
public class SysUserPo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 765417742561980404L;

    private String name;
    
    private Integer age;
}

