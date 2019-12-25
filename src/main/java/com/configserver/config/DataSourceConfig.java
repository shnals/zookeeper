package com.configserver.config;

import com.configserver.pojo.CustomDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * FileName: DataSourceConfig
 * Author:   程序猿不是猴
 * Date:     2019/12/5 14:14
 * Description: 数据源配置类
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        final CustomDataSource dataSource = new CustomDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://192.168.109.204:3306/test?useUnicode=true&characterEncoding=utf8");
        return dataSource;
    }
}