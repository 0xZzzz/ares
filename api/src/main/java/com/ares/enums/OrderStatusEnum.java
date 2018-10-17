package com.ares.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态枚举
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
public enum OrderStatusEnum {

    /**
     * 等待付款
     */
    WAITING_PAYMENT(1),
    /**
     * 订单完成
     */
    FINISHED(2),
    /**
     * 订单取消
     */
    CANCELED(3);

    private static final Map<Integer, OrderStatusEnum> MAP = Collections.unmodifiableMap(
        new HashMap<Integer, OrderStatusEnum>() {
            {
                for (OrderStatusEnum orderStatus : OrderStatusEnum.values()) {
                    put(orderStatus.getStatus(), orderStatus);
                }
            }
        });

    /**
     * 根据状态码获取枚举对象
     *
     * @param status 订单状态枚举值
     * @return 枚举对象
     */
    public static OrderStatusEnum get(int status) {
        return MAP.get(status);
    }

    private int status;

    OrderStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
