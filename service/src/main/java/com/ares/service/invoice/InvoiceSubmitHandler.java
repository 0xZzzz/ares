package com.ares.service.invoice;

import com.ares.enums.InvoiceTypeEnum;
import com.ares.service.message.Invoice;
import com.ares.service.message.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 发票提交责任链
 *
 * @author 0xZzzz
 */
@Service
@Slf4j
public class InvoiceSubmitHandler {

    @Qualifier("commonInvoiceSubmitter")
    @Autowired
    private InvoiceSubmitter commonInvoiceSubmitter;

    @Qualifier("generalInvoiceSubmitter")
    @Autowired
    private InvoiceSubmitter generalInvoiceSubmitter;

    @Qualifier("vatInvoiceSubmitter")
    @Autowired
    private InvoiceSubmitter vatInvoiceSubmitter;

    /**
     * 初始化链条，设置handler的下一个handler
     */
    @PostConstruct
    public void init() {
        commonInvoiceSubmitter.setNextHandler(generalInvoiceSubmitter);
        generalInvoiceSubmitter.setNextHandler(vatInvoiceSubmitter);
    }

    /**
     * 提交发票申请单
     *
     * @param order 订单实体
     */
    public void submitRequisition(Order order) {
        Invoice invoice = getInvoice(order.getOrderId());
        if (invoice == null) {
            return; //这里为null说明这笔订单不需要开发票，直接返回
        }
        commonInvoiceSubmitter.submit(order, invoice);
    }

    /**
     * 获取发票信息
     *
     * @param orderId 订单id
     * @return 发票信息
     */
    private Invoice getInvoice(Long orderId) {
        Invoice invoice = new Invoice();
        invoice.setOrderId(orderId);
        invoice.setInvoiceType(InvoiceTypeEnum.VAT.getCode());
        return invoice;
    }

}
