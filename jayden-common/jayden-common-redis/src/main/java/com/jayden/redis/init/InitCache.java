package com.jayden.redis.init;

import com.jayden.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnProperty(name = "init.cache.enable", havingValue = "true")
public class InitCache implements CommandLineRunner {

    /**
     * 项目启动时，会运行该方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // 获取所有需要预热的缓存
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();

        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);

        // 调用init方法
        if(!beanMap.isEmpty()){
            // 获取所有AbstractCache的子类，调用init方法
            beanMap.values().forEach(AbstractCache::initCache);
        }
        System.out.println("缓存预热完成");
    }
}
