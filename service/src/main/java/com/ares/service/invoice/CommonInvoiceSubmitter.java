package com.ares.service.invoice;

import com.ares.domain.Invoice;
import com.ares.domain.Order;
import com.ares.enums.OrderTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 通用发票提交
 *
 * @author 0xzzzz
 * @date 2018/10/22
 */
@Service
public class CommonInvoiceSubmitter extends AbstractSubmitterHandler {

    @Override
    protected boolean match(Order order, Invoice invoice) {
        return order.getOrderType() == OrderTypeEnum.SELF.getType();
    }

    @Override
    protected String doSubmit(Order order, Invoice invoice) {
        System.out.println("通用发票提交");
        return "common";
    }

}
