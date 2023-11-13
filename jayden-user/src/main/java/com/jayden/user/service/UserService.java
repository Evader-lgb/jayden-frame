package com.jayden.user.service;

import com.jayden.user.entity.dto.UserDto;

public interface UserService {
    int addUser(UserDto userDto);

    int deleteUser(Integer id);
}
