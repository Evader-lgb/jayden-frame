package com.jayden.user.controller;

import com.jayden.redis.util.GuavaCacheUtils;
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

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Autowired
    GuavaCacheUtils guavaCacheUtils;

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

    /**
     * 伪代码，调用不通
     */
    @GetMapping("/testLocalCache")
    public void testLocalCache(List<Long> skuIdList) {
        guavaCacheUtils.getResult(skuIdList, "skuInfo.skuName", SkuInfo.class, (list) -> {
            Map<Long, SkuInfo> skuInfo = getSkuInfo(skuIdList);
            return skuInfo;
        });
        guavaCacheUtils.getResult(skuIdList, "skuInfo.skuPrice", SkuPrice.class, (list) -> {
            Map<Long, SkuPrice> skuPrice = getSkuPrice(skuIdList);
            return skuPrice;
        });
    }

    // 模拟RPC接口(可以使用OpenFeign来作为Service层的RPC调用)
    public Map<Long, SkuInfo> getSkuInfo(List<Long> skuIdList) {
        return Collections.emptyMap();
    }

    public Map<Long, SkuPrice> getSkuPrice(List<Long> skuIdList) {
        return Collections.emptyMap();
    }

    class SkuInfo {
        private Long id;
        private String name;
    }

    class SkuPrice {
        private Long id;
        private Double price;
    }

}
