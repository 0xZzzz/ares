package com.ares.controller;

import com.alibaba.fastjson.JSON;
import com.ares.common.utils.RocketMQUtils;
import com.ares.model.OrderMessage;
import com.ares.enums.OrderTypeEnum;
import com.ares.enums.PaymentTypeEnum;
import com.ares.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 *
 * @author 0xZzzz
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RocketMQUtils rocketMQUtils;

    @RequestMapping("/test")
    public String test(String str) {
        return testService.test(str);
    }

    @RequestMapping("/send")
    public String send(Integer orderStatus) {
        OrderMessage message = new OrderMessage();
        message.setOrderId(1L);
        message.setOrderStatus(orderStatus);
        message.setOrderType(OrderTypeEnum.POP.getType());
        message.setUserId(1L);
        message.setPrice(10L);
        message.setPaymentType(PaymentTypeEnum.ONLINE.getCode());
        rocketMQUtils.send("order", JSON.toJSONString(message));
        return "OK";
    }

}
