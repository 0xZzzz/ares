package com.ares.enums;

import lombok.Getter;

/**
 * @author 0xzzzz
 * @date 2018/10/20
 */
public enum InvoiceTypeEnum {

    /**
     * 增票
     */
    GENERAL(1),

    /**
     * 普票
     */
    VAT(2);

    @Getter
    private int code;

    InvoiceTypeEnum(int code) {
        this.code = code;
    }
}
