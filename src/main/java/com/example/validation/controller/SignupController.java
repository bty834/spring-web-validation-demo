package com.example.validation.controller;

import com.example.validation.annotation.ValidWhatever;
import com.example.validation.annotation.ConstraintGroup;
import com.example.validation.entity.dto.SignupBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Map;

/**
 * @author bty
 * @date 2023/2/26
 * @since 17
 * <br/>
 * @description <br/>
 * 注册场景：分为user注册和admin注册<br/>
 * user注册不需要校验AdminInfo<br/>
 * admin注册不需要校验UserInfo<br/>
 * <br/>
 * 这里使用@Validated达到这种分组校验效果<br/>
 * 自定义Valid注解需要添加一个Class[] value()字段，同样可以支持分组<br/>
 * 而@Valid在Spring的实现中不支持分组<br/>
 * 具体代码细节参考{@link ValidationAnnotationUtils#determineValidationHints(Annotation)}
 * 这里的hints实际上就是分组
 * <br/>
 * <br/>
 * 标记该实体需要提供校验有三种方式：<br/>
 * 1. @Valid 属于jsr303规范<br/>
 * 2. @Validated 属于Spring Validation，支持分组校验<br/>
 * 3. 自定义Valid开头注解<br/>
 * <br/>
 * 除了校验请求体之外，SpringWeb在RequestResponseBodyMethodProcessor中也实现了对响应体的校验<br/>
 * 将@Valid/@Validated/自定义Valid开头注解放在@ResponseBody注解的参数上就行。
 **/
@RestController
@RequestMapping
public class SignupController {

    /**
     * 方式一：@Valid注解，@Valid是一个标识注解，Spring 的实现中不支持分组
     * @param signupBody
     * @return
     */
    @PostMapping("/valid/signup")
    public Map signup(@Valid  @RequestBody SignupBody signupBody){
        System.out.println(signupBody);
        return Collections.singletonMap("signup", signupBody);
    }

    /**
     * 方式二：@Validated，这里指定校验ConstraintGroup.User的group的Constraint
     * @param signupBody
     * @return
     */
    @PostMapping("/validated/signup")
    public Map signupLikeUp(@Validated(ConstraintGroup.User.class) @RequestBody SignupBody signupBody){
        System.out.println(signupBody);
        return Collections.singletonMap("signup", signupBody);
    }

    /**
     * 方式二：@Validated，这里指定校验ConstraintGroup.Admin的group的Constraint
     * @param signupBody
     * @return
     */
    @PostMapping("/validated/admin/signup")
    public Map adminSignup(@Validated(value = {ConstraintGroup.Admin.class}) @RequestBody SignupBody signupBody){
        System.out.println(signupBody);
        return Collections.singletonMap("signup", signupBody);
    }

    /**
     * 方式三：自定义Valid开头注解，支持分组校验
     * @param signupBody
     * @return
     */
    @PostMapping("/validwhatever/signup")
    public Map signupLikeUpUp(@ValidWhatever(value ={Default.class, ConstraintGroup.User.class}) @RequestBody SignupBody signupBody){
        System.out.println(signupBody);
        return Collections.singletonMap("signup", signupBody);
    }




}

