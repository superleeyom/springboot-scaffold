package com.leeyom.scaffold.common.exception;


import cn.hutool.core.util.StrUtil;
import com.leeyom.scaffold.common.dto.ResultDTO;
import com.leeyom.scaffold.common.enums.ApiBaseEnum;
import com.leeyom.scaffold.common.enums.ApiResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理
 *
 * @author leeyom
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultDTO handException(Exception e) {
        e.printStackTrace();
        log.error("异常日志：", e);
        return new ResultDTO(ApiResponseEnum.FAIL, e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public ResultDTO handBizException(BizException e) {
        e.printStackTrace();
        log.error("异常日志：", e);
        String customMsg = e.getCustomMsg();
        ApiBaseEnum apiEnum = e.getApiEnum();
        if (apiEnum == null) {
            apiEnum = ApiResponseEnum.FAIL;
            return new ResultDTO(apiEnum, StrUtil.isNotBlank(customMsg) ? customMsg : apiEnum.getMsg());
        }
        return new ResultDTO(apiEnum, StrUtil.isNotBlank(customMsg) ? customMsg : apiEnum.getMsg());
    }

}
