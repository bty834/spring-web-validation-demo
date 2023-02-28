package com.example.validation.validator;

import com.example.validation.annotation.SignupUserInfoConstraint;
import com.example.validation.entity.UserInfo;
import com.google.common.base.Strings;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;


/**
 * @author bty
 * @date 2023/2/27
 * @since 17
 **/
public class SignupUserInfoConstraintValidator implements ConstraintValidator<SignupUserInfoConstraint, UserInfo> {

    private boolean enabled = false;

    private static final String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";


    @Override
    public void initialize(SignupUserInfoConstraint constraintAnnotation) {
        this.enabled = constraintAnnotation.enabled();
    }


    @Override
    public boolean isValid(UserInfo userInfo, ConstraintValidatorContext context) {
        // 如果没开启，直接通过
        if (!enabled) {
            return true;
        }
        // 关闭默认message
        context.disableDefaultConstraintViolation();

        if (Objects.isNull(userInfo)) {
            context.buildConstraintViolationWithTemplate("userInfo is null").addConstraintViolation();
            return false;
        }


        if(Strings.isNullOrEmpty(userInfo.getUsername())||Strings.isNullOrEmpty(userInfo.getPassword())){
            context.buildConstraintViolationWithTemplate("userInfo or password is null or empty").addConstraintViolation();
            return false;
        }

        if(userInfo.getAge() < 18){
            context.buildConstraintViolationWithTemplate("18 forbidden!").addConstraintViolation();
            return false;
        }

        if(!userInfo.getEmail().matches(EMAIL_REGEX)){
            context.buildConstraintViolationWithTemplate("email not valid").addConstraintViolation();
            return false;
        }

        return true;
    }
}
