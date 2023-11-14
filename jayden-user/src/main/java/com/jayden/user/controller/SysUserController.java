package com.jayden.user.controller;

import com.jayden.bean.Result;
import com.jayden.page.PageResponse;
import com.jayden.user.convert.PageSysUserDtoConvert;
import com.jayden.user.convert.SysUserDtoConvert;
import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import com.jayden.user.entity.req.PageSysUserReq;
import com.jayden.user.entity.req.SysUserReq;
import com.jayden.user.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2023-11-14 23:56:05
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @GetMapping("list")
    public Result<PageResponse<SysUserPo>> queryByPage(@RequestBody PageSysUserReq pageSysUserReq) {
        PageSysUserDto pageSysUserDto = PageSysUserDtoConvert.INSTANCE.convertReqToDto(pageSysUserReq);
        return Result.success(sysUserService.queryByPage(pageSysUserDto));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<SysUserPo> queryById(@PathVariable("id") Long id) {
        return Result.success(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserReq 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public Result<SysUserPo> add(@RequestBody SysUserReq sysUserReq) {
//        SysUserDto sysUserDto = SysUserDtoConvert.INSTANCE.convertReqToDto(sysUserReq);
        SysUserDto sysUserDto = new SysUserDto();
        BeanUtils.copyProperties(sysUserReq,sysUserDto);
        return Result.success(this.sysUserService.insert(sysUserDto));
    }

    /**
     * 编辑数据
     *
     * @return 编辑结果
     */
    @PutMapping("edit")
    public Result<SysUserPo> edit(@RequestBody SysUserReq sysUserReq) {
        SysUserDto sysUserDto = SysUserDtoConvert.INSTANCE.convertReqToDto(sysUserReq);
        return Result.success(this.sysUserService.update(sysUserDto));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteById(@PathVariable Long id) {
        return Result.success(this.sysUserService.deleteById(id));
    }

}

