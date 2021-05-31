package com.yuge.ing.business.server.service;

import com.yuge.ing.business.common.param.OrderParam;
import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.cloud.mybatis.core.service.IService;
import com.yuge.ing.business.server.po.OrderItemEntity;
import org.springframework.transaction.annotation.Transactional;

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
     */
    void addOrder(OrderEntity orderEntity);

    /**
     * 新增
     *
     * @param orderParam
     */
    void addOrder(OrderParam orderParam);

    /**
     * 新增
     *
     * @param orderEntity
     * @param orderItemList
     */
    void addOrderAndInnerItem(OrderEntity orderEntity, OrderItemEntity orderItemList);

    void addOrderAndInnerItemPrivate(OrderEntity orderEntity, OrderItemEntity orderItemEntity);

    void addOrderAndItem(OrderEntity orderEntity, OrderItemEntity orderItemEntity);

    void addOrderAndItemWithoutTransactional(OrderEntity orderEntity, OrderItemEntity orderItemEntity);

    /**
     * 删除
     *
     * @param orderNo
     */
    void deleteByOrderNo(String orderNo);

    /**
     * 根据订单号查询
     *
     * @param orderNo
     * @return
     */
    List<OrderEntity> queryByOrderNo(String orderNo);

}
