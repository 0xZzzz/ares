package com.ares.service.message.handler.order;

import com.ares.domain.Order;
import com.ares.domain.OrderMessage;
import com.ares.enums.OrderStatusEnum;
import com.ares.service.message.observer.OrderFinishObserver;
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
public class FinishOrderHandler extends AbstractOrderStatusHandler {

    private static List<OrderFinishObserver> observers = new ArrayList<>();

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
        System.out.println("完成订单" + updateParam.getOrderId());
    }

    /**
     * 添加观察者
     *
     * @param observer 观察者对象
     */
    public static void addObserver(OrderFinishObserver observer) {
        observers.add(observer);
    }

    /**
     * 通知观察者
     *
     * @param order 订单实体
     */
    private static void notifyObserver(Order order) {
        observers.forEach(observer -> observer.notify(order));
    }

}
