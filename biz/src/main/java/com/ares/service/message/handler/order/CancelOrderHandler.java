package com.ares.service.message.handler.order;

import com.ares.domain.Order;
import com.ares.domain.OrderMessage;
import com.ares.enums.OrderStatusEnum;

/**
 * 取消订单状态处理
 *
 * @author 0xzzzz
 * @date 2018/10/17
 */
public class CancelOrderHandler extends AbstractOrderStatusHandler {

    @Override
    protected OrderStatusEnum getSupportedOrderStatus() {
        return OrderStatusEnum.CANCELED;
    }

    @Override
    protected OrderStatusEnum getPreOrderStatus() {
        return OrderStatusEnum.WAITING_PAYMENT;
    }

    @Override
    protected void handle(OrderMessage message, Order order, Order updateParam) {
        cancelOrder(updateParam);
        notifyUser(order.getUserId());
    }

    /**
     * 取消订单
     *
     * @param updateParam 更新参数
     */
    private void cancelOrder(Order updateParam) {
        System.out.println("取消订单" + updateParam.getOrderId());
    }

    /**
     * 通知用户
     *
     * @param userId 用户id
     */
    private void notifyUser(Long userId) {
        System.out.println(userId + "您的订单已取消");
    }

}
