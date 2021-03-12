package com.yuge.ing.business.server.service;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.cloud.mybatis.core.service.IService;
import com.yuge.ing.business.server.po.OrderItemEntity;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
public interface OrderService extends IService<OrderEntity> {

    /**
     * 新增
     *
     * @param orderEntity
     * @param orderItemList
     */
    void addOrderAndItem(OrderEntity orderEntity, OrderItemEntity orderItemList);

}
