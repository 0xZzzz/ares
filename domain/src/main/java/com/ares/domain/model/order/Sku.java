package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 商品
 */
@Getter
@ToString
@AllArgsConstructor
public class Sku {

    /**
     * sku id
     */
    private final String id;

    /**
     * sku 标题
     */
    private final String title;

    /**
     * 商品id
     */
    private final String itemId;

    /**
     * 类目id
     */
    private final String categoryId;

    /**
     * 主图地址
     */
    private final String mainImageUrl;

    /**
     * 商详页地址
     */
    private final String detailPageUrl;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private Long unitPrice;

    /**
     * 划线价
     */
    private Long strikeThroughFee;

    /**
     * 应付
     */
    private Long shouldPayFee;

    /**
     * 优惠金额
     */
    private Long discountFee;

    /**
     * 改价
     */
    private Long adjustFee;

}
