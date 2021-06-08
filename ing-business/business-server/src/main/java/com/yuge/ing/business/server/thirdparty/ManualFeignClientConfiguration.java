package com.yuge.ing.business.server.thirdparty;

import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yuge
 * @date: 2021-06-01
 **/
@Slf4j
@Configuration
@Import(FeignClientsConfiguration.class)
public class ManualFeignClientConfiguration {

    @Bean
    public ManualFeignClient manualFeignClient(Client client, Encoder encoder, Decoder decoder, Contract contract) {
        return Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .requestInterceptor(new ManualFeignRequestInterceptor())
                .target(ManualFeignClient.class, "http://127.0.0.1:18080/user");
    }

    public class ManualFeignRequestInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            log.info("manualFeign");
            template.header("manualFeign", "manualFeign");
        }
    }



}
