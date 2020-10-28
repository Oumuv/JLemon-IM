package com.jim.server.common.security.service;

import com.jim.server.common.security.LoginUser;
import com.jim.server.common.utils.RedisCacheTemplate;
import org.jim.core.ImConst;
import org.jim.core.packets.LoginReqBody;
import org.jim.core.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/***
 *<pre>
 *  TokenService
 *</pre>
 * @ClassName: TokenService
 * @Auther: oyf
 * @Date: 2020/10/28 14:04
 * @version : V1.0
 */
@Component
public class TokenService {
    @Autowired
    RedisCacheTemplate redisCacheTemplate;

    public String createToken(LoginUser loginUser) {
        String sign = getToken(loginUser.getUsername(),loginUser.getPassword());
        redisCacheTemplate.setCacheObject(sign, loginUser, 20, TimeUnit.MINUTES);
        return sign;
    }

    public LoginUser getLoginUser(String token) {
        LoginUser cacheObject = redisCacheTemplate.getCacheObject(token);
        return cacheObject;
    }

    /**
     * 获取token
     * @param
     * @return
     */
    public String getToken(String username ,String password) {
        String text = username+password;
        String key = ImConst.AUTH_KEY;
        return Md5.sign(text, key, ImConst.CHARSET);
    }
}
