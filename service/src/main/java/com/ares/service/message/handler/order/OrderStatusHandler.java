package com.ares.service.message.handler.order;

import com.ares.model.Order;
import com.ares.model.OrderMessage;

/**
 * 订单状态处理
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public interface OrderStatusHandler {

    /**
     * 处理
     *
     * @param message 订单消息实体
     * @param order   订单实体
     * @throws Exception 处理异常
     */
    void handle(OrderMessage message, Order order) throws Exception;

    /**
     * 匹配处理器
     *
     * @param message 订单消息实体
     * @param order   订单实体
     * @return true：匹配，false：
     */
    boolean match(OrderMessage message, Order order);

}
