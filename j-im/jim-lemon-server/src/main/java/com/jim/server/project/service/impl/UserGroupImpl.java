package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.UserGroup;
import com.jim.server.project.mapper.UserGroupMapper;
import com.jim.server.project.service.UserGroupService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和群组关联表 服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class UserGroupImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {
	
}
