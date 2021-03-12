package com.yuge.ing.business.server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.yuge.cloud.web.core.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @GetMapping
    public String test() {
        return "test";
    }

}

