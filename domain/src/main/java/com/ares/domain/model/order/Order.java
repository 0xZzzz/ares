package com.ares.domain.model.order;

import com.ares.domain.base.Entity;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Getter
@ToString
public class Order extends Entity {

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
    private final Store store;

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
    private final Date createTime;

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
    private PayStatus payStatus;

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
    private final Long totalFee;

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
    private final Long discountFee;

    /**
     * 运费
     */
    private Long shippingFee;

    /**
     * 划线价
     */
    private final Long strikeThroughFee;

    /**
     * 买家留言
     */
    private String buyerMessage;

    /**
     * 买家备注，只对买家可见
     */
    private String buyerMemo;

    /**
     * 卖家备注，只对商家可见
     */
    private String sellerMemo;

    /**
     * 订单行
     */
    private final List<OrderLine> orderLines;

    /**
     * 履约单
     */
    private final DeliveryOrder deliveryOrder;

    public Order(String id,
                 Store store,
                 Buyer buyer,
                 Merchant merchant,
                 Date createTime,
                 Long totalFee,
                 Long shouldPayFee,
                 Long discountFee,
                 Long strikeThroughFee,
                 List<OrderLine> orderLines,
                 DeliveryOrder deliveryOrder) {
        super(id, 0);
        this.store = store;
        this.buyer = buyer;
        this.merchant = merchant;
        this.createTime = createTime;
        this.totalFee = totalFee;
        this.shouldPayFee = shouldPayFee;
        this.discountFee = discountFee;
        this.strikeThroughFee = strikeThroughFee;
        this.orderLines = orderLines;
        this.deliveryOrder = deliveryOrder;
    }

    public void adjustFee(Long adjustFee) {
        this.adjustFee = adjustFee;
        this.shouldPayFee -= adjustFee;
    }

}
