package com.yuge.ing.business.server.service.impl;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    public static final String ORDER_NO = "111";
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @BeforeEach
    public void delete() {
        orderService.deleteByOrderNo(ORDER_NO);
        orderItemService.deleteByOrderNo(ORDER_NO);
    }

    @Test
    public void addOrderAndInnerItem() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo(ORDER_NO);
        orderEntity.setConsignee("张三");

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderNo(ORDER_NO);
        orderItemEntity.setCommodityName("苹果");

        orderService.addOrderAndInnerItem(orderEntity, orderItemEntity);
    }

    @Test
    void addOrderAndInnerItemPrivate() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo(ORDER_NO);
        orderEntity.setConsignee("张三");

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderNo(ORDER_NO);
        orderItemEntity.setCommodityName("苹果");

        orderService.addOrderAndInnerItemPrivate(orderEntity, orderItemEntity);
    }

    @Test
    void addOrderAndItem() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo(ORDER_NO);
        orderEntity.setConsignee("张三");

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderNo(ORDER_NO);
        orderItemEntity.setCommodityName("苹果");

        orderService.addOrderAndItem(orderEntity, orderItemEntity);
    }

    @Test
    void addOrderAndItemWithoutTransactional() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo(ORDER_NO);
        orderEntity.setConsignee("张三");

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderNo(ORDER_NO);
        orderItemEntity.setCommodityName("苹果");

        orderService.addOrderAndItemWithoutTransactional(orderEntity, orderItemEntity);
    }
}