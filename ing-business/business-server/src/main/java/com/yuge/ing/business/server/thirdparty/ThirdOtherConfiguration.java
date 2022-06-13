package com.yuge.ing.business.server.thirdparty;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;

/**
 * @author: yuge
 * @date: 2021-05-24
 **/
@Slf4j
//@Configuration
public class ThirdOtherConfiguration {

    @Bean
    public ThirdOtherRequestInterceptor thirdOtherRequestInterceptor() {
        return new ThirdOtherRequestInterceptor();
    }

    public class ThirdOtherRequestInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            log.info("thirdOther");
            template.header("thirdOther", "thirdOther");
        }

    }

//    @Bean
//    public Feign.Builder otherFeignBuilder() {
//        return Feign.builder()
//                .retryer(Retryer.NEVER_RETRY)
//                .requestInterceptors(Arrays.asList(thirdOtherRequestInterceptor()));
//    }

}
