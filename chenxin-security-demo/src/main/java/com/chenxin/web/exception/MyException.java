package com.chenxin.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *返回异常统一拦截类
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 4:26
 */

@ControllerAdvice
public class MyException {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public Object exceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp",new Date().getTime());
        map.put("code","400");
        map.put("message",e.getLocalizedMessage());
        return map;
    }
}
