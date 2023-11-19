package com.jayden.user.convert;

import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.req.PageSysUserReq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T10:51:33+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PageSysUserDtoConvertImpl implements PageSysUserDtoConvert {

    @Override
    public PageSysUserDto convertReqToDto(PageSysUserReq sysUserDto) {
        if ( sysUserDto == null ) {
            return null;
        }

        PageSysUserDto pageSysUserDto = new PageSysUserDto();

        pageSysUserDto.setPageNo( sysUserDto.getPageNo() );
        pageSysUserDto.setPageSize( sysUserDto.getPageSize() );

        return pageSysUserDto;
    }
}
