package com.ares.service.message;

import lombok.Data;

/**
 * 发票
 *
 * @author 0xzzzz
 * @date 2018/10/20
 */
@Data
public class Invoice {

    private Long id;

    private Double rate;

    /**
     * 资质信息
     */
    private String qualification;

    private String address;

    private Integer invoiceType;

    private Long price;

    private String invoiceCode;

    private Long orderId;

}
