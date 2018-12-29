package com.ares.service.invoice;

import com.ares.model.Invoice;
import com.ares.model.Order;

/**
 * @author 0xzzzz
 * @date 2018/10/22
 */
public abstract class AbstractSubmitterHandler implements InvoiceSubmitter {

    private InvoiceSubmitter nextHandler;

    @Override
    public void submit(Order order, Invoice invoice) {
        if (match(order, invoice)) {
            String invoiceCode = doSubmit(order, invoice);
            invoice.setInvoiceCode(invoiceCode);
            updateInvoice(invoice);
            return;
        }
        if (nextHandler == null) {
            return;
        }
        nextHandler.submit(order, invoice);
    }

    @Override
    public void setNextHandler(InvoiceSubmitter handler) {
        this.nextHandler = handler;
    }

    /**
     * 发票发票状态和发票申请单编码
     *
     * @param invoice 发票实体
     */
    private void updateInvoice(Invoice invoice) {

    }

    /**
     * 匹配handler
     *
     * @param order   订单实体
     * @param invoice 发票实体
     * @return true：匹配，false：不匹配
     */
    protected abstract boolean match(Order order, Invoice invoice);

    /**
     * 提交
     *
     * @param order   订单实体
     * @param invoice 发票实体
     * @return 发票系统返回的申请单code
     */
    protected abstract String doSubmit(Order order, Invoice invoice);

}
