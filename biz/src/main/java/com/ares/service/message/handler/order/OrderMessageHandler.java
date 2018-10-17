package com.ares.service.message.handler.order;

import com.alibaba.fastjson.JSON;
import com.ares.domain.Order;
import com.ares.domain.OrderMessage;
import com.ares.enums.OrderTypeEnum;
import com.ares.service.message.handler.AbstractSingleMessageHandler;
import org.apache.rocketmq.common.message.MessageExt;
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
        OrderStatusHandlerChain.handle(domain, fromDB(domain.getOrderId()));
    }

    /**
     * DB查询订单
     *
     * @param orderId 订单id
     * @return 订单实体
     */
    private Order fromDB(Long orderId) {
        // DB查询
        return new Order(orderId);
    }

}
