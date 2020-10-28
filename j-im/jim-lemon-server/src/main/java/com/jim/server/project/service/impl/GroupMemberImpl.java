package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.GroupMember;
import com.jim.server.project.mapper.GroupMemberMapper;
import com.jim.server.project.service.GroupMemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组内成员表 服务实现类
 * </p>
 *
 * @author oyf
 * @since 2020-10-16
 */
@Service
public class GroupMemberImpl extends ServiceImpl<GroupMemberMapper, GroupMember> implements GroupMemberService {
	
}
