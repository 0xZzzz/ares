package com.ares.service.message.handler.order;

import com.ares.common.utils.Alarm;
import com.ares.domain.Order;
import com.ares.service.message.observer.OrderFinishObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 订单完成观察者基类
 *
 * @author 0xZzzz
 * @date 2018/10/17
 */
public abstract class AbstractOrderFinishObserver implements OrderFinishObserver, InitializingBean {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(Order order) {
        Alarm.start();
        try {
            logger.info("notify order: {}", order);
            doNotify(order);
        } catch (Throwable e) {
            logger.error("notify error! order: {}", order);
            Alarm.error();
        } finally {
            Alarm.end();
        }
    }

    /**
     * 通知
     *
     * @param order 订单实体
     */
    protected abstract void doNotify(Order order);

    @Override
    public void afterPropertiesSet() throws Exception {
        FinishOrderHandler.addObserver(this);
    }
}
