package com.jayden.user.convert;

import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageSysUserPoConvert {
    PageSysUserPoConvert INSTANCE = Mappers.getMapper(PageSysUserPoConvert.class);
    SysUserPo convertDtoToPo(PageSysUserDto pageSysUserDto);
}
