package com.yuge.ing.business.server.thirdparty;

import com.yuge.ing.user.api.UserRecordClient;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Base64;

import static java.util.concurrent.TimeUnit.SECONDS;

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

    /**
     * 针对该FeignClient下所有接口生效；
     *
     * @return
     */
    @Bean
    public Retryer retryer() {
        // period 重试间隔；每次重试间隔递增 1.5 * period
        // maxPeriod 最大重试间隔；
        // maxAttempts 重试次数；
        return new Retryer.Default(SECONDS.toMillis(10), SECONDS.toMillis(20), 3);
    }

//    @Bean
//    public Feign.Builder userFeignBuilder() {
//        return Feign.builder()
//                .retryer(Retryer.NEVER_RETRY)
//                .requestInterceptors(Arrays.asList(thirdUserRequestInterceptor()));
//    }

    /**
     * FeignClientConfigurer#inheritParentConfiguration为false时，
     * 仅从当前配置类中获取配置，不会再从yml文件中读取配置；
     *
     * 配置优先级见 FeginClientFactoryBean#configureFegin
     * @return
     */
//    放开该注解生效
//    @Bean
    public FeignClientConfigurer feignClientConfigurer() {
        return new ThirdUserFeignClientConfigurer();
    }

    public static class ThirdUserFeignClientConfigurer implements FeignClientConfigurer {

        @Override
        public boolean primary() {
            return true;
        }

        @Override
        public boolean inheritParentConfiguration() {
            return false;
        }
    }

}
