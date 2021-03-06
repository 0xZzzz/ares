package com.ares.service.message.observer;

import com.ares.model.Order;
import org.springframework.stereotype.Service;

/**
 * 通知用户
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
@Service
public class NotifyUserObserver extends AbstractOrderFinishObserver {

    @Override
    protected void doNotify(Order order) {
        System.out.println(String.format("观察者：通知用户。%s您好！您的订单%s已完成", order.getUserId(), order.getOrderId()));
    }

}
