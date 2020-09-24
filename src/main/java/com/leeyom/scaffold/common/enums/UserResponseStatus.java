package com.leeyom.scaffold.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户业务响应枚举
 *
 * @author leeyom wang
 * @date 2020/9/24 3:07 下午
 */
@Getter
@AllArgsConstructor
public enum UserResponseStatus implements IStatus{

    USER_NOT_EXIT(1000, "用户不存在");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;
}
