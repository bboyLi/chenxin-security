package com.chenxin.validator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/7/27 3:06
 */
public class MyConstraintValidate implements ConstraintValidator<MyConstraint,Object> {

    //@Autowired
    //private helloservice hello;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("initialize");
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        if(s!=null){
            return true;
        }
        return false;
    }
}
