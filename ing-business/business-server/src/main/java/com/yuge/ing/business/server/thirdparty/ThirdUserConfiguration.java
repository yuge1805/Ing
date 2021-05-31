package com.yuge.ing.business.server.thirdparty;

import com.yuge.ing.user.api.UserRecordClient;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Base64;

/**
 * 每个feignClient定义各自的Configuration;
 * 该类不需要被Spring扫描到；即不需要添加@Configuration、@@Component等注解；
 *
 * @author: yuge
 * @date: 2021-05-24
 **/
@Slf4j
//@Configuration
public class ThirdUserConfiguration {

    @Bean
    public ThirdUserRequestInterceptor thirdUserRequestInterceptor() {
        return new ThirdUserRequestInterceptor();
    }

    public class ThirdUserRequestInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            log.info("thirdUser");
            template.header("thirdUser", "thirdUser");
        }

    }

//    @Bean
//    public Feign.Builder userFeignBuilder() {
//        return Feign.builder()
//                .retryer(Retryer.NEVER_RETRY)
//                .requestInterceptors(Arrays.asList(thirdUserRequestInterceptor()));
//    }

}
