package com.yuge.ing.user.server.config.nacos;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: yuge
 * @date: 2020-12-29
 **/
@Configuration
@RefreshScope
@EnableConfigurationProperties(TeaConfig.class)
@Data
public class NacosConfig {

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private Integer userAge;

    @Autowired
    private TeaConfig teaConfig;

    @PostConstruct
    public void init() {
        System.out.printf("xxx [init] user name : %s , age : %d， tea : %s %n", userName, userAge, teaConfig);
    }

    @PreDestroy
    public void destroy() {
        System.out.printf("xxx [destroy] user name : %s , age : %d ，tea : %s %n", userName, userAge);
    }
}
