package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.User;
import com.jim.server.project.mapper.UserMapper;
import com.jim.server.project.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectUserByUserName(String username) {
        User user = getOne(new QueryWrapper<User>().eq("username", username));
        return user;
    }
}
