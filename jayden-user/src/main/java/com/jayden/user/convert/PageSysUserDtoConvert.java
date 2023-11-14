package com.jayden.user.convert;

import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.req.PageSysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageSysUserDtoConvert {
    PageSysUserDtoConvert INSTANCE = Mappers.getMapper(PageSysUserDtoConvert.class);
    PageSysUserDto convertReqToDto(PageSysUserReq sysUserDto);
}
