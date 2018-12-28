package com.ares.service.message.handler.order;

import com.ares.domain.Order;
import com.ares.domain.OrderMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单状态处理链
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public class OrderStatusHandlerChain {

    private static final List<OrderStatusHandler> HANDLER_LIST = new ArrayList<>();

    public static void add(OrderStatusHandler handler) {
        HANDLER_LIST.add(handler);
    }

    /**
     * 处理订单
     *
     * @param order   订单实体
     * @param message 订单消息实体
     * @throws Exception 处理异常
     */
    public static void handle(OrderMessage message, Order order) throws Exception {
        for (OrderStatusHandler handler : HANDLER_LIST) {
            if (handler.match(message, order)) {
                handler.handle(message, order);
                return;
            }
        }
    }

}
