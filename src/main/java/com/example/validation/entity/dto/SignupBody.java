package com.example.validation.entity.dto;

import com.example.validation.annotation.SignupAdminInfoConstraint;
import com.example.validation.annotation.SignupUserInfoConstraint;
import com.example.validation.entity.AdminInfo;
import com.example.validation.annotation.ConstraintGroup;
import com.example.validation.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * @author bty
 * @date 2023/2/26
 * @since 17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupBody {

    // graph validation
    @Valid
    private SignupSource signupSource;

    @NotEmpty(message = "time is empty",groups = {Default.class,ConstraintGroup.User.class,ConstraintGroup.Admin.class})
    private String signupTime;

    // 标识UserInfo类中需要校验
    @SignupUserInfoConstraint(enabled = true,message = "userInfo not valid",groups = {Default.class,ConstraintGroup.User.class})
    private UserInfo userInfo;

    @SignupAdminInfoConstraint(enabled = true,message = "adminInfo not valid",groups = {Default.class,ConstraintGroup.Admin.class})
    private AdminInfo adminInfo;

}

