package com.ares.infrastructure.pattern.decorator;

import lombok.Data;

/**
 * 商品
 *
 * @author  0xZzzz
 */
@Data
public class Item {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 净含量
     */
    private Long netWeight;

    public Item(String name, Long brandId, Long netWeight) {
        this.name = name;
        this.brandId = brandId;
        this.netWeight = netWeight;
    }

    public Item() {
    }
}
