package com.example.validation.annotation;

import com.example.validation.validator.SignupUserInfoConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author bty
 * @date 2023/2/27
 * @since 17
 **/
// 自定义ConstraintValidator
@Constraint(validatedBy = SignupUserInfoConstraintValidator.class)
// 规范强调必须支持FIELD METHOD TYPE ANNOTAION_TYPE,其他的不做要求，是否支持得看具体实现
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
// 必须为RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface SignupUserInfoConstraint {
    boolean enabled() default false;

    // ***************************************
    //  message, groups and payload 三个必要字段
    // ***************************************
    // 错误提示信息message建议写成"全类名.message" 主要是为了i18n
    String message() default "{com.example.validation.annotation.SignupUserInfoConstraint.message}";
    // 默认必须为空
    // groups通常用来控制constraint执行顺序，或者对部分javabean做校验
    Class<?>[] groups() default {};
    // 默认必须为空
    // payload通常用来关联元信息，比如用内部类标识，用Class而不用string主要是为了易用和类型安全
    Class<? extends Payload>[] payload() default {};
}
