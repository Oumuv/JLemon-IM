package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.UserLoginHistory;
import com.jim.server.project.mapper.UserLoginHistoryMapper;
import com.jim.server.project.service.UserLoginHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录历史表 服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class UserLoginHistoryImpl extends ServiceImpl<UserLoginHistoryMapper, UserLoginHistory> implements UserLoginHistoryService {
	
}
