package com.yuge.ing.user.server.config.nacos;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author: zhangbw
 * @date: 2020-12-30
 **/
@Configuration
public class ListenConfig {

    @Value("${listen.name}")
    private String listenName;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct
    public void init() {
        System.out.printf("xxx [init] listen name : %s", listenName);
    }

    /**
     *
     * @return
     */
    @Bean
    public ApplicationRunner runner() {
        System.out.println("xxx ListenConfig");
        return args -> {
            String dataId = "ing-user";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("xxx [Listener] " + configInfo);
                    System.out.println("[Before Listener] " + listenName);

                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        listenName = properties.getProperty("listen.name");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After Listener] " + listenName);
                }
            });
        };
    }

}
