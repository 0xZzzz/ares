package com.ares.service.settlement;

import com.ares.domain.ChargeInfo;
import com.ares.enums.OrderTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 特殊业务结算基类
 */
public abstract class AbstractFwSettlementStrategy extends AbstractSettlementStrategy {

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
