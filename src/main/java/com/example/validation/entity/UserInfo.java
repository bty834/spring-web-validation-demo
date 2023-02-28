package com.example.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author bty
 * @date 2023/2/27
 * @since 17
 * @description 纯洁的entity
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {

    private String username;
    private String password;
    private boolean agenda;
    private Integer age;
    private String email;
}
