package com.ares.enums;

import lombok.Getter;

/**
 * 计费类型枚举
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public enum ChargeTypeEnum {

    /**
     * 佣金
     */
    COMMISSION(1),

    /**
     * 在线支付
     */
    ONLINE(2),

    /**
     * 代付
     */
    PAY(3);

    @Getter
    private int type;

    ChargeTypeEnum(int type) {
        this.type = type;
    }
}
