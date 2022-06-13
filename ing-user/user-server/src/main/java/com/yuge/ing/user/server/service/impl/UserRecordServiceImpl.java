package com.yuge.ing.user.server.service.impl;

import com.yuge.ing.user.common.param.UserRecordParam;
import com.yuge.ing.user.server.po.UserRecordEntity;
import com.yuge.ing.user.server.mapper.UserRecordMapper;
import com.yuge.ing.user.server.service.UserRecordService;
import com.yuge.cloud.mybatis.core.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 账号 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
@Service
public class UserRecordServiceImpl extends ServiceImpl<UserRecordMapper, UserRecordEntity> implements UserRecordService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserRecordParam userRecordParam) {
        this.save(new UserRecordEntity()
                .setUserId(userRecordParam.getUserId())
                .setRemark(userRecordParam.getRemark()));
    }

}
