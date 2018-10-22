package com.ares.service.invoice;

import com.ares.domain.Invoice;
import com.ares.domain.Order;
import com.ares.enums.InvoiceTypeEnum;
import com.ares.enums.OrderTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 增票提交
 *
 * @author 0xzzzz
 * @date 2018/10/22
 */
@Service
public class VatInvoiceSubmitter extends AbstractSubmitterHandler {

    @Override
    protected boolean match(Order order, Invoice invoice) {
        return order.getOrderType() == OrderTypeEnum.BOOK.getType()
            && invoice.getInvoiceType() == InvoiceTypeEnum.VAT.getCode();
    }

    @Override
    protected String doSubmit(Order order, Invoice invoice) {
        System.out.println("增票提交");
        return "general";
    }

}
