package com.ares.infrastructure.pattern.observer;

import com.ares.domain.model.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单完成观察者基类
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
public abstract class AbstractOrderFinishObserver implements OrderFinishObserver {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(Order order) {
        try {
            doNotify(order);
        } catch (Throwable e) {
            logger.error("notify error!", e);
        }
    }

    /**
     * 通知
     *
     * @param order 订单实体
     */
    protected abstract void doNotify(Order order);

}
