package com.example.validation.validator;

import com.example.validation.annotation.SignupAdminInfoConstraint;
import com.example.validation.entity.AdminInfo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @author bty
 * @date 2023/2/28
 * @since 17
 **/
public class SignupAdminInfoConstraintValidator implements ConstraintValidator<SignupAdminInfoConstraint, AdminInfo> {

    private boolean enabled = false;


    @Override
    public void initialize(SignupAdminInfoConstraint constraintAnnotation) {
        this.enabled = constraintAnnotation.enabled();
    }
    @Override
    public boolean isValid(AdminInfo value, ConstraintValidatorContext context) {
        // 如果没开启，直接通过
        if (!enabled) {
            return true;
        }
        if(Objects.isNull(value) || Objects.isNull(value.getId())){
            return false;
        }
        return true;
    }
}
