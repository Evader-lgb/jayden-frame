package com.jayden.user.convert;

import com.jayden.user.entity.dto.SysUserDto;
import com.jayden.user.entity.req.SysUserReq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T23:36:03+0800",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class SysUserDtoConvertImpl implements SysUserDtoConvert {

    @Override
    public SysUserDto convertReqToDto(SysUserReq sysUserReq) {
        if ( sysUserReq == null ) {
            return null;
        }

        SysUserDto sysUserDto = new SysUserDto();

        sysUserDto.setId( sysUserReq.getId() );
        sysUserDto.setName( sysUserReq.getName() );
        sysUserDto.setAge( sysUserReq.getAge() );
        sysUserDto.setCreateBy( sysUserReq.getCreateBy() );
        sysUserDto.setCreateTime( sysUserReq.getCreateTime() );
        sysUserDto.setUpdateBy( sysUserReq.getUpdateBy() );
        sysUserDto.setUpdateTime( sysUserReq.getUpdateTime() );
        sysUserDto.setDeleteFlag( sysUserReq.getDeleteFlag() );
        sysUserDto.setVersion( sysUserReq.getVersion() );

        return sysUserDto;
    }
}
