package com.ares.infrastructure.pattern.strategy;

import com.ares.enums.OrderTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 特殊业务结算基类
 *
 * @author 0xZzzz
 */
public abstract class AbstractSpecialSettlementStrategy extends AbstractSettlementStrategy {

    /**
     * 特殊订单类型，作用于orgId
     */
    protected static final Map<Integer, Long> SPECIAL_ORDER_TYPE = new HashMap<Integer, Long>() {
        {
            put(OrderTypeEnum.POP.getType(), 5L);
        }
    };

    @Override
    protected void processSubRequestBeforeSubmit(ChargeInfo subRequest) {
        if (!SPECIAL_ORDER_TYPE.containsKey(subRequest.getOrderType())) {
            subRequest.setOrgId(SPECIAL_ORDER_TYPE.get(subRequest.getOrderType()));
        }
    }

}
