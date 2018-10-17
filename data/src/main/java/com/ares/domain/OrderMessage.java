package com.ares.domain;

import lombok.Data;

/**
 * 订单消息实体
 *
 * @author 0xzzzz
 * @date 2018/10/16
 */
@Data
public class OrderMessage {

    private Long orderId;

    private Integer orderStatus;

    private Integer orderType;

}
