package com.yuge.ing.business.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuge.ing.business.common.param.OrderParam;
import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.mapper.OrderMapper;
import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import com.yuge.ing.user.api.UserRecordClient;
import com.yuge.ing.user.common.param.UserRecordParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private UserRecordClient userRecordClient;

    @Override
    public void addOrder(OrderEntity orderEntity) {
        this.save(orderEntity);
    }

    @Override
    public void addOrder(OrderParam orderParam) {
        orderParam.setOrderNo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        // user record
        UserRecordParam userRecordParam = new UserRecordParam();
        userRecordParam.setUserId(1L);
        userRecordParam.setRemark(orderParam.getOrderNo());
//        userRecordClient.add(userRecordParam);
        // order
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderParam, orderEntity);
        this.save(orderEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrderAndInnerItem(OrderEntity orderEntity, OrderItemEntity orderItemEntity) {
        this.save(orderEntity);
        addInnerItem(orderItemEntity);
    }

    public void addInnerItem(OrderItemEntity orderItemEntity) {
        orderItemService.save(orderItemEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrderAndInnerItemPrivate(OrderEntity orderEntity, OrderItemEntity orderItemEntity) {
        this.save(orderEntity);
        addInnerItemPrivate(orderItemEntity);
    }

    private void addInnerItemPrivate(OrderItemEntity orderItemEntity) {
        orderItemService.save(orderItemEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrderAndItem(OrderEntity orderEntity, OrderItemEntity orderItemEntity) {
        this.save(orderEntity);
        try {
            orderItemService.addItem(orderItemEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrderAndItemWithoutTransactional(OrderEntity orderEntity, OrderItemEntity orderItemEntity) {
        this.addOrderAndItem(orderEntity, orderItemEntity);
    }


    @Override
    public void deleteByOrderNo(String orderNo) {
        this.remove(new QueryWrapper<OrderEntity>().lambda().eq(OrderEntity::getOrderNo, orderNo));
    }

    @Override
    public List<OrderEntity> queryByOrderNo(String orderNo) {
        return this.list(new QueryWrapper<OrderEntity>().lambda().eq(OrderEntity::getOrderNo, orderNo));
    }
}
