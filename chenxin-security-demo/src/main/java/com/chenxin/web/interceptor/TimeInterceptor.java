package com.chenxin.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *spring intercptor  比fliter多一个参数
 * HandlerMethod是拿不到参数的，所有使用aop aspect
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 11:07
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 访问controller方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle");
        //System.out.println(((Handler)handler).getBean().getClass().getName());
        //System.out.println(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("starttime",new Date().getTime());
        return true;
    }

    /**
     * 控制器方法处理之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start = (Long) request.getAttribute("starttime");
        System.out.println("time inerceptor耗时："+(new Date().getTime()-start));


    }

    /**
     * 无论有没有抛出异常都会调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        Long start = (Long) request.getAttribute("starttime");
        System.out.println("time interceptor 耗时："+(new Date().getTime()-start));
        if(ex!=null){
            System.out.println(ex.getMessage());
        }
    }
}
