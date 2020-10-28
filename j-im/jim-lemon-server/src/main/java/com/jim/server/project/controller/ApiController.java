package com.jim.server.project.controller;

import com.jim.server.common.security.LoginUser;
import com.jim.server.common.security.service.LoginService;
import com.jim.server.common.service.LoginServiceProcessor;
import com.jim.server.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *<pre>
 *
 *</pre>
 * @ClassName: ApiController
 * @Auther: oyf
 * @Date: 2020/10/17 23:08
 * @version : V1.0
 */
@RestController
@RequestMapping("server")
public class ApiController {

    @Autowired
    LoginServiceProcessor loginProcessor;

    @Autowired
    LoginService loginService;

    /**
     * 登录
     * @param userId
     * @param password
     * @return
     */
    @PostMapping("user/login")
    public AjaxResult login( String userId, String password) {
        LoginUser loginUser = loginService.login(userId, password);
        return AjaxResult.success(loginUser);
    }

}
