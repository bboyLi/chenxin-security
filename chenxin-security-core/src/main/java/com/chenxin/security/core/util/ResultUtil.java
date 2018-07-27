package com.chenxin.security.core.util;

import com.chenxin.security.core.entity.Result;
import com.chenxin.security.core.enums.ResultEnum;

import java.util.Date;

/**
 * json返回值统一格式化工具类
 * */
public class ResultUtil {
    /**
     * 数据交互成功返回
     * @param object json返回的数据
     * */
    public static Result success(Object object){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),object, new Date().getTime());
    }

    public static Result success(){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(), new Date().getTime());
    }
    /**
     * 数据交互
     * */
    public static Result notFound(){
        return  new Result(ResultEnum.NOT_FOUND.getCode(),ResultEnum.NOT_FOUND.getMsg(), new Date().getTime());
    }
    /**
     * 参数异常
     * */
    public static Result parameterError(){
        return new Result(ResultEnum.PARAMETER_ERROR.getCode(),ResultEnum.PARAMETER_ERROR.getMsg(), new Date().getTime());
    }
    /**
     * 系统异常
     * */
    public static Result systemError(){
        return new Result(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg(), new Date().getTime());
    }

    /**
     * 系统异常
     * */
    public static Result serverError(){
        return new Result(ResultEnum.SERVICE_ERROR.getCode(),ResultEnum.SERVICE_ERROR.getMsg(), new Date().getTime());
    }

    /**
     * 系统异常
     * @return Result
     */
    public static Result serverError(String message) {
        return new Result(ResultEnum.SERVICE_ERROR.getCode(), message, ResultEnum.SERVICE_ERROR.getMsg(), new Date().getTime());
    }

    /**
     * 业务异常
     * @return Result
     * */
    public static Result businessError(String message){
        return new Result(ResultEnum.ERROR.getCode(),message, new Date().getTime());
    }
    /**
     * 参数异常
     * @return Result
     * */
    public static Result parameterError(String message){
        return new Result(ResultEnum.PARAMETER_ERROR.getCode(), message, new Date().getTime());

    }

    /**
     * 登录失效异常
     * @return Result
     * */
    public static Result logout(Object object){
        return new Result(ResultEnum.LOGOUT_ERROR.getCode(),ResultEnum.LOGOUT_ERROR.getMsg(),object, new Date().getTime());
    }

    /**
     * 404异常
     *
     * @return Result
     */
    public static Result noHandler() {
        return new Result(ResultEnum.NO_HANDLER_ERROR.getCode(), ResultEnum.NO_HANDLER_ERROR.getMsg(), new Date().getTime());
    }

    /**
     * 重复提交
     * @return Result
     */
    public static Result submitRepeat(){
        return new Result(ResultEnum.SUBMIT_REPEAT.getCode(), ResultEnum.SUBMIT_REPEAT.getMsg(), new Date().getTime());
    }

    /**
     * 参数校验不通过
     * @return Result
     * */
    public static Result validationError(String message){
        return new Result(ResultEnum.VALIDATION_ERROR.getCode(), message, new Date().getTime());
    }
}