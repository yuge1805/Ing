package com.yuge.ing.user.server.config.nacos;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * @author: yuge
 * @date: 2020-12-30
 **/
@RefreshScope
@ConfigurationProperties(prefix = "tea")
@Data
public class TeaConfig implements InitializingBean, DisposableBean {

    /**
     * tea.name
     */
    private String name;

    /**
     * tea.price
     */
    private BigDecimal price;

    @PostConstruct
    public void init() {
        System.out.printf("xxx [init] tea name : %s , price : %f%n", name, price);
    }

    @Override
    public String toString() {
        return "TeaConfig{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("xxx [afterPropertiesSet()] " + toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[destroy()] " + toString());
    }
}
