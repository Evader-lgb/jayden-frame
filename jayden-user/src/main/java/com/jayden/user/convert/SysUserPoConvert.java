package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserPoConvert {
    SysUserPoConvert INSTANCE = Mappers.getMapper(SysUserPoConvert.class);
    SysUserPo convertDtoToPo(SysUserDto sysUserDto);
}
