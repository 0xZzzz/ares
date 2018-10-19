package com.ares.service.settlement;

import com.ares.enums.ChargeTypeEnum;

/**
 * 扣点
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
public class CommissionSettlementStrategy extends AbstractFwSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.COMMISSION;
    }

}
