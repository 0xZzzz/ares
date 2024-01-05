package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 收货人信息
 */
@Getter
@ToString
@AllArgsConstructor
public class Receiver {

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 收货地址信息
     */
    private ReceiverAddress address;

}
