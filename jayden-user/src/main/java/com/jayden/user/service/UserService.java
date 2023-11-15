package com.jayden.user.service;

import com.jayden.entity.PageResult;
import com.jayden.user.entity.dto.UserDto;
import com.jayden.user.entity.dto.UserListDto;
import com.jayden.user.entity.po.UserPo;

public interface UserService {
    int addUser(UserDto userDto);

    int deleteUser(Integer id);

    PageResult<UserPo> getUserList(UserListDto userListDto);
}
