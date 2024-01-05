package com.ares.domain.model.order;

import com.ares.domain.base.Entity;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 履约单
 */
@Getter
@ToString
public class DeliveryOrder extends Entity {

    /**
     * 订单id
     */
    private final String orderId;

    /**
     * 发货状态
     */
    private DeliveryStatus status;

    /**
     * 收货人信息
     */
    private final Receiver receiver;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 配送方式
     */
    private DeliveryMethod method;

    /**
     * 物流费用
     */
    private Long logisticsFee;

    public DeliveryOrder(String id, Integer version, String orderId, Receiver receiver) {
        super(id, version);
        this.orderId = orderId;
        this.receiver = receiver;
    }
}
