package com.yuge.ing.business.server.util;

import com.yuge.cloud.log.enhance.AbstractLogEnhance;
import com.yuge.ing.business.server.po.TestEntity;
import org.springframework.stereotype.Component;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
@Component
public class TestLogEnhance extends AbstractLogEnhance<TestEntity> {

    @Override
    public TestEntity enhance(Object param) {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(222L);
        testEntity.setName("test");
        return testEntity;
    }
}
