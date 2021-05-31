package com.yuge.ing.user.common.dto;

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
public class UserRecordDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * userId
     */
    private Long userId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 平台Id
     */
    private Long tenantId;

    /**
     * 创建时间
     */
    private LocalDateTime crtTime;

    /**
     * 创建人id
     */
    private Long crtUserId;

    /**
     * 创建人姓名
     */
    private String crtUserName;

    /**
     * 更新时间
     */
    private LocalDateTime updTime;

    /**
     * 更新人id
     */
    private Long updUserId;

    /**
     * 更新人姓名
     */
    private String updUserName;

    /**
     * 是否删除，0 未删除， 1 已删除
     */
    private Integer deleted;


}
