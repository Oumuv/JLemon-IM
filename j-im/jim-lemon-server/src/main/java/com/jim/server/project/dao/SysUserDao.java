package com.jim.server.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jim.server.project.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/***
 *<pre>
 *
 *</pre>
 * @interface: SysUserDao
 * @auther: oyf
 * @date: 2020/10/15 15:42
 * @version : V1.0
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
}
