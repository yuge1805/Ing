package com.yuge.ing.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuge.ing.*.server.mapper")
public class BusinessServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessServerApplication.class, args);
    }

}
