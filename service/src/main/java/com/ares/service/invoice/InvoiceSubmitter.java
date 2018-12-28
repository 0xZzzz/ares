package com.ares.service.invoice;

import com.ares.domain.Invoice;
import com.ares.domain.Order;

/**
 * 发票提交
 *
 * @author 0xzzzz
 * @date 2018/10/20
 */
public interface InvoiceSubmitter {

    /**
     * 提交发票
     *
     * @param order   订单
     * @param invoice 发票
     */
    void submit(Order order, Invoice invoice);

    /**
     * 设置下一个handler
     *
     * @param handler handler处理器
     */
    void setNextHandler(InvoiceSubmitter handler);

}
