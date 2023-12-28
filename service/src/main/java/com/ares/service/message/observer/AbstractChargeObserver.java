package com.ares.service.message.observer;

import com.ares.enums.ChargeTypeEnum;
import com.ares.domain.model.Order;
import com.ares.service.settlement.ChargeRequest;
import com.ares.service.settlement.Selector;

/**
 * 计费观察者基类
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public abstract class AbstractChargeObserver extends AbstractOrderFinishObserver {

    @Override
    protected void doNotify(Order order) {
        if (!isNeedCharge(order)) {
            return;
        }
        ChargeRequest request = new ChargeRequest();
        request.setOrderId(order.getId());
        request.setUserId(order.getUserId());
        request.setChargeType(getChargeType().getType());
        processRequest(request, order);
        charge(request);
    }

    protected boolean isNeedCharge(Order order) {
        return order.getPrice() > 0;
    }

    /**
     * 获取计费类型
     *
     * @return 计费类型
     */
    protected abstract ChargeTypeEnum getChargeType();

    /**
     * 处理请求对象
     *
     * @param request 计费请求对象
     * @param order   订单实体
     */
    protected void processRequest(ChargeRequest request, Order order) {

    }

    /**
     * 计费服务调用
     *
     * @param request 计费请求
     */
    protected void charge(ChargeRequest request) {
        System.out.println("观察者：计费服务调用" + getChargeType().name());
        Selector.select(request.getChargeType()).settlement(request);
    }

}
