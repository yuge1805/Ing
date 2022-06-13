package com.yuge.ing.business.server.controller;

import com.yuge.cloud.log.annotation.Log;
import com.yuge.ing.business.common.param.IdsParam;
import com.yuge.ing.business.common.param.TestParam;
import com.yuge.ing.business.server.service.TestService;
import com.yuge.ing.business.server.util.TestLogDeleteEnhance;
import com.yuge.ing.business.server.util.TestLogEnhance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yuge
 * @date: 2021-03-17
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/{id}")
    @Log(msg = "#id + #testParam.name + #enhance.name", enhanceArgs = "#id", enhanceClass = TestLogEnhance.class)
    public String update(@PathVariable("id") Long id, @RequestBody TestParam testParam) {
        testService.add(testParam);
        return "success";
    }

    @PostMapping("/delete")
    @Log(msg = "#idsParam.ids", enhanceArgs = "#idsParam.ids", enhanceClass = TestLogDeleteEnhance.class)
    public String delete(@RequestBody IdsParam idsParam) {
        return "deleteSuccess";
    }

}
