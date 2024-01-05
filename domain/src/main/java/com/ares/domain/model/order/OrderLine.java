package com.ares.domain.model.order;

import com.ares.domain.base.Entity;
import lombok.Getter;

import java.util.Date;

/**
 * 订单行
 */
@Getter
public class OrderLine extends Entity {

    /**
     * 订单行id
     */
    private final String id;

    /**
     * 订单id
     */
    private final String orderId;

    /**
     * 创建时间
     */
    private final Date createTime;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 收货时间
     */
    private Date receivedTime;

    /**
     * sku
     */
    private final Sku sku;

    public OrderLine(String id, Integer version, String id1, String orderId, Date createTime, Sku sku) {
        super(id, version);
        this.id = id1;
        this.orderId = orderId;
        this.createTime = createTime;
        this.sku = sku;
    }
}
