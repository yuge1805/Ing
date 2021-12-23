package com.yuge.ing.business.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuge
 * @date: 2021-12-21
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "db")
public class TemplateConfig {

    private String url;

}
