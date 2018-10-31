package com.ares.service.message.observer;

import com.ares.domain.Order;
import org.springframework.stereotype.Service;

/**
 * 结算观察者
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
@Service
public class SettlementObserver extends AbstractOrderFinishObserver {

    @Override
    protected void doNotify(Order order) {
        System.out.println(String.format("观察者：结算。订单%s做结算", order.getOrderId()));
    }

}
