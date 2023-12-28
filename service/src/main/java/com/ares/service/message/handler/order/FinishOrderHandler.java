package com.ares.service.message.handler.order;

import com.ares.service.message.Order;
import com.ares.service.message.OrderMessage;
import com.ares.enums.OrderStatusEnum;
import com.ares.service.message.observer.OrderFinishObserver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单完成处理器
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
@Service
public class FinishOrderHandler extends AbstractOrderStatusHandler implements ApplicationContextAware {

    private static List<OrderFinishObserver> observers;

    @Override
    protected OrderStatusEnum getSupportedOrderStatus() {
        return OrderStatusEnum.FINISHED;
    }

    @Override
    protected OrderStatusEnum getPreOrderStatus() {
        return OrderStatusEnum.WAITING_PAYMENT;
    }

    @Override
    protected void handle(OrderMessage message, Order order, Order updateParam) throws Exception {
        finishOrder(updateParam);
        notifyObserver(order);
    }

    /**
     * 完成订单
     *
     * @param updateParam 更新订单参数
     */
    private void finishOrder(Order updateParam) {
        logger.info("您的订单已完成。orderId: {}", updateParam.getOrderId());
    }

    /**
     * 通知观察者
     *
     * @param order 订单实体
     */
    private void notifyObserver(Order order) {
        observers.forEach(observer -> observer.notify(order));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        observers = new ArrayList<>();
        observers.addAll(applicationContext.getBeansOfType(OrderFinishObserver.class).values());
    }
}
