package com.yuge.ing.business.transaction.different.case1;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在不同类中函数互相调用
 * case1：
 *        A#handle()为外部调用方法入口；
 *        A#handle()添加了@Transactional注解；
 *        B#handle()没有添加，并且抛异常；
 *
 * result:
 *        两个函数操作的数据都会回滚
 *
 *
 * @author: yuge
 * @date: 2021-03-15
 **/
@Component
public class DifferentCase1 {

    @Autowired
    private Case1A a;

    public void handle() {
        a.handle();
    }

}

@Component
class Case1A {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Case1B b;

    /**
     * 外部调用该方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void handle() {
        orderService.save(new OrderEntity("111"));
        // 调用外部方法
        b.handle();
    }
}

@Component
class Case1B {

    @Autowired
    private OrderItemService orderItemService;

    public void handle() {
        orderItemService.save(new OrderItemEntity("111"));
        // 定义异常
        int i = 1 / 0;
    }
}