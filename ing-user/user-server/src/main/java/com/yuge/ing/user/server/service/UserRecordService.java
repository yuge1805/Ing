package com.yuge.ing.user.server.service;

import com.yuge.ing.user.common.param.UserRecordParam;
import com.yuge.ing.user.server.po.UserRecordEntity;
import com.yuge.cloud.mybatis.core.service.IService;

/**
 * <p>
 * 账号 服务类
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
public interface UserRecordService extends IService<UserRecordEntity> {

    void add(UserRecordParam userRecordParam);

}
