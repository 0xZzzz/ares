package com.ares.controller;

import com.alibaba.fastjson.JSON;
import com.ares.common.utils.RocketMQUtils;
import com.ares.domain.OrderMessage;
import com.ares.enums.OrderStatusEnum;
import com.ares.enums.OrderTypeEnum;
import com.ares.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String send() {
        OrderMessage message = new OrderMessage();
        message.setOrderId(1L);
        message.setOrderStatus(OrderStatusEnum.CANCELED.getStatus());
        message.setOrderType(OrderTypeEnum.POP.getType());
        rocketMQUtils.send("order", JSON.toJSONString(message));
        return "OK";
    }

}
