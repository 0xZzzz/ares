package com.ares.service.settlement;

import lombok.Data;

/**
 * 计费信息
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Data
public class ChargeInfo {

    private Long orderId;

    private Long userId;

    private Integer chargeType;

    private Long chargePrice;

    private Integer orderType;

    private String requestId;

    private Long orgId;

}
