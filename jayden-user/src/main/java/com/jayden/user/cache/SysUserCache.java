package com.jayden.user.cache;

import com.jayden.redis.init.AbstractCache;
import com.jayden.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserCache extends AbstractCache {

    private static final String SYS_USER_CACHE_KEY = "SYS_USER";

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void initCache() {
        // 和数据库做联动，或者和其他数据来源做联动
        redisUtil.set(SYS_USER_CACHE_KEY,"Jayden_sys_user");
    }

    @Override
    public <T> T getCache(String key) {
        if(!redisUtil.hasKey(SYS_USER_CACHE_KEY)){
            reloadCache();
        }
        return (T) redisUtil.get(SYS_USER_CACHE_KEY);
    }

    @Override
    public void clearCache() {
        redisUtil.del(SYS_USER_CACHE_KEY);
    }
}
