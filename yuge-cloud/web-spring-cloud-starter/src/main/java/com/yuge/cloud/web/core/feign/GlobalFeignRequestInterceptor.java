package com.yuge.cloud.web.core.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: yuge
 * @date: 2021-05-24
 **/
@Slf4j
public class GlobalFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("global interceptor");
        template.header("global", "global");
    }

}
