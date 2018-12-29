package com.ares.service.message.handler.order;

import com.ares.model.Order;
import com.ares.model.OrderMessage;
import com.ares.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

/**
 * 取消订单状态处理
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
@Service
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
    protected void handle(OrderMessage message, Order order, Order updateParam) throws Exception {
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
        logger.info("您的订单已取消。userId: {}", userId);
    }

}
