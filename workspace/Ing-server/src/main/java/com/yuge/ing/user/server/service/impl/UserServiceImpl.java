package com.yuge.ing.user.server.service.impl;

import com.yuge.ing.user.server.po.User;
import com.yuge.ing.user.server.mapper.UserMapper;
import com.yuge.ing.user.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号 服务实现类
 * </p>
 *
 * @author yuge
 * @since 2020-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
