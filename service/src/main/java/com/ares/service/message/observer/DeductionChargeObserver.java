package com.ares.service.message.observer;

import com.ares.enums.ChargeTypeEnum;
import com.ares.enums.PaymentTypeEnum;
import com.ares.service.message.Order;
import org.springframework.stereotype.Service;

/**
 * 计费
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
@Service
public class DeductionChargeObserver extends AbstractChargeObserver {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.PAY;
    }

    @Override
    protected boolean isNeedCharge(Order order) {
        return super.isNeedCharge(order) && order.getPaymentType() == PaymentTypeEnum.DEDUCTION.getCode();
    }
}
