package com.yuge.ing.commons.exception;

import com.yuge.ing.commons.result.CommonErrorEnum;

/**
 * @author: yuge
 * @date: 2021-06-03
 **/
public class CommonException extends RuntimeException {

    private String errorCode;

    public CommonException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonException(String message) {
        super(message);
        this.errorCode = CommonErrorEnum.ERROR_SYSTEM.getCode();
    }

    public CommonException(CommonErrorEnum commonErrorEnum) {
        super(commonErrorEnum.getMsg());
        this.errorCode = commonErrorEnum.getCode();
    }

    public CommonException(CommonErrorEnum commonErrorEnum, String message) {
        super(message);
        this.errorCode = commonErrorEnum.getCode();
    }

    public String getErrorCode() {
        return errorCode;
    }
}
