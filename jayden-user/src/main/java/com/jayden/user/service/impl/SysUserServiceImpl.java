package com.jayden.user.service.impl;

import com.jayden.page.PageResponse;
import com.jayden.user.convert.PageSysUserPoConvert;
import com.jayden.user.convert.SysUserPoConvert;
import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import com.jayden.user.mapper.SysUserMapper;
import com.jayden.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-11-14 23:56:12
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserPo queryById(Long id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 分页查询
     * @return 查询结果
     */
    @Override
    public PageResponse<SysUserPo> queryByPage(PageSysUserDto pageSysUserDto) {
        SysUserPo sysUserPo = PageSysUserPoConvert.INSTANCE.convertDtoToPo(pageSysUserDto);
        PageResponse<SysUserPo> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(pageSysUserDto.getPageNo());
        pageResponse.setPageSize(pageSysUserDto.getPageSize());
        Long pageStart = pageResponse.getPageStart();
        long total = this.sysUserDao.count(sysUserPo);
        List<SysUserPo> sysUserList = this.sysUserDao.queryAllByLimit(sysUserPo,pageStart,pageSysUserDto.getPageSize());
        pageResponse.setTotal(total);
        pageResponse.setRecords(sysUserList);

        return pageResponse;
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public SysUserPo insert(SysUserDto sysUserDto) {
        SysUserPo sysUserPo = SysUserPoConvert.INSTANCE.convertDtoToPo(sysUserDto);
//        SysUserPo sysUserPo = new SysUserPo();
//        BeanUtils.copyProperties(sysUserDto,sysUserPo);
        this.sysUserDao.insert(sysUserPo);
        return sysUserPo;
    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public SysUserPo update(SysUserDto sysUserDto) {
        SysUserPo sysUserPo = SysUserPoConvert.INSTANCE.convertDtoToPo(sysUserDto);
        this.sysUserDao.update(sysUserPo);
        return this.queryById(sysUserPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserDao.deleteById(id) > 0;
    }
}
