package com.yuge.ing.business.server.service.impl;

import com.yuge.cloud.log.annotation.Log;
import com.yuge.ing.business.common.param.TestParam;
import com.yuge.ing.business.server.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
@Service
public class TestServiceImpl implements TestService {

//    @Log(msg = "#testParam.name")
    @Override
    public void add(TestParam testParam) {
        System.out.println("TestService Add");
    }
}
