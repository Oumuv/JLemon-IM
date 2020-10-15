package com.jim.server.project.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.server.common.aspectj.lang.annotation.DataSource;
import com.jim.server.common.emus.DataSourceType;
import com.jim.server.project.dao.SysUserDao;
import com.jim.server.project.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: UserService
 * @Auther: oyf
 * @Date: 2020/10/15 12:47
 * @version : V1.0
 */
@Service
public class UserService extends ServiceImpl<SysUserDao, SysUser> {
    @Autowired
    SysUserDao sysUserDao;

    @DataSource(DataSourceType.MASTER)
    public List<SysUser> getUser() {
        List<SysUser> sysUsers = sysUserDao.selectList(new QueryWrapper<>());
        return sysUsers;
    }

//    @DataSource(DataSourceType.SLAVE)
    public List<SysUser> getUser2() {
        List<SysUser> sysUsers = sysUserDao.selectList(new QueryWrapper<>());
        return sysUsers;
    }
}
