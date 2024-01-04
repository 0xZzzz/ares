package com.ares.infrastructure.pattern.strategy;

import lombok.Data;

/**
 * 计费请求
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Data
public class ChargeRequest {

    private String orderId;

    private Long userId;

    private Integer chargeType;

    private Long chargePrice;

    private Integer orderType;

    private String requestId;

}
