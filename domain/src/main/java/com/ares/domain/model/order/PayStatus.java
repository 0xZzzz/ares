package com.ares.domain.model.order;

import lombok.AllArgsConstructor;

/**
 * 支付状态（钱状态）
 */
@AllArgsConstructor
public enum PayStatus {

    /**
     * 等待买家付款
     */
    WAIT_BUYER_PAY(1),

    /**
     * 已付款
     */
    PAID(2),

    /**
     * 已退款
     */
    REFUNDED(4),

    /**
     * 交易成功
     */
    SUCCEED(6),

    /**
     * 已关闭
     */
    CLOSED(8),

    /**
     * 已冻结
     */
    FROZEN(9);

    private final int code;

    public int code() {
        return code;
    }

}
