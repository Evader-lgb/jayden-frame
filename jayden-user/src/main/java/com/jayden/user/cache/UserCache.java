package com.jayden.user.cache;

import com.jayden.redis.init.AbstractCache;
import com.jayden.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCache extends AbstractCache {

    private static final String USER_CACHE_KEY = "USER";

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void initCache() {
        // 和数据库做联动，或者和其他数据来源做联动
        redisUtil.set(USER_CACHE_KEY,"Jayden_user");
    }

    @Override
    public <T> T getCache(String key) {
        if(!redisUtil.hasKey(USER_CACHE_KEY)){
            reloadCache();
        }
        return (T) redisUtil.get(USER_CACHE_KEY);
    }

    @Override
    public void clearCache() {
        redisUtil.del(USER_CACHE_KEY);
    }
}
