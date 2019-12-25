package com.configserver.config;

import com.configserver.listener.DataSourceListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FileName: ListenerConfig
 * Author:   程序猿不是猴
 * Date:     2019/12/5 11:04
 * Description: 监听配置类
 */
@Configuration
@SuppressWarnings("all")
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();

        servletListenerRegistrationBean.setListener(new DataSourceListener());

        return servletListenerRegistrationBean;
    }

}