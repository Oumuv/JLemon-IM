package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.GroupMessage;
import com.jim.server.project.mapper.GroupMessageMapper;
import com.jim.server.project.service.GroupMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class GroupMessageImpl extends ServiceImpl<GroupMessageMapper, GroupMessage> implements GroupMessageService {
	
}
