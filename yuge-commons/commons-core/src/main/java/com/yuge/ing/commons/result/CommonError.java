package com.yuge.ing.commons.result;

import lombok.Getter;

/**
 * @author: yuge
 * @date: 2021-05-18
 **/
public enum CommonError {

    ERROR_SYSTEM("00000", "System error.");

    @Getter
    private String code;
    @Getter
    private String msg;

    CommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
