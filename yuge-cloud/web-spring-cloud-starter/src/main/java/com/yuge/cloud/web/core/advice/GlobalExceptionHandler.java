package com.yuge.cloud.web.core.advice;

import com.yuge.ing.commons.exception.CommonException;
import com.yuge.ing.commons.result.CommonErrorEnum;
import com.yuge.ing.commons.result.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: yuge
 * @date: 2021-06-03
 **/
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 异常拦截
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public CommonResponse handle(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        log.error("GlobalExceptionHandler", e);
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            return CommonResponse.error(commonException.getErrorCode(), commonException.getMessage());
        }
        return CommonResponse.error(CommonErrorEnum.ERROR_SYSTEM);
    }

}
