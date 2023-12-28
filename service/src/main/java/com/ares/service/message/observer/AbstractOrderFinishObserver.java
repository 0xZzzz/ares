package com.ares.service.message.observer;

import com.ares.common.utils.Alarm;
import com.ares.domain.model.Order;
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
        Alarm.start();
        try {
            doNotify(order);
        } catch (Throwable e) {
            logger.error("notify error!", e);
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

}
