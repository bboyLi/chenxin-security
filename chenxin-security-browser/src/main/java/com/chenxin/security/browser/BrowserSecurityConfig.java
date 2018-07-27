package com.chenxin.security.browser;

import com.chenxin.security.browser.authentication.MyAuthenticationFailureHandler;
import com.chenxin.security.browser.authentication.MyAuthenticationSuccessHandler;
import com.chenxin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *配置
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 20:02
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    //不做加密
   /* @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    */
   @Autowired
   private SecurityProperties securityProperties;

   //自定义成功处理器
   @Autowired
   private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

   //自定义失败处理器
   @Autowired
   private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

   @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
        //http.httpBasic()
            .loginPage("/authentication/require")                   //未登录时 登录的页面或请求
            .loginProcessingUrl("/authentication/form")              //处理登录的url
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require"
                    ,securityProperties.getBrowser().getLoginPage()).permitAll() //不拦截的请求或页面
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();
    }
}
