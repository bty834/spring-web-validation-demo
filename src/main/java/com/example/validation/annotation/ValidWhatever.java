package com.example.validation.annotation;

import org.springframework.validation.annotation.ValidationAnnotationUtils;

import java.lang.annotation.*;

/**
 * @author bty
 * @date 2023/2/28
 * @since 17
 **/
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidWhatever {
    /**
     * 分组支持，参见{@link ValidationAnnotationUtils#determineValidationHints(Annotation)}
     * @return
     */
    Class<?>[] value() default {};
}
