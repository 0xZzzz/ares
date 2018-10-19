package com.ares.service.settlement;

import com.ares.enums.ChargeTypeEnum;

/**
 * 代付
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
public class PaySettlementStrategy extends AbstractFwSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.PAY;
    }

}
