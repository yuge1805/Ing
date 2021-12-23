package com.yuge.ing.business.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author: yuge
 * @date: 2021-12-21
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "third")
public class TemplateExtConfig {

    private String serverUrl;

    private String url;

    @Resource
    private TemplateExtSubConfig subConfig;

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "third.sub")
    public class TemplateExtSubConfig {

        private String url;

    }

}
