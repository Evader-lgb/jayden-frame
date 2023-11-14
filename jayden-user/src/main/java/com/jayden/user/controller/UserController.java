package com.jayden.user.controller;

import com.jayden.bean.Result;
import com.jayden.entity.PageResult;
import com.jayden.user.entity.dto.UserDto;
import com.jayden.user.entity.dto.UserListDto;
import com.jayden.user.entity.po.UserPo;
import com.jayden.user.entity.req.UserListReq;
import com.jayden.user.entity.req.UserReq;
import com.jayden.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Result<Integer> addUser(@RequestBody UserReq userReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        return Result.success(userService.addUser(userDto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result<Integer> deleteUser(@PathVariable Integer id) {
        return Result.success(userService.deleteUser(id));
    }

    @GetMapping("/list")
    public Result<PageResult<UserPo>> list(@RequestBody UserListReq userListReq) {
        UserListDto userListDto = new UserListDto();
        BeanUtils.copyProperties(userListReq, userListDto);
        return Result.success(userService.getUserList(userListDto));
    }
}
