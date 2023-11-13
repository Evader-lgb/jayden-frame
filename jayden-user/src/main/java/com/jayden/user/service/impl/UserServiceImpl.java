package com.jayden.user.service.impl;

import com.jayden.user.entity.dto.UserDto;
import com.jayden.user.entity.po.UserPo;
import com.jayden.user.mapper.UserMapper;
import com.jayden.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        int count = userMapper.insert(userPo);
        return count;
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }
}
