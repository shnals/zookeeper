package com.configserver.pojo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * FileName: RuntimeContext
 * Author:   程序猿不是猴
 * Date:     2019/12/5 14:16
 * Description: 运行时上下文，持有ApplicationContext的引用
 */
@Component
public class RuntimeContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}