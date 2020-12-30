package com.yuge.ing.user.server.controller;

import com.yuge.ing.user.server.config.nacos.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuge
 * @date: 2020-12-29
 **/
@RestController
public class NacosController {

    @Autowired
    private NacosConfig nacosConfig;

    @RequestMapping("/")
    public String nacos() {
        return String.format("[HTTP] user name : %s , age : %d, tea : %s", nacosConfig.getUserName(), nacosConfig.getUserAge(), nacosConfig.getTeaConfig());
    }

}
