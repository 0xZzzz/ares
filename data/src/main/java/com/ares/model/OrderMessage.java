package com.ares.model;

import lombok.Data;

/**
 * 订单消息实体
 * eg: {"orderId":1, "orderStatus":2, "orderType":2, "userId":1, "price":10, "paymentType":1}
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
@Data
public class OrderMessage {

    private Long orderId;

    private Integer orderStatus;

    private Integer orderType;

    private Long userId;

    private Long price;

    private Integer paymentType;

}
