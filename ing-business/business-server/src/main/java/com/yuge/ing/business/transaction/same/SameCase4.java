package com.yuge.ing.business.transaction.same;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在同一个类中函数互相调用
 * case4：
 *        handle()为外部调用方法入口；
 *        handle()没有添加@Transactional注解；
 *        innerHandle()添加了@Transactional注解，开启事务，并且抛异常；
 *
 * result:
 *        两个函数操作的数据都未回滚；
 *        调用内部innerHandle()函数的@Transactional注解无效；
 *
 *
 * @author: yuge
 * @date: 2021-03-15
 **/
@Component
public class SameCase4 {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 外部调用该方法
     */
    public void handle() {
        orderService.save(new OrderEntity("111"));
        // 调用内部方法
        innerHandle();
    }

    @Transactional(rollbackFor = Exception.class)
    public void innerHandle() {
        orderItemService.save(new OrderItemEntity("111"));
        // 定义异常
        int i = 1 / 0;
    }

}
