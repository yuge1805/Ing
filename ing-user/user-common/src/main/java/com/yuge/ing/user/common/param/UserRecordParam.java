package com.yuge.ing.user.common.param;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 账号记录
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
@Data
public class UserRecordParam {

    /**
     * userId
     */
    private Long userId;

    /**
     * 备注
     */
    private String remark;

}
