package com.ares.service.message.handler.order;

import com.alibaba.fastjson.JSON;
import com.ares.domain.model.Order;
import com.ares.service.message.OrderMessage;
import com.ares.enums.OrderStatusEnum;
import com.ares.enums.OrderTypeEnum;
import com.ares.service.message.handler.AbstractSingleMessageHandler;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 订单消息处理器
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
@Service
public class OrderMessageHandler extends AbstractSingleMessageHandler<OrderMessage> {

    @Override
    protected OrderMessage parse(MessageExt message) {
        return JSON.parseObject(message.getBody(), OrderMessage.class);
    }

    @Override
    protected boolean validate(OrderMessage m) {
        return super.validate(m) && OrderTypeEnum.contains(m.getOrderType());
    }

    @Override
    protected void handle(MessageExt message, OrderMessage domain) throws Exception {
        OrderStatusHandlerChain.handle(domain, fromDB(domain));
    }

    /**
     * DB查询订单
     *
     * @param domain 订单消息
     * @return 订单实体
     */
    private Order fromDB(OrderMessage domain) {
        Order order = new Order();
        BeanUtils.copyProperties(domain, order);
        order.setOrderStatus(OrderStatusEnum.WAITING_PAYMENT.getStatus());
        order.setCommission(0.1);
        logger.info("handle order: {}", order);
        return order;
    }

}
