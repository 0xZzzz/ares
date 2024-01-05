package com.ares.domain.model.order;

import lombok.AllArgsConstructor;

/**
 * 配送方式
 */
@AllArgsConstructor
public enum DeliveryMethod {

    /**
     * 无需物流
     */
    NO_NEED(0),

    /**
     * 快递邮寄
     */
    EXPRESS(1),

    /**
     * 同城配送
     */
    CITY(2),

    /**
     * 门店自提
     */
    PICKUP_IN_STORE(3),

    /**
     * 社区自提
     */
    COMMUNITY_PICKUP(4);

    private final int code;

    public int code() {
        return code;
    }

}
