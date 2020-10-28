package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.Groups;
import com.jim.server.project.mapper.GroupsMapper;
import com.jim.server.project.service.GroupsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 群组表 服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class GroupsImpl extends ServiceImpl<GroupsMapper, Groups> implements GroupsService {
	
}
