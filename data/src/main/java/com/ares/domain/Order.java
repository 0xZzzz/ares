package com.ares.domain;

import lombok.Data;

/**
 * 订单实体
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
@Data
public class Order extends BaseDomain {

    private Long orderId;

    private Integer orderStatus;

    private Long userId;

    public Order() {
    }

    public Order(Long orderId) {
        this.orderId = orderId;
    }

}
