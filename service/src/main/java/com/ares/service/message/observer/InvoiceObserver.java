package com.ares.service.message.observer;

import com.ares.model.Order;
import com.ares.service.invoice.InvoiceSubmitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发票提交
 *
 * @author 0xzzzz
 * @date 2018/10/22
 */
@Service
public class InvoiceObserver extends AbstractOrderFinishObserver {

    @Autowired
    private InvoiceSubmitHandler invoiceSubmitHandler;

    @Override
    protected void doNotify(Order order) {
        System.out.println("观察者：发票提交");
        invoiceSubmitHandler.submitRequisition(order);
    }

}
