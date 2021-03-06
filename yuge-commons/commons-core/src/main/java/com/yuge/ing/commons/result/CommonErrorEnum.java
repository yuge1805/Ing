package com.yuge.ing.commons.result;

import lombok.Getter;

/**
 * @author: yuge
 * @date: 2021-05-18
 **/
public enum CommonErrorEnum {

    ERROR_SYSTEM("99999", "System error.");

    @Getter
    private String code;
    @Getter
    private String msg;

    CommonErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
