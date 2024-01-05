package com.ares.domain.model.order;

import lombok.AllArgsConstructor;

/**
 * 发货状态（货状态）
 */
@AllArgsConstructor
public enum DeliveryStatus {

    /**
     * 未发货
     */
    NOT_SHIPPED(1),

    /**
     * 已发货
     */
    SHIPPED(2),

    /**
     * 已收货
     */
    RECEIVED(3),

    /**
     * 已退货
     */
    RETURNED(4),

    /**
     * 部分收货
     */
    PARTIAL_RECEIVED(5),

    /**
     * 部分发货
     */
    PARTIAL_SHIPPED(6),

    /**
     * 未创建
     */
    NOT_CREATED(8),

    /**
     * 配货中
     */
    PREPARING(9);

    private final int code;

    public int code() {
        return code;
    }

}
