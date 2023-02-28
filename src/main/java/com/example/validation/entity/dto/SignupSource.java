package com.example.validation.entity.dto;

import com.example.validation.annotation.ConstraintGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * @author bty
 * @date 2023/2/28
 * @since 17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupSource {

    public enum Type{
        WEB,MINI_APP,DESKTOP
    }
    private Type type;

    @NotEmpty(message = "ip不能为空",groups = {Default.class,ConstraintGroup.User.class,ConstraintGroup.Admin.class})
    private String ip;

}
