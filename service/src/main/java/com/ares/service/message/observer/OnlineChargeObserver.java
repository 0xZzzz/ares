package com.ares.service.message.observer;

import com.ares.model.Order;
import com.ares.enums.ChargeTypeEnum;
import com.ares.enums.PaymentTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 在线支付计费
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class OnlineChargeObserver extends AbstractChargeObserver {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.ONLINE;
    }

    @Override
    protected boolean isNeedCharge(Order order) {
        return super.isNeedCharge(order) && order.getPaymentType() == PaymentTypeEnum.ONLINE.getCode();
    }
}
