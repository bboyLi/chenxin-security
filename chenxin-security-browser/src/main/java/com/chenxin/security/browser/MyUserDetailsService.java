package com.chenxin.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lichenxin
 * @version 1.0
 * @since 2018/7/27 20:33
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名:"+username);
        //根据用户名查找用户信息

        //根据查找到的用户信息是否被冻结

        String password = passwordEncoder.encode("123456");
        System.out.println(password);
        return new User(username,
                password,   //加密动作应该是在注册的时候进行
                true,
                true,
                true,
                true,
                        AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
