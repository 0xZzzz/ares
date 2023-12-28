package com.ares.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单实体
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
@Getter
@Setter
@ToString
public class Order {

    /**
     * 订单id
     */
    private String id;

    /**
     * 店铺id
     */
    private String storeId;

    /**
     * 店铺名称
     */
    private String storeName;

    private Integer orderStatus;

    private Long userId;

    private Long price;

    /**
     * 商品扣点
     */
    private Double commission;

    /**
     * 支付方式
     */
    private Integer paymentType;

    private Integer orderType;

    public Order() {
    }

}
