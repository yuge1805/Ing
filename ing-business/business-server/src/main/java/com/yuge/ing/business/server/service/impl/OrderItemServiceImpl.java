package com.yuge.ing.business.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.mapper.OrderItemMapper;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单明细 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

    @Override
    public void addItem(OrderItemEntity orderItemEntity) {
        this.save(orderItemEntity);
    }

    @Override
    public void deleteByOrderNo(String orderNo) {
        this.remove(new QueryWrapper<OrderItemEntity>().lambda().eq(OrderItemEntity::getOrderNo, orderNo));
    }

    @Override
    public List<OrderItemEntity> queryByOrderNo(String orderNo) {
        return this.list(new QueryWrapper<OrderItemEntity>().lambda().eq(OrderItemEntity::getOrderNo, orderNo));
    }
}
