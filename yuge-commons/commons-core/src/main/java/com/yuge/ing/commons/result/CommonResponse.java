package com.yuge.ing.commons.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: yuge
 * @date: 2021-05-18
 **/
@Data
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    private static final String SUCCESS_CODE = "000000";

    private static final String SUCCESS_MSG = "SUCCESS";

    private String code;

    private String msg;

    private T data;

    public CommonResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> CommonResponse<T> error(String code, String msg) {
        return new CommonResponse<>(code, msg, null);
    }

    public static <T> CommonResponse<T> error(CommonErrorEnum commonError, String msg) {
        return new CommonResponse<>(commonError.getCode(), msg, null);
    }

    public static <T> CommonResponse<T> error(CommonErrorEnum commonError) {
        return new CommonResponse<>(commonError.getCode(), commonError.getMsg(), null);
    }

    public boolean isSuccess() {
        return Objects.equals(code, SUCCESS_CODE);
    }
}
