package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserDtoConvert {
    SysUserDtoConvert INSTANCE = Mappers.getMapper(SysUserDtoConvert.class);
    SysUserDto convertReqToDto(SysUserReq sysUserReq);
}
