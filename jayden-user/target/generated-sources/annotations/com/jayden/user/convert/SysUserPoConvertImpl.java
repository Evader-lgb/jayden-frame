package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.po.SysUserPo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T07:29:21+0800",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class SysUserPoConvertImpl implements SysUserPoConvert {

    @Override
    public SysUserPo convertDtoToPo(SysUserDto sysUserDto) {
        if ( sysUserDto == null ) {
            return null;
        }

        SysUserPo sysUserPo = new SysUserPo();

        sysUserPo.setId( sysUserDto.getId() );
        sysUserPo.setCreateBy( sysUserDto.getCreateBy() );
        sysUserPo.setCreateTime( sysUserDto.getCreateTime() );
        sysUserPo.setUpdateBy( sysUserDto.getUpdateBy() );
        sysUserPo.setUpdateTime( sysUserDto.getUpdateTime() );
        sysUserPo.setDeleteFlag( sysUserDto.getDeleteFlag() );
        sysUserPo.setVersion( sysUserDto.getVersion() );
        sysUserPo.setName( sysUserDto.getName() );
        sysUserPo.setAge( sysUserDto.getAge() );

        return sysUserPo;
    }
}
