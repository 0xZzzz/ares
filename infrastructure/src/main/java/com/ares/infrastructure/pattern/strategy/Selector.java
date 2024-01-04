package com.ares.infrastructure.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 计费结算选择器
 *
 * @author 0xZzzz
 */
public class Selector {

    /**
     * chargeType --> strategy
     */
    private static final Map<Integer, SettlementStrategy> MAPPING = new HashMap<>();

    /**
     * 添加映射
     */
    public static void add(Integer chargeType, SettlementStrategy strategy) {
        MAPPING.put(chargeType, strategy);
    }

    /**
     * 选择计费结算策略
     */
    public static SettlementStrategy select(Integer chargeType) {
        return MAPPING.get(chargeType);
    }

}
