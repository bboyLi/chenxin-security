package com.chenxin.web.config;

import com.chenxin.web.filter.TimeFilter;
import com.chenxin.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 10:58
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 拦截器配置
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> url = new ArrayList<>();
        url.add("/*");

        //指定需要过滤的路径
        registrationBean.setUrlPatterns(url);
        return registrationBean;
    }

}
