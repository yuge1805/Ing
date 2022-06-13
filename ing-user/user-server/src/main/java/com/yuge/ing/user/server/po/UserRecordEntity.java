package com.yuge.ing.user.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账号记录
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_record")
public class UserRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
