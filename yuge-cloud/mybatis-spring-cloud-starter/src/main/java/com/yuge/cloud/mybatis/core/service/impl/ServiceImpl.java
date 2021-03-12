package com.yuge.cloud.mybatis.core.service.impl;

import com.yuge.cloud.mybatis.core.mapper.BaseMapper;
import com.yuge.cloud.mybatis.core.service.IService;

/**
 * @author: yuge
 * @date: 2021-03-12
 **/
public class ServiceImpl<M extends BaseMapper<T>, T> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> implements IService<T> {
}
