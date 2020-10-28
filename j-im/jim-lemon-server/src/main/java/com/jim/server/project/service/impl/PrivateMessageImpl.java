package com.jim.server.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.project.entity.PrivateMessage;
import com.jim.server.project.mapper.PrivateMessageMapper;
import com.jim.server.project.service.PrivateMessageService;
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
public class PrivateMessageImpl extends ServiceImpl<PrivateMessageMapper, PrivateMessage> implements PrivateMessageService {
	
}
