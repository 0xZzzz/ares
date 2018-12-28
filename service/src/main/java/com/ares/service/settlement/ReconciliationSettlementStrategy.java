package com.ares.service.settlement;

import com.ares.domain.ChargeInfo;
import com.ares.enums.ChargeTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 平账
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
@Service
public class ReconciliationSettlementStrategy extends AbstractSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.RECONCILIATION;
    }

    @Override
    protected void processSubRequestBeforeSubmit(ChargeInfo request) {
        request.setOrgId(1L);
    }
}
