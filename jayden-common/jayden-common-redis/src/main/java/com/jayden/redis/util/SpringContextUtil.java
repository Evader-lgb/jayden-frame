package com.jayden.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationCtext;

    public static ApplicationContext getApplicationContext() {
        return applicationCtext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationCtext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationCtext.getBean(clazz);
    }
}
