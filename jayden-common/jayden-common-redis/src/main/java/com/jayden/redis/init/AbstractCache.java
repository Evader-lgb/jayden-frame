package com.jayden.redis.init;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCache {

    public abstract void initCache();

    public abstract<T> T getCache(String key);

    public abstract void clearCache();

    public void reloadCache() {
        clearCache();
        initCache();
    }
}
