package com.yuge.ing.user.server.config.nacos;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangbw
 * @date: 2020-12-30
 **/
@Configuration
public class ListenConfig {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    /**
     * 未生效？？
     *
     * @return
     */
    @Bean
    public ApplicationRunner runner() {
        System.out.println("xxx ListenConfig");
        return args -> {
            String dataId = "ing-user.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("xxx [Listener] " + configInfo);
                }
            });
        };
    }

}
