package com.chenxin.security.core.enums;

public enum ResultEnum {
    /**访问成功返回*/
    SUCCESS(0,"success"),

    /**数据不存在返回*/
    NOT_FOUND(-1,"notFound [数据不存在 或者 数据为空]"),

    /**异常返回*/
    ERROR(-2,"error [未知异常]"),

    /**服务异常返回*/
    SERVICE_DIS_ERROR(-3,"服务已断开"),


    /**参数有异常返回*/
    PARAMETER_ERROR(-4,"parameter error [参数异常:参数为空或者参数类型不符]"),

    /**服务异常返回*/
    SERVICE_ERROR(-5,"服务异常"),

    /**重复提交**/
    SUBMIT_REPEAT(-6,"重复提交"),

    /**参数校验失败**/
    VALIDATION_ERROR(-7,"参数校验失败"),
    /**
     * 登录失效
     */
    LOGOUT_ERROR(-401, "登录失效"),
    /**
     * 无资源 (404)
     */
    NO_HANDLER_ERROR(-404, "请求资源不存在")
    ;

    private Integer code;

    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
