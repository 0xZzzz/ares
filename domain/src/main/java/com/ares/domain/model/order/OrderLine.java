package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * 订单行
 */
@Getter
@AllArgsConstructor
public class OrderLine {

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
    private Sku sku;

}
