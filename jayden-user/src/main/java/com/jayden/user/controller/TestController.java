package com.jayden.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试")
public class TestController {

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public String test() {
        return "test";
    }
}
