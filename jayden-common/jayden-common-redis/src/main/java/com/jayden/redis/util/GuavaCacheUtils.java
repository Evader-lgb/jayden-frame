package com.jayden.redis.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 查询时添加缓存，没有实现编辑时删除缓存的操作，可自行实现
 */
@Component
@Slf4j
public class GuavaCacheUtils<K,V> {

    // 意图从nacos中的配置文件获取，流量大的时候开启本地缓存，流量小的时候关闭本地缓存
    @Value("${guava.cache.enable}")
    public Boolean switchCache;

    // 初始化一个guava的Cache
    private Cache<String,String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .expireAfterWrite(3, TimeUnit.SECONDS).build();

    public Map<K,V> getResult(List<K> skuIdList, String cachePrefix, Class<V> clazz, Function<List<K>,Map<K,V>> function){
        if(CollectionUtils.isEmpty(skuIdList)){
            return Collections.emptyMap();
        }

        Map<K,V> resultMap = new HashMap<>();

        // 1 本地缓存未开
        if(!switchCache){
            resultMap = function.apply(skuIdList);
            return resultMap;
        }

        // 2 本地缓存开启
        List<K> noCacheList = new ArrayList<>();
        // 2.1 查guava缓存
        for (K skuId:skuIdList){
            String key = cachePrefix + skuId;
            String value = localCache.getIfPresent(key);
            if(StringUtils.isNotBlank(value)){
                // 能查到直接放到结果集中
                resultMap.put(skuId, JSON.parseObject(value,clazz));
            }else{
                // 查不到的先放进noCacheList中，后面统一使用rpc查询
                noCacheList.add(skuId);
            }
        }

        // 2.2 如果没有查不到的，直接返回结果集
        if(CollectionUtils.isEmpty(noCacheList)){
            return resultMap;
        }

        // 2.3 如果有查不到的，从rpc接口查guava中没有缓存的数据
        Map<K,V> noCacheMap = function.apply(noCacheList);

        // 2.4 如果rpc接口也没有查到任何数据，直接返回结果集
        if(CollectionUtils.isEmpty(noCacheMap)){
            return resultMap;
        }

        // 2.5 将从rpc中查出的结果，添加guava的本地缓存和结果集中
        for(Map.Entry<K,V> entry:noCacheMap.entrySet()){
            K skuId = entry.getKey();
            V content = entry.getValue();
            // 查询内容放进结果集
            resultMap.put(skuId, content);
            // 查询内容放进guava本地缓存
            String cacheKey = cachePrefix + "_" + skuId;
            localCache.put(cacheKey, JSON.toJSONString(content));
        }

        // 2.6 返回结果集
        return resultMap;
    }
}
