package com.ares.enums;

import lombok.Getter;

/**
 * 支付方式枚举
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public enum PaymentTypeEnum {

    /**
     * 在线支付
     */
    ONLINE(1),

    /**
     * 货款抵扣
     */
    DEDUCTION(2);

    @Getter
    private int code;

    PaymentTypeEnum(int code) {
        this.code = code;
    }
}
