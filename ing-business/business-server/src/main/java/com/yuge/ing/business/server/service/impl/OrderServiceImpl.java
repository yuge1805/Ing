package com.yuge.ing.business.server.service.impl;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.mapper.OrderMapper;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Autowired
    private OrderItemService orderItemService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrderAndItem(OrderEntity orderEntity, OrderItemEntity orderItemEntity) {
        this.save(orderEntity);
        orderItemService.save(orderItemEntity);
    }
}
