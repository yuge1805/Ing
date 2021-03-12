package com.yuge.cloud.mybatis;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: yuge
 * @date: 2021-03-12
 **/
@Configuration
@PropertySource(value = {"classpath:mybatis.properties"})
public class MyBatisConfiguration {
}
