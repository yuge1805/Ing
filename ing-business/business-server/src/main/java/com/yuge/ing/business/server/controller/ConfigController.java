package com.yuge.ing.business.server.controller;

import com.yuge.ing.business.server.config.TemplateConfig;
import com.yuge.ing.business.server.config.TemplateExtConfig;
import com.yuge.ing.commons.result.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author: yuge
 * @date: 2021-12-21
 **/
@Slf4j
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private TemplateConfig templateConfig;

    @Resource
    private TemplateExtConfig templateExtConfig;

    @PostConstruct
    private void init() {
        log.info("template config url: {}", templateConfig.getUrl());
        log.info("template ext config server url: {}", templateExtConfig.getServerUrl());
        log.info("template ext config url: {}", templateExtConfig.getUrl());
        log.info("template ext sub config url: {}",
                templateExtConfig.getSubConfig() != null ? templateExtConfig.getSubConfig().getUrl() : StringUtils.EMPTY);
    }

}
