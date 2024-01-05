package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商家
 */
@Getter
@AllArgsConstructor
public class Merchant {

    /**
     * 商家id
     */
    private final String id;

    /**
     * 商家名称
     */
    private final String name;

}
