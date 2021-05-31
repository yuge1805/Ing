package com.yuge.ing.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

// "com.yuge.ing.business.server.thirdparty"
@EnableScheduling
@EnableFeignClients({"com.yuge.ing.*.api", "com.yuge.ing.business.server.thirdparty"})
@SpringBootApplication(scanBasePackages = {"com.yuge.cloud.log", "com.yuge.ing.business"})
@MapperScan("com.yuge.ing.*.server.mapper")
public class BusinessServerApplication {

    public static void main(String[] args) {
        // 指定nacos日志配置； 或 添加自动参数-D nacos.logging.config=classpath*:logback-spring.xml
//        System.setProperty("nacos.logging.config", "classpath*:logback-spring.xml");
        SpringApplication.run(BusinessServerApplication.class, args);
    }

}
