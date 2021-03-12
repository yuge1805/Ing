package com.yuge.ing.business.server.service.impl;

import com.yuge.ing.business.server.po.OrderEntity;
import com.yuge.ing.business.server.mapper.OrderMapper;
import com.yuge.ing.business.server.service.OrderService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
