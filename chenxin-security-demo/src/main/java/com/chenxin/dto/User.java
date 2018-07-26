package com.chenxin.dto;

import com.chenxin.validator.MyConstraint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/26 18:34
 */
@ApiModel(value = "用户嘻嘻" )
public class User {


    @ApiModelProperty(value = "用户名",example = "lichenxin")
    @NotBlank(message = "用户名不能为空！")
    private String username;

    @MyConstraint(message = "自定义注解！")
    private String password;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Past(message = "生日必须为当前时间之前!")
    private Date birthday;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
