package com.ares.service.settlement;

import com.ares.enums.ChargeTypeEnum;

/**
 * 代收
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
public class CollectionSettlementStrategy extends AbstractFwSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.COLLECT;
    }

}
