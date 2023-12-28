package com.ares.service.message.observer;

import com.ares.domain.model.order.Order;

/**
 * 订单完成观察者
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
public interface OrderFinishObserver {

    /**
     * 订单完成通知
     *
     * @param order 订单实体
     */
    void notify(Order order);

}
