package com.jim.server.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jim.server.project.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
public interface UserService extends IService<User> {

    User selectUserByUserName(String username);
}
