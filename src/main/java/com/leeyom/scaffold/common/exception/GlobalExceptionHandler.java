package com.leeyom.scaffold.common.exception;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.leeyom.scaffold.common.dto.ApiResponse;
import com.leeyom.scaffold.common.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;


/**
 * 全局异常处理
 *
 * @author leeyom
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse handlerException(Exception e, HttpServletRequest request) {
        if (e instanceof NoHandlerFoundException) {
            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法：{}, 请求路径：{}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return ApiResponse.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            log.error("【全局异常拦截】HttpRequestMethodNotSupportedException: 当前请求方式：{}, 支持请求方式：{}", ((HttpRequestMethodNotSupportedException) e).getMethod(), JSONUtil.toJsonStr(((HttpRequestMethodNotSupportedException) e).getSupportedHttpMethods()));
            return ApiResponse.ofStatus(Status.HTTP_BAD_METHOD);
        } else if (e instanceof MethodArgumentNotValidException) {
            log.error("【全局异常拦截】MethodArgumentNotValidException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult()
                    .getAllErrors()
                    .get(0)
                    .getDefaultMessage(), null);
        } else if (e instanceof ConstraintViolationException) {
            log.error("【全局异常拦截】ConstraintViolationException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), CollUtil.getFirst(((ConstraintViolationException) e).getConstraintViolations())
                    .getMessage(), null);
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            log.error("【全局异常拦截】MethodArgumentTypeMismatchException: 参数名：{}, 异常信息：{}", ((MethodArgumentTypeMismatchException) e).getName(), ((MethodArgumentTypeMismatchException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error("【全局异常拦截】HttpMessageNotReadableException: 错误信息：{}", ((HttpMessageNotReadableException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_NULL);
        } else if (e instanceof BaseException) {
            log.error("【全局异常拦截】BaseException: 接口：{}, 状态码 {}, 异常信息：{}", request.getRequestURI(), ((BaseException) e).getCode(), e.getMessage());
            return ApiResponse.ofException((BaseException) e);
        }

        log.error("【全局异常拦截】异常堆栈信息： ", e);
        return ApiResponse.ofStatus(Status.ERROR, "系统繁忙，请稍后重试");
    }
}
