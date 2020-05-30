package com.leeyom.scaffold.common.enums;

/**
 * 操作码
 *
 * @author leeyom
 */
public enum ApiResponseEnum implements ApiBaseEnum {

    /**
     * 公共错误码100-操作失败
     */
    FAIL(100, "操作失败"),

    /**
     * 公共成功响应状态码200-操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 公共错误码400-错误的请求
     */
    BAD_REQUEST(400, "错误的请求"),

    /**
     * 公共错误码401-身份认证失败!!!
     */
    TICKET_EMPTY(401, "身份认证失败,请重新登录"),

    /**
     * 公共错误码403-没有权限
     */
    FORBIDDEN(403, "没有权限"),

    /**
     * 公共错误码400-资源不存在
     */
    RESOURCE_NOT_FOUND(404, "资源不存在"),

    /**
     * 公共错误码500-服务器处理失败
     */
    INTERNAL_ERROR(500, "服务器处理失败"),

    /**
     * 公共错误码600-缺少必要参数
     */
    PARAMETER_CAN_NOT_NULL(600, "缺少必要参数"),

    /**
     * 公共错误码601-非法参数
     */
    PARAMETER_INVALID(601, "非法参数");

    /**
     * api响应code码
     */
    private int code;

    /**
     * api错误码描述
     */
    private String msg;


    ApiResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }


}
