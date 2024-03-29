package com.ares.infrastructure.pattern.observer;

import com.ares.domain.model.order.Order;
import org.springframework.stereotype.Service;

/**
 * 履约观察者
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
@Service
public class PerformanceObserver extends AbstractOrderFinishObserver {

    @Override
    protected void doNotify(Order order) {
        System.out.println("观察者：履约。履约订单" + order.getId());
    }

}
