package com.chenxin.security.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  统一json返回格式
 * */
@ApiModel
@Data
public class Result<T>{
    /*返回码*/
    @ApiModelProperty(value = "返回码")
    private Integer code;
    /*返回信息提示*/
    @ApiModelProperty(value = "返回信息提示")
    private String message;
    /*返回的数据*/
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp;



    public Result(){}

    public Result(Integer code, String message, T data, Long timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp=timestamp;
    }

    public Result(Integer code, String message, Long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }
}
