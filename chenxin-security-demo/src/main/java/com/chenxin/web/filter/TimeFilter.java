package com.chenxin.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 10:43
 */
@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("my filter start..");
        long statr = new Date().getTime();
        chain.doFilter(request,response);
        System.out.println("time filter时间:" +(new Date().getTime()-statr));
        System.out.println("myfiler finish...");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroty...");
    }
}
