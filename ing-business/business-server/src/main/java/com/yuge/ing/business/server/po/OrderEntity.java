package com.yuge.ing.business.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author yuge
 * @since 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("biz_order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货地址
     */
    private String consigneeAddress;

    /**
     * 收货人手机
     */
    private String consigneeMobile;

    /**
     * 配送方式
     */
    private String deliveryWay;

    /**
     * 期望送货日期
     */
    private LocalDateTime expectedDeliveryDate;

    /**
     * 付款方式
     */
    private String payWay;

    /**
     * 付款时间
     */
    private LocalDateTime payDate;

    /**
     * 订单状态
     */
    private String orderStatus;

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


    public OrderEntity() {
    }

    public OrderEntity(String orderNo) {
        this.orderNo = orderNo;
    }
}
