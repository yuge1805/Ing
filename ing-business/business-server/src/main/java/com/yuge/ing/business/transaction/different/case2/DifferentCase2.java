package com.yuge.ing.business.transaction.different.case2;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在不同类中函数互相调用
 * case2：
 *        A#handle()为外部调用方法入口；
 *        A#handle()添加了@Transactional注解；
 *        A#handle()在调用B#handle()时，增加了try catch代码块捕获异常；
 *        B#handle()没有添加@Transactional注解，并且抛异常；
 *
 * result:
 *        两个函数操作的数据都未回滚
 *
 *
 * @author: yuge
 * @date: 2021-03-15
 **/
@Component
public class DifferentCase2 {

    @Autowired
    private Case2A a;

    public void handle() {
        a.handle();
    }

}

@Component
class Case2A {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Case2B b;

    /**
     * 外部调用该方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void handle() {
        orderService.save(new OrderEntity("111"));
        // 调用外部方法
        try {
            b.handle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Component
class Case2B {

    @Autowired
    private OrderItemService orderItemService;

    public void handle() {
        orderItemService.save(new OrderItemEntity("111"));
        // 定义异常
        int i = 1 / 0;
    }
}