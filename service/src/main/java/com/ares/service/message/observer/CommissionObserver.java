package com.ares.service.message.observer;

import com.ares.enums.ChargeTypeEnum;
import com.ares.service.message.Order;
import com.ares.service.settlement.ChargeRequest;
import org.springframework.stereotype.Service;

/**
 * 扣点观察者
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class CommissionObserver extends AbstractChargeObserver {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.COMMISSION;
    }

    @Override
    protected boolean isNeedCharge(Order order) {
        return super.isNeedCharge(order) && order.getCommission() > 0;
    }

    @Override
    protected void processRequest(ChargeRequest request, Order order) {
        request.setChargePrice((long)(order.getPrice() * order.getCommission()));
    }
}
