package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-19T22:49:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class SysUserPoConvertImpl implements SysUserPoConvert {

    @Override
    public SysUserPo convertDtoToPo(SysUserDto sysUserDto) {
        if ( sysUserDto == null ) {
            return null;
        }

        SysUserPo sysUserPo = new SysUserPo();

        return sysUserPo;
    }
}
