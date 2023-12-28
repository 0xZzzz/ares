package com.ares.service.invoice;

import com.ares.enums.InvoiceTypeEnum;
import com.ares.enums.OrderTypeEnum;
import com.ares.service.message.Invoice;
import com.ares.service.message.Order;
import org.springframework.stereotype.Service;

/**
 * 普票提交
 *
 * @author 0xzzzz
 * @date 2018/10/22
 */
@Service
public class GeneralInvoiceSubmitter extends AbstractSubmitterHandler {

    @Override
    protected boolean match(Order order, Invoice invoice) {
        return order.getOrderType() == OrderTypeEnum.BOOK.getType()
            && invoice.getInvoiceType() == InvoiceTypeEnum.GENERAL.getCode();
    }

    @Override
    protected String doSubmit(Order order, Invoice invoice) {
        System.out.println("普票提交");
        return "general";
    }

}
