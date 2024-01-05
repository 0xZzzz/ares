package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 收货地址
 */
@Getter
@ToString
@AllArgsConstructor
public class ReceiverAddress {

    /**
     * 省
     */
    private AdministrativeDivision province;

    /**
     * 市
     */
    private AdministrativeDivision city;

    /**
     * 区
     */
    private AdministrativeDivision district;

    /**
     * 街道
     */
    private AdministrativeDivision town;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 邮政编码
     */
    private String postCode;

}
