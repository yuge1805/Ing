package com.yuge.ing.business.server.service;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.cloud.mybatis.core.service.IService;

import java.util.List;

/**
 * <p>
 * 订单明细 服务类
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    /**
     * 新增
     *
     * @param orderItemEntity
     */
    void addItem(OrderItemEntity orderItemEntity);

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
    List<OrderItemEntity> queryByOrderNo(String orderNo);
}
