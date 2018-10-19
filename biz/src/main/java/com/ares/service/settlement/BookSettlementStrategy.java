package com.ares.service.settlement;

import com.ares.domain.FinanceChargeRequest;
import com.ares.enums.ChargeTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 图书计费
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
@Service
public class BookSettlementStrategy extends AbstractSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.BOOK;
    }

    @Override
    protected void processRequestBeforeSubmit(FinanceChargeRequest request) {
        request.setVersion(2);
    }
}
