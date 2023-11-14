package com.jayden.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jayden.entity.PageResult;
import com.jayden.user.entity.dto.UserDto;
import com.jayden.user.entity.dto.UserListDto;
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

    @Override
    public PageResult<UserPo> getUserList(UserListDto userListDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userListDto, userPo);
        // 创建一个Page对象，传入当前偏移量和页面大小
        IPage<UserPo> userPoPage = new Page(userListDto.getPageNo(), userListDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPo,userPoPage);

        PageResult<UserPo> userPoPageResult = new PageResult<>();
        userPoPageResult.loadData(userPage);
        return userPoPageResult;
    }
}
