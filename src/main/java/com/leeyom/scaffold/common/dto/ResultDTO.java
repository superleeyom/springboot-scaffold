package com.leeyom.scaffold.common.dto;

import cn.hutool.core.util.StrUtil;
import com.leeyom.scaffold.common.enums.ApiBaseEnum;
import lombok.Data;

/**
 * 接口响应结果封装
 *
 * @author leeyom
 */
@Data
public class ResultDTO<T> {

    /**
     * api响应code码
     */
    private int code;

    /**
     * api响应描述
     */
    private String msg;

    /**
     * 接口响应数据
     */
    private T data;

    public ResultDTO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(ApiBaseEnum apiBaseEnum, T data, String msg) {
        this.code = apiBaseEnum.getCode();
        this.data = data;
        if (StrUtil.isNotBlank(msg)) {
            this.msg = msg;
        } else {
            this.msg = apiBaseEnum.getMsg();
        }
    }

    public ResultDTO(ApiBaseEnum apiBaseEnum) {
        this.code = apiBaseEnum.getCode();
        this.msg = apiBaseEnum.getMsg();
    }

    public ResultDTO(ApiBaseEnum apiBaseEnum, T data) {
        this.code = apiBaseEnum.getCode();
        this.msg = apiBaseEnum.getMsg();
        this.data = data;
    }

    public ResultDTO(ApiBaseEnum apiBaseEnum, String msg) {
        this.code = apiBaseEnum.getCode();
        if (StrUtil.isNotBlank(msg)) {
            this.msg = msg;
        } else {
            this.msg = apiBaseEnum.getMsg();
        }
    }
}
