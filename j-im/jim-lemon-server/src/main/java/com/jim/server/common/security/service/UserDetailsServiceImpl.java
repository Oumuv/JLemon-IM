package com.jim.server.common.security.service;

import com.jim.server.common.security.LoginUser;
import com.jim.server.common.utils.StringUtils;
import com.jim.server.project.entity.User;
import com.jim.server.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 用户验证处理
 *
 * @author ruoyi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, AuthenticationProvider
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;


    /**
     * 用户名查找
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(User user)
    {
        return new LoginUser(user, null);
    }

    /**
     * 认证用户信息
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中的用户名
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码

        /** 判断用户是否存在 */
        LoginUser loginUser = (LoginUser)loadUserByUsername(userName);// 这里调用我们的自己写的获取用户的方法；
        if (loginUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        /** 判断密码是否正确 */
        if (!loginUser.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = loginUser.getAuthorities();
        return new UsernamePasswordAuthenticationToken(loginUser, password, authorities);// 构建返回的用户登录成功的token
    }

    /**
     * 执行支持判断
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;// 返回 true ，表示支持执行
    }
}
