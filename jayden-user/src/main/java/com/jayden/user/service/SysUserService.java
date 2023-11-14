package com.jayden.user.service;

import com.jayden.page.PageResponse;
import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;

/**
 * 系统用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-11-14 23:56:12
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserPo queryById(Long id);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    PageResponse<SysUserPo> queryByPage(PageSysUserDto pageSysUserDto);

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    SysUserPo insert(SysUserDto sysUserDto);

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    SysUserPo update(SysUserDto sysUserDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
