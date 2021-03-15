package com.yuge.ing.business.transaction.different.case3;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在不同类中函数互相调用
 * case3：
 *        A#handle()为外部调用方法入口；
 *        A#handle()添加了@Transactional注解，开启事务；
 *        A#handle()在调用B#handle()时，增加了try catch代码块捕获异常；
 *        B#handle()添加了@Transactional注解，开启事务，并且抛异常；
 *
 * result:
 *        两个函数执行都未成功；回滚抛出异常；
 *        并且抛出异常：org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
 *
 *        两个函数处于同一事务；
 *        B#handle()抛出异常，调用事务的rollback函数，该事务被标记为rollback;
 *        A#handle()执行过程中，捕获了调用B#handle()的异常；A#handle()可以正常执行完成，并在完成时提交事务；
 *        commit时，由于事务被标记为rollback-only，直接抛出异常UnexpectedRollbackException；
 *
 * @author: yuge
 * @date: 2021-03-15
 **/
@Component
public class DifferentCase3 {

    @Autowired
    private Case3A a;

    public void handle() {
        a.handle();
    }

}

@Component
class Case3A {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Case3B b;

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
//            e.printStackTrace();
        }
    }
}

@Component
class Case3B {

    @Autowired
    private OrderItemService orderItemService;

    @Transactional(rollbackFor = Exception.class)
    public void handle() {
        orderItemService.save(new OrderItemEntity("111"));
        // 定义异常
        int i = 1 / 0;
    }
}