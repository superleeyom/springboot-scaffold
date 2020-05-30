package com.leeyom.scaffold.domain.dto;

import lombok.Data;

/**
 * 用户信息
 *
 * @author leeyom
 */
@Data
public class UserDTO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

}
