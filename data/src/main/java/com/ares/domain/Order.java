package com.ares.domain;

import lombok.Data;

/**
 * 订单实体
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
@Data
public class Order extends BaseDomain {

    private Long orderId;

    private Integer orderStatus;

    private Long userId;

    private Long price;

    /**
     * 商品扣点
     */
    private Double commission;

    /**
     * 支付方式
     */
    private Integer paymentType;

    private Integer orderType;

    public Order() {
    }

    public Order(Long orderId) {
        this.orderId = orderId;
    }

}
