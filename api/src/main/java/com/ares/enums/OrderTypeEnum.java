package com.ares.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单类型枚举
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public enum OrderTypeEnum {

    /**
     * POP
     */
    POP(1),

    /**
     * 自营
     */
    SELF(2),

    /**
     * 图书
     */
    BOOK(3);

    private static final Map<Integer, OrderTypeEnum> MAP = Collections.unmodifiableMap(
        new HashMap<Integer, OrderTypeEnum>() {
            {
                for (OrderTypeEnum orderType : OrderTypeEnum.values()) {
                    put(orderType.getType(), orderType);
                }
            }
        });

    /**
     * 判断枚举中是否包含该值
     *
     * @param type 订单类型
     * @return true：包含，false：不包含
     */
    public static boolean contains(Integer type) {
        return MAP.keySet().contains(type);
    }

    private int type;

    OrderTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
