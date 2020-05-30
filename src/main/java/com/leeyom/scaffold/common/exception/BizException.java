package com.leeyom.scaffold.common.exception;


import com.leeyom.scaffold.common.enums.ApiBaseEnum;

/**
 * 通用业务异常
 *
 * @author leeyom
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -653112170620824445L;

    private String customMsg;


    private ApiBaseEnum apiBaseEnum;

    public BizException(String customMsg) {
        super(customMsg);
        this.customMsg = customMsg;
    }

    public BizException(ApiBaseEnum apiBaseEnum, String customMsg) {
        super(customMsg);
        this.customMsg = customMsg;
        this.apiBaseEnum = apiBaseEnum;
    }

    public BizException(ApiBaseEnum apiBaseEnum) {
        super(apiBaseEnum.getMsg());
        this.apiBaseEnum = apiBaseEnum;
    }

    public ApiBaseEnum getApiEnum() {
        return this.apiBaseEnum;
    }


    public String getCustomMsg() {
        return customMsg;
    }
}
