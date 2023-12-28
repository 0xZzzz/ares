package com.ares.service.message.handler.order;

import com.ares.domain.exception.SystemException;
import com.ares.enums.OrderStatusEnum;
import com.ares.domain.model.Order;
import com.ares.service.message.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 订单状态变更处理器
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public abstract class AbstractOrderStatusHandler implements OrderStatusHandler, InitializingBean {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(OrderMessage message, Order order) throws Exception {
        if (order.getOrderStatus().equals(message.getOrderStatus())) {
            // 订单状态未改变，直接返回，无需处理
            return;
        }
        validate(order.getOrderStatus());
        handle(message, order, getUpdateParam(order.getId()));
    }

    /**
     * 获取更新的参数
     *
     * @param orderId 订单id
     */
    private Order getUpdateParam(String orderId) {
        Order updateParam = new Order();
        updateParam.setId(orderId);
        updateParam.setOrderStatus(getSupportedOrderStatus().getStatus());
        return updateParam;
    }

    @Override
    public boolean match(OrderMessage message, Order order) {
        return getSupportedOrderStatus().getStatus() == message.getOrderStatus();
    }

    /**
     * 获取支持处理的订单状态
     *
     * @return 订单状态枚举值
     */
    protected abstract OrderStatusEnum getSupportedOrderStatus();

    /**
     * 获取订单状态
     *
     * @return 订单状态枚举值
     */
    protected abstract OrderStatusEnum getPreOrderStatus();

    /**
     * 校验消息状态
     *
     * @param preOrderStatus 订单修改之前的状态
     */
    protected void validate(Integer preOrderStatus) {
        if (getPreOrderStatus().getStatus() != preOrderStatus) {
            throw new SystemException("消息状态有误");
        }
    }

    /**
     * 处理
     *
     * @param message     订单消息实体
     * @param order       订单实体
     * @param updateParam 用于更新状态的参数
     * @throws Exception 处理异常
     */
    protected abstract void handle(OrderMessage message, Order order, Order updateParam) throws Exception;

    @Override
    public void afterPropertiesSet() throws Exception {
        OrderStatusHandlerChain.add(this);
    }
}
