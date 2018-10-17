package com.ares.service.message.handler;

import com.ares.domain.Order;
import com.ares.domain.OrderMessage;
import com.ares.enums.OrderStatusEnum;

/**
 * 订单状态变更处理器
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
public abstract class AbstractOrderStatusHandler implements OrderStatusHandler {

    @Override
    public void handle(OrderMessage message, Order order) throws Exception {

    }

    @Override
    public boolean match(OrderMessage message, Order order) {
        return getOrderStatus().getStatus() == message.getOrderStatus();
    }

    /**
     * 获取订单状态
     *
     * @return 订单状态枚举值
     */
    protected abstract OrderStatusEnum getOrderStatus();

    /**
     * 获取订单状态
     *
     * @return 订单状态枚举值
     */
    protected abstract OrderStatusEnum getPreOrderStatus();

}
