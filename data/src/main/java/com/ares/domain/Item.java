package com.ares.domain;

import lombok.Data;

/**
 * 商品
 *
 * @author fansheng
 */
@Data
public class Item {

    private String name;

    private Long brandId;

    private Long netWeight;

    public Item(String name, Long brandId, Long netWeight) {
        this.name = name;
        this.brandId = brandId;
        this.netWeight = netWeight;
    }

    public Item() {
    }
}
