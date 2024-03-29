package com.ares.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 店铺
 */
@Getter
@AllArgsConstructor
public class Store {

    /**
     * 店铺id
     */
    private final String id;

    /**
     * 店铺名称
     */
    private final String name;

}
