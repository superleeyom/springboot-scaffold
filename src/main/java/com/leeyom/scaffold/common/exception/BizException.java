package com.leeyom.scaffold.common.exception;

import com.leeyom.scaffold.common.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用业务异常
 *
 * @author leeyom
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends BaseException {
    public BizException(Status status) {
        super(status);
    }

    public BizException(Status status, Object data) {
        super(status, data);
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(Integer code, String message, Object data) {
        super(code, message, data);
    }

}
