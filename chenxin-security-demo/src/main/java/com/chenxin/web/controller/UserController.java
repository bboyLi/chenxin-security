package com.chenxin.web.controller;

import com.chenxin.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/26 18:27
 */
@Api(value = "用户信息接口value", description = "用户信息接口description")
@RestController
public class UserController {


    @GetMapping(value = "/user")
    @ApiOperation(value = "查询用户")
    public List<User> query(@RequestParam String username, Pageable pageable) {
        List<User> list = new ArrayList<>();
        User user = new User();
        list.add(user);
        list.add(user);
        list.add(user);
        return list;
    }

    @GetMapping(value = "/user/{id:\\d+}")
    public User detail(@ApiParam(value = "用户id") @PathVariable Integer id) {
        User user = new User();
        user.setUsername("李称心");
        return user;
    }

    @PostMapping(value = "/user")
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        return user;
    }

    @PutMapping(value = "/user/{id}")
    public User update(@Valid @RequestBody User user,@PathVariable Integer id,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error->{
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getDefaultMessage();
                String name = fieldError.getField();
                System.out.println(name+":"+message);
            });
        }
        return user;
    }



}
