package com.ares.infrastructure.pattern.decorator;

import java.util.List;

/**
 * 货架陈列规则
 *
 * @author 0xZzzz
 * @date 2018/10/18
 */
public interface ShelfDisplayRule {

    /**
     * 执行规则
     *
     * @param selectedItems 选品列表
     * @return 规则执行后的商品陈列列表
     */
    List<List<Item>> execute(List<Item> selectedItems);

}
