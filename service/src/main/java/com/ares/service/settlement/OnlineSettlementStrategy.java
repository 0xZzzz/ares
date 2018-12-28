package com.ares.service.settlement;

import com.ares.domain.ChargeInfo;
import com.ares.enums.ChargeTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 在线支付
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
@Service
public class OnlineSettlementStrategy extends AbstractSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.ONLINE;
    }

    @Override
    protected void processSubRequestBeforeSubmit(ChargeInfo request) {
        request.setOrgId(2L);
    }
}
