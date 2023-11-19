package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.req.SysUserReq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T22:49:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class SysUserDtoConvertImpl implements SysUserDtoConvert {

    @Override
    public SysUserDto convertReqToDto(SysUserReq sysUserReq) {
        if ( sysUserReq == null ) {
            return null;
        }

        SysUserDto sysUserDto = new SysUserDto();

        return sysUserDto;
    }
}
