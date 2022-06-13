package com.yuge.cloud.web;

import com.yuge.cloud.web.core.advice.GlobalExceptionHandler;
import com.yuge.cloud.web.core.feign.GlobalFeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: yuge
 * @date: 2021-03-11
 **/
@Configuration
@PropertySource(value = {"classpath:web.properties"})
@Import({GlobalExceptionHandler.class})
public class WebConfiguration {

    @Bean
    public feign.RequestInterceptor requestInterceptor() {
        return new GlobalFeignRequestInterceptor();
    }

}
