package com.yuge.ing.business.server.controller;


import com.yuge.ing.business.common.param.OrderParam;
import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.service.OrderService;
import com.yuge.ing.commons.result.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.yuge.cloud.web.core.controller.BaseController;

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

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping("/")
    public CommonResponse add(@RequestBody OrderParam orderParam) {
        orderService.addOrder(orderParam);
        return CommonResponse.success(true);
    }

}

