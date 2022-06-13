package com.yuge.ing.business.server.util;

import com.yuge.cloud.log.enhance.AbstractLogEnhance;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
@Component
public class TestLogDeleteEnhance extends AbstractLogEnhance<String> {

    @Override
    public String enhance(Object param) {
        System.out.println("param:" + param);
        return "123123123";
    }
}
