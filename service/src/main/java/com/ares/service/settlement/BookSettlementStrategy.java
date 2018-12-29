package com.ares.service.settlement;

import com.ares.model.FinanceChargeRequest;
import com.ares.model.FinanceChargeResponse;
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

    @Override
    protected FinanceChargeResponse submitCharge(FinanceChargeRequest request) {
        // 调用升级的接口
        return null;
    }
}
