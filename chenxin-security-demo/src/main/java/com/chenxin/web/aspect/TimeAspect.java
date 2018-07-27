package com.chenxin.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 11:47
 */
@Aspect
@Component
public class TimeAspect {

    /*@Before("")
    public void test(){

    }

    @After("")
    public void test1(){

    }

    @AfterThrowing("")
    public void test2(){

    }*/

    //切入点
    //@Around("execution(* com.chenxin.web.controller.UserController.*(..))")
    @Around("execution(* com.chenxin.web.controller.UserController.*(..)) || execution(* com.chenxin.web.async.AsyncController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切入点插入成功！！！");
        long start = new Date().getTime();
        System.out.println("TimeAspect start ...");
        Object[] args = pjp.getArgs();
        Arrays.stream(args).forEach(agr->{
            System.out.println(agr);
        });

        Object proceed = pjp.proceed();   //方法的返回数据
        System.out.println("time aspect耗时:"+(new Date().getTime()-start));
        System.out.println("TimeAspect end ...");

        return proceed;
    }

}
