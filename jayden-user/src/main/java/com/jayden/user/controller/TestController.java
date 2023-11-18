package com.jayden.user.controller;

import com.jayden.redis.util.RedisShareLockUtil;
import com.jayden.redis.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试")
@RequestMapping("test")
@Slf4j
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisShareLockUtil redisShareLockUtil;

    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public String test() {
        return "test";
    }

    @GetMapping("/testRedis")
    public String testRedis() {
        redisTemplate.opsForValue().set("name", "Jayden");
        String name = (String) redisTemplate.opsForValue().get("name");

        return name;
    }

    @GetMapping("/testRedisUtil")
    public String testRedisUtil() {
        redisUtil.set("redis", "redisUtil");
        String name = (String) redisUtil.get("redis");

        return name;
    }

    @GetMapping("/testRedisShareLock")
    public String testRedisShareLock() {
        boolean result = redisShareLockUtil.lock("Jayden", "123456", 10000L);
        log.info("分布式锁获取：{}", result);
        return String.valueOf(result);
    }

}
