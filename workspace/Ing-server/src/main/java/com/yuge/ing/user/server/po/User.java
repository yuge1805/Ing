package com.yuge.ing.user.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账号
 * </p>
 *
 * @author yuge
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("base_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户头像
     */
    private String userPic;

    /**
     * 账户状态，1 启用，2 禁用
     */
    private Integer status;

    /**
     * 类型，1 超管，2 普通
     */
    private Integer type;

    /**
     * 区域编码
     */
    private String areaCode;

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
