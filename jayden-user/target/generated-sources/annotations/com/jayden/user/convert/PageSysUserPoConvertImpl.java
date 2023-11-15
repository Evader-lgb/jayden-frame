package com.jayden.user.convert;

import com.jayden.user.entity.dto.PageSysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T23:36:03+0800",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PageSysUserPoConvertImpl implements PageSysUserPoConvert {

    @Override
    public SysUserPo convertDtoToPo(PageSysUserDto pageSysUserDto) {
        if ( pageSysUserDto == null ) {
            return null;
        }

        SysUserPo sysUserPo = new SysUserPo();

        sysUserPo.setName( pageSysUserDto.getName() );
        sysUserPo.setAge( pageSysUserDto.getAge() );

        return sysUserPo;
    }
}
