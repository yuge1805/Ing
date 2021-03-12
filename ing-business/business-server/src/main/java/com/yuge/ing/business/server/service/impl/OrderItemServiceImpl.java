package com.yuge.ing.business.server.service.impl;

import com.yuge.ing.business.server.po.OrderItemEntity;
import com.yuge.ing.business.server.mapper.OrderItemMapper;
import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
