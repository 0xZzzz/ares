package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Getter
@ToString
@AllArgsConstructor
public class Order {

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 订单id
     */
    private String id;

    /**
     * 订单快照id
     */
    private String snapshotId;

    /**
     * 支付单id
     */
    private String paymentOrderId;

    /**
     * 店铺信息
     */
    private Store store;

    /**
     * 买家信息
     */
    private final Buyer buyer;

    /**
     * 商家信息
     */
    private final Merchant merchant;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单完结时间
     */
    private Date endTime;

    /**
     * 订单状态
     */
    private OrderStatus orderStatus;

    /**
     * 买家评价状态
     */
    private EvaluationStatus buyerEvaluationStatus;

    /**
     * 卖家评价状态
     */
    private EvaluationStatus sellerEvaluationStatus;

    /**
     * 订单总价
     */
    private Long totalFee;

    /**
     * 改价金额
     */
    private Long adjustFee;

    /**
     * 实付金额
     */
    private Long paidFee;

    /**
     * 应付金额
     */
    private Long shouldPayFee;

    /**
     * 优惠金额
     */
    private Long discountFee;

    /**
     * 运费
     */
    private Long shippingFee;

    /**
     * 划线价
     */
    private Long strikeThroughFee;

    /**
     * 买家备注
     */
    private String buyerMemo;

    /**
     * 卖家备注
     */
    private String sellerMemo;

    /**
     * 订单行
     */
    private List<OrderLine> orderLines;

}
