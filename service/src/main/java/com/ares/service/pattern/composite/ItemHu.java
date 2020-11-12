package com.ares.service.pattern.composite;

import lombok.ToString;

/**
 * 商品 HU
 *
 * @author fansheng
 * @date 2020/11/12
 */
@ToString(callSuper = true)
public class ItemHu extends BaseHu {

    /**
     * 商品条码
     */
    private final String barcode;

    /**
     * 商品ID
     */
    private final Long itemId;

    public ItemHu(Long id, Long warehouseId, Long weight, Long itemId, String barcode) {
        super(id, warehouseId, weight);
        this.itemId = itemId;
        this.barcode = barcode;
    }

    @Override
    public long calculateTotalWeight() {
        return weight;
    }

}
